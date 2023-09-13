CREATE TABLE admin
(
    id            BIGSERIAL PRIMARY KEY,
    email         TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    name          TEXT NOT NULL
);

CREATE TABLE client
(
    id            BIGSERIAL PRIMARY KEY,
    email         TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    first_name    TEXT NOT NULL,
    last_name     TEXT NOT NULL
);

CREATE TABLE country
(
    id       BIGSERIAL PRIMARY KEY,
    name     TEXT   NOT NULL,
    admin_id BIGINT NOT NULL REFERENCES admin
);

CREATE TABLE hotel
(
    id       BIGSERIAL PRIMARY KEY,
    name     TEXT    NOT NULL,
    stars    INTEGER NOT NULL,
    features TEXT    NOT NULL,
    admin_id BIGINT  NOT NULL REFERENCES admin
);

CREATE TABLE tour
(
    id          BIGSERIAL PRIMARY KEY,
    date        DATE             NOT NULL,
    duration    INTEGER          NOT NULL,
    description TEXT             NOT NULL,
    cost        DOUBLE PRECISION NOT NULL,
    tour_type   TEXT             NOT NULL,
    hotel_id    BIGINT           NOT NULL REFERENCES hotel,
    country_id  BIGINT           NOT NULL REFERENCES country,
    admin_id    BIGINT           NOT NULL REFERENCES admin
);

CREATE TABLE review
(
    id         BIGSERIAL PRIMARY KEY,
    content    TEXT      NOT NULL,
    created_at TIMESTAMP NOT NULL,
    client_id  BIGINT    NOT NULL REFERENCES client,
    tour_id    BIGINT    NOT NULL REFERENCES tour,
    UNIQUE (client_id, tour_id)
);

CREATE TABLE tour_client
(
    tour_id   BIGINT NOT NULL REFERENCES tour (id),
    client_id BIGINT NOT NULL REFERENCES client (id),
    PRIMARY KEY (tour_id, client_id)
);