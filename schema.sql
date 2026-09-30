-- ============================================================
-- Event Ticketing Database Schema
-- PostgreSQL
-- ============================================================

CREATE EXTENSION IF NOT EXISTS pgcrypto;


-- ============================================================
-- 1. USERS
-- ============================================================

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    email VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    name VARCHAR(150) NOT NULL,

    role VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT uk_users_email
        UNIQUE (email),

    CONSTRAINT chk_users_role
        CHECK (role IN ('CUSTOMER', 'ORGANIZER', 'ADMIN')),

    CONSTRAINT chk_users_status
        CHECK (status IN ('ACTIVE', 'INACTIVE', 'SUSPENDED'))
);


-- ============================================================
-- 2. EVENT CATEGORIES
-- ============================================================

CREATE TABLE event_categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    name VARCHAR(100) NOT NULL,
    slug VARCHAR(120) NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT uk_event_categories_name
        UNIQUE (name),

    CONSTRAINT uk_event_categories_slug
        UNIQUE (slug)
);


-- ============================================================
-- 3. VENUES
-- ============================================================

CREATE TABLE venues (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    name VARCHAR(200) NOT NULL,

    address TEXT NOT NULL,
    city VARCHAR(100) NOT NULL,
    province VARCHAR(100),
    country VARCHAR(100) NOT NULL DEFAULT 'Indonesia',

    latitude NUMERIC(10, 7),
    longitude NUMERIC(10, 7),

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT chk_venues_latitude
        CHECK (
            latitude IS NULL
            OR latitude BETWEEN -90 AND 90
        ),

    CONSTRAINT chk_venues_longitude
        CHECK (
            longitude IS NULL
            OR longitude BETWEEN -180 AND 180
        )
);


-- ============================================================
-- 4. EVENTS
-- ============================================================

CREATE TABLE events (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    organizer_id UUID NOT NULL,
    category_id UUID NOT NULL,
    venue_id UUID NOT NULL,

    name VARCHAR(255) NOT NULL,
    slug VARCHAR(280) NOT NULL,
    description TEXT,

    start_at TIMESTAMPTZ NOT NULL,
    end_at TIMESTAMPTZ NOT NULL,

    status VARCHAR(20) NOT NULL DEFAULT 'DRAFT',

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT uk_events_slug
        UNIQUE (slug),

    CONSTRAINT fk_events_organizer
        FOREIGN KEY (organizer_id)
        REFERENCES users(id),

    CONSTRAINT fk_events_category
        FOREIGN KEY (category_id)
        REFERENCES event_categories(id),

    CONSTRAINT fk_events_venue
        FOREIGN KEY (venue_id)
        REFERENCES venues(id),

    CONSTRAINT chk_events_date
        CHECK (end_at > start_at),

    CONSTRAINT chk_events_status
        CHECK (
            status IN (
                'DRAFT',
                'PUBLISHED',
                'SOLD_OUT',
                'CANCELLED',
                'COMPLETED'
            )
        )
);


-- ============================================================
-- 5. EVENT IMAGES
-- ============================================================

CREATE TABLE event_images (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    event_id UUID NOT NULL,

    image_url TEXT NOT NULL,
    image_type VARCHAR(20) NOT NULL DEFAULT 'BANNER',
    display_order INTEGER NOT NULL DEFAULT 0,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_event_images_event
        FOREIGN KEY (event_id)
        REFERENCES events(id)
        ON DELETE CASCADE,

    CONSTRAINT chk_event_images_type
        CHECK (
            image_type IN (
                'BANNER',
                'THUMBNAIL',
                'GALLERY'
            )
        ),

    CONSTRAINT chk_event_images_display_order
        CHECK (display_order >= 0)
);


-- ============================================================
-- 6. TICKET TYPES
-- ============================================================

CREATE TABLE ticket_types (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    event_id UUID NOT NULL,

    name VARCHAR(150) NOT NULL,
    description TEXT,

    price NUMERIC(15, 2) NOT NULL,

    quota INTEGER NOT NULL,
    sold_quantity INTEGER NOT NULL DEFAULT 0,

    sales_start_at TIMESTAMPTZ NOT NULL,
    sales_end_at TIMESTAMPTZ NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_ticket_types_event
        FOREIGN KEY (event_id)
        REFERENCES events(id)
        ON DELETE CASCADE,

    CONSTRAINT chk_ticket_types_price
        CHECK (price >= 0),

    CONSTRAINT chk_ticket_types_quota
        CHECK (quota > 0),

    CONSTRAINT chk_ticket_types_sold_quantity
        CHECK (
            sold_quantity >= 0
            AND sold_quantity <= quota
        ),

    CONSTRAINT chk_ticket_types_sales_period
        CHECK (sales_end_at > sales_start_at),

    CONSTRAINT uk_ticket_types_event_name
        UNIQUE (event_id, name)
);


-- ============================================================
-- 7. ORDERS
-- ============================================================

CREATE TABLE orders (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    order_number VARCHAR(50) NOT NULL,

    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',

    total_amount NUMERIC(15, 2) NOT NULL,

    expires_at TIMESTAMPTZ,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT uk_orders_order_number
        UNIQUE (order_number),

    CONSTRAINT fk_orders_user
        FOREIGN KEY (user_id)
        REFERENCES users(id),

    CONSTRAINT chk_orders_total_amount
        CHECK (total_amount >= 0),

    CONSTRAINT chk_orders_status
        CHECK (
            status IN (
                'PENDING',
                'PAID',
                'EXPIRED',
                'CANCELLED',
                'REFUNDED'
            )
        )
);


-- ============================================================
-- 8. ORDER ITEMS
-- ============================================================

CREATE TABLE order_items (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    order_id UUID NOT NULL,
    ticket_type_id UUID NOT NULL,

    quantity INTEGER NOT NULL,
    unit_price NUMERIC(15, 2) NOT NULL,
    subtotal NUMERIC(15, 2) NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_order_items_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_order_items_ticket_type
        FOREIGN KEY (ticket_type_id)
        REFERENCES ticket_types(id),

    CONSTRAINT chk_order_items_quantity
        CHECK (quantity > 0),

    CONSTRAINT chk_order_items_unit_price
        CHECK (unit_price >= 0),

    CONSTRAINT chk_order_items_subtotal
        CHECK (subtotal >= 0),

    CONSTRAINT uk_order_items_order_ticket_type
        UNIQUE (order_id, ticket_type_id)
);


-- ============================================================
-- 9. PAYMENTS
-- ============================================================

CREATE TABLE payments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    order_id UUID NOT NULL,

    payment_reference VARCHAR(150) NOT NULL,

    amount NUMERIC(15, 2) NOT NULL,

    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',

    paid_at TIMESTAMPTZ,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT uk_payments_reference
        UNIQUE (payment_reference),

    CONSTRAINT fk_payments_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id),

    CONSTRAINT chk_payments_amount
        CHECK (amount >= 0),

    CONSTRAINT chk_payments_status
        CHECK (
            status IN (
                'PENDING',
                'SUCCESS',
                'FAILED',
                'EXPIRED',
                'REFUNDED'
            )
        )
);


-- ============================================================
-- 10. TICKETS
-- ============================================================

CREATE TABLE tickets (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    order_item_id UUID NOT NULL,

    ticket_code VARCHAR(100) NOT NULL,

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    issued_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    used_at TIMESTAMPTZ,

    CONSTRAINT uk_tickets_ticket_code
        UNIQUE (ticket_code),

    CONSTRAINT fk_tickets_order_item
        FOREIGN KEY (order_item_id)
        REFERENCES order_items(id),

    CONSTRAINT chk_tickets_status
        CHECK (
            status IN (
                'ACTIVE',
                'USED',
                'CANCELLED',
                'TRANSFERRED'
            )
        )
);


-- ============================================================
-- INDEXES
-- ============================================================

-- USERS
CREATE INDEX idx_users_role
    ON users(role);

CREATE INDEX idx_users_status
    ON users(status);


-- VENUES
CREATE INDEX idx_venues_city
    ON venues(city);


-- EVENTS
CREATE INDEX idx_events_organizer
    ON events(organizer_id);

CREATE INDEX idx_events_category
    ON events(category_id);

CREATE INDEX idx_events_venue
    ON events(venue_id);

CREATE INDEX idx_events_status
    ON events(status);

CREATE INDEX idx_events_start_at
    ON events(start_at);

CREATE INDEX idx_events_category_status_start
    ON events(category_id, status, start_at);

CREATE INDEX idx_events_published_start_at
    ON events(start_at)
    WHERE status = 'PUBLISHED';


-- EVENT IMAGES
CREATE INDEX idx_event_images_event
    ON event_images(event_id, display_order);


-- TICKET TYPES
CREATE INDEX idx_ticket_types_event
    ON ticket_types(event_id);

CREATE INDEX idx_ticket_types_sales_period
    ON ticket_types(sales_start_at, sales_end_at);


-- ORDERS
CREATE INDEX idx_orders_user
    ON orders(user_id);

CREATE INDEX idx_orders_status
    ON orders(status);

CREATE INDEX idx_orders_user_created_at
    ON orders(user_id, created_at DESC);

CREATE INDEX idx_orders_expiration
    ON orders(status, expires_at);


-- ORDER ITEMS
CREATE INDEX idx_order_items_order
    ON order_items(order_id);

CREATE INDEX idx_order_items_ticket_type
    ON order_items(ticket_type_id);


-- PAYMENTS
CREATE INDEX idx_payments_order
    ON payments(order_id);

CREATE INDEX idx_payments_status
    ON payments(status);


-- TICKETS
CREATE INDEX idx_tickets_order_item
    ON tickets(order_item_id);

CREATE INDEX idx_tickets_status
    ON tickets(status);

CREATE INDEX idx_tickets_used_at
    ON tickets(used_at);
