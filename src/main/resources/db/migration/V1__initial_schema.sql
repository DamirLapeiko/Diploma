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
    id   BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE hotel
(
    id       BIGSERIAL PRIMARY KEY,
    name     TEXT   NOT NULL,
    stars    BIGINT NOT NULL,
    features TEXT   NOT NULL
);

CREATE TABLE tour
(
    id          BIGSERIAL PRIMARY KEY,
    date        BIGINT           NOT NULL,
    duration    BIGINT           NOT NULL,
    description TEXT             NOT NULL,
    cost        DOUBLE PRECISION NOT NULL,
    tour_type   TEXT             NOT NULL,
    hotel_id    BIGINT           NOT NULL REFERENCES hotel,
    country_id  BIGINT           NOT NULL REFERENCES country
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