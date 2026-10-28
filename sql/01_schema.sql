-- =====================================================================
-- 01_schema.sql
-- Creates the EZPZ schema
-- =====================================================================
-- To recreate the schema from scratch (drops ALL EZPZ objects):
-- DROP USER ezpz CASCADE;

CREATE USER ezpz IDENTIFIED BY "***"
    DEFAULT TABLESPACE data
    QUOTA UNLIMITED ON data;


GRANT CREATE SESSION  TO ezpz;
GRANT CREATE TABLE    TO ezpz;
GRANT CREATE SEQUENCE TO ezpz;

