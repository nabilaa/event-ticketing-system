CREATE DATABASE IF NOT EXISTS ticket_booking;

USE ticket_booking;

CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,

    role VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);


CREATE TABLE IF NOT EXISTS event_categories (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    parent_id INTEGER,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200),

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);


CREATE TABLE IF NOT EXISTS venues (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(200) NOT NULL,

    address TEXT NOT NULL,
    city VARCHAR(100) NOT NULL,
    province VARCHAR(100),
    country VARCHAR(100) NOT NULL DEFAULT 'Indonesia',

    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);


CREATE TABLE IF NOT EXISTS events (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(200) NOT NULL,
    description TEXT,
    
    organizer_username VARCHAR(100) NOT NULL,
    category_id INTEGER NOT NULL,
    venue_id INTEGER NOT NULL,

    start_at DATETIME(6) NOT NULL,
    end_at DATETIME(6) NOT NULL,

    status VARCHAR(20) NOT NULL DEFAULT 'DRAFT',

    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),

    FOREIGN KEY (organizer_username) REFERENCES users(username),
    FOREIGN KEY (category_id) REFERENCES event_categories(id),
    FOREIGN KEY (venue_id) REFERENCES venues(id)
);


INSERT INTO `users` (`username`, `email`, `password_hash`, `role`, `status`) VALUES
('admin', 'admin@example.com', SHA2(CONCAT(UUID(), UUID()), 256), 'ADMIN', 'ACTIVE'),
('jakarta_organizer', 'organizer@example.com', SHA2(CONCAT(UUID(), UUID()), 256), 'ORGANIZER', 'ACTIVE'),
('customer', 'customer@example.com', SHA2(CONCAT(UUID(), UUID()), 256), 'CUSTOMER', 'ACTIVE');


INSERT INTO `venues` (`id`, `name`, `address`, `city`, `province`, `country`, `latitude`, `longitude`) VALUES
(1, 'Jakarta Convention Center', 'Jl. Gatot Subroto, Gelora, Tanah Abang', 'Jakarta', 'DKI Jakarta', 'Indonesia', -6.2190, 106.8025),
(2, 'Jakarta International Expo', 'Arena JIExpo Kemayoran, Jl. H. Benyamin Sueb', 'Jakarta', 'DKI Jakarta', 'Indonesia', -6.1468, 106.8456),
(3, 'Taman Ismail Marzuki', 'Jl. Cikini Raya No. 73, Cikini, Menteng', 'Jakarta', 'DKI Jakarta', 'Indonesia', -6.1907, 106.8390),
(4, 'Istora Senayan', 'Jl. Pintu Satu Senayan, Gelora, Tanah Abang', 'Jakarta', 'DKI Jakarta', 'Indonesia', -6.2184, 106.8017),
(5, 'ICE BSD City Hall 6 & 7', 'Hall 6 & 7, ICE BSD City, Pagedangan', 'Tangerang', 'Banten', 'Indonesia', NULL, NULL),
(6, 'Yogyakarta Marriott Hotel', 'Jl. Ring Road Utara', 'Yogyakarta', 'Daerah Istimewa Yogyakarta', 'Indonesia', NULL, NULL),
(7, 'Online Event', 'Online event', 'Online', NULL, 'Indonesia', NULL, NULL),
(8, 'The Kasablanka', 'Jl. Raya Casablanca No. 88, Menteng Dalam, Tebet', 'Jakarta', 'DKI Jakarta', 'Indonesia', NULL, NULL);

INSERT INTO `event_categories` (`id`, `parent_id`, `name`, `description`) VALUES
(1, NULL, 'Music & Concerts', 'Live music performances, festivals, and concerts across all genres.'),
(2, NULL, 'Business & Tech', 'Conferences, networking events, workshops, and startup summits.'),
(3, NULL, 'Arts & Theatre', 'Plays, stand-up comedy, art exhibitions, and cultural performances.'),
(4, NULL, 'Sports & Fitness', 'Marathons, live sporting matches, fitness bootcamps, and yoga sessions.'),
(5, NULL, 'Food & Drink', 'Wine tastings, food festivals, cooking classes, and dining experiences.');

INSERT INTO `event_categories` (`parent_id`, `name`, `description`) VALUES
(1, 'Rock & Indie', 'Live rock bands and indie alternative showcases.'),
(1, 'K-pop', 'K-pop concerts, fan events, and dance performances.'),
(1, 'Jazz & Classical', 'Orchestras, jazz clubs, and acoustic performances.'),
(2, 'Tech Conferences', 'Seminars focusing on software, AI, hardware, and web dev.'),
(2, 'Networking Events', 'Meetups to expand your professional network.'),
(3, 'Comedy & Stand-up', 'Stand-up comedy nights and improv shows.'),
(3, 'Theater & Musicals', 'Broadways, local plays, and musical theater.'),
(4, 'Running & Marathons', '5Ks, half-marathons, and community runs.'),
(4, 'Yoga & Wellness', 'Mindfulness, yoga, and mental health workshops.'),
(5, 'Traditional Food Festival', 'Festivals celebrating traditional cuisine, regional dishes, and food traditions.'),
(5, 'Cooking Classes', 'Hands-on culinary workshops led by local chefs.');


INSERT INTO `events` (`name`, `description`, `organizer_username`, `category_id`, `venue_id`, `start_at`, `end_at`, `status`) VALUES
('Snada Indonesia 2026', 'Indonesian musicians perform with orchestral arrangements under the theme Suara Dari Timur.', 'jakarta_organizer', 1, 4, '2026-10-10 15:00:00', '2026-10-10 22:00:00', 'PUBLISHED'),
('BADONCI FESTIVAL DISK.2', 'Music festival featuring live performances in Manado.', 'jakarta_organizer', 1, 2, '2026-10-15 14:00:00', '2026-10-15 23:30:00', 'PUBLISHED'),
('Certified International Trade, Shipping & Logistics Professional (CITLP)', 'Online professional certification training focused on international trade, shipping, and logistics.', 'jakarta_organizer', 2, 7, '2026-10-05 08:30:00', '2026-10-07 16:00:00', 'PUBLISHED'),
('Certified International Procurement Professional (CIPP)', 'Online professional certification training for procurement and purchasing.', 'jakarta_organizer', 2, 7, '2026-11-02 08:30:00', '2026-11-04 16:00:00', 'PUBLISHED'),
('Certified International Supply Chain Professional (CISCP)', 'Online professional certification training for supply chain and logistics.', 'jakarta_organizer', 2, 7, '2026-11-09 08:30:00', '2026-11-11 16:00:00', 'PUBLISHED'),
('Home Sweet Loan The Musical [Rabu, 7 Oktober 2026]', 'A musical theatre adaptation of the story of Kaluna and her family.', 'jakarta_organizer', 3, 3, '2026-10-07 19:30:00', '2026-10-07 22:00:00', 'PUBLISHED'),
('Njonja Ati Soetji', 'A stage performance about the life and humanitarian work of Nyonya Lie Tjian Tjoen.', 'jakarta_organizer', 3, 3, '2026-10-30 19:30:00', '2026-10-30 22:00:00', 'PUBLISHED'),
('HYBRID RACE SIMULATION @ ISFEX', 'A multi-day fitness race combining running laps with functional training stations.', 'jakarta_organizer', 4, 5, '2026-11-05 09:30:00', '2026-11-08 20:30:00', 'PUBLISHED'),
('Road To Give Yogyakarta 2026 - United In Motion', 'A 5K charity run supporting community causes.', 'jakarta_organizer', 4, 6, '2026-10-18 05:00:00', '2026-10-18 09:00:00', 'PUBLISHED'),
('KOTA PODOMORO TENJO COOKING COMPETITION', 'A cooking competition hosted at the Kota Podomoro Tenjo marketing gallery.', 'jakarta_organizer', 5, 2, '2026-10-18 11:00:00', '2026-10-18 17:00:00', 'PUBLISHED'),
('Online Baking Class "SALT BREAD" Chef Rozma Suhardi', 'An online baking class covering salt bread preparation and baking techniques.', 'jakarta_organizer', 5, 7, '2026-10-01 09:25:00', '2026-12-03 12:25:00', 'PUBLISHED'),
('SOUNDCHECK Vol.1', 'A K-pop fan event with karaoke, random play dance, and DJ sets.', 'jakarta_organizer', 7, 8, '2026-10-09 20:30:00', '2026-10-09 23:55:00', 'PUBLISHED'),
('ROSETOPIA ASIA TOUR 2026 IN JAKARTA', 'The Rose performs its ROSETOPIA tour in Jakarta.', 'jakarta_organizer', 7, 8, '2026-10-23 20:00:00', '2026-10-23 21:30:00', 'PUBLISHED');
