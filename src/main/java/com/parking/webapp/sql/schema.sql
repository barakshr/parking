CREATE SCHEMA parking_lot_management AUTHORIZATION postgres;
GRANT ALL ON SCHEMA parking_lot_management TO postgres;
COMMENT ON SCHEMA parking_lot_management IS 'Parking lot_management schema';
SET search_path TO parking_lot_management;


CREATE TABLE parking_lot_management.slots
(
    "id"             SERIAL PRIMARY KEY NOT NULL,
    "parking_lot_id" INT,
    "occupied"       BOOLEAN
);


CREATE TABLE parking_lot_management.vehicle
(
    "id"             SERIAL PRIMARY KEY NOT NULL,
    "parking_lot_id" INT,
    "parking_slots"  INT[],
    "vehicle_data"   TEXT
)