--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-11-10 01:54:45

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 16414)
-- Name: stud; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA stud;


ALTER SCHEMA stud OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16415)
-- Name: lecturers; Type: TABLE; Schema: stud; Owner: postgres
--

CREATE TABLE stud.lecturers (
    id bigint NOT NULL,
    firstname text,
    secondname text,
    phone text
);


ALTER TABLE stud.lecturers OWNER TO postgres;

--
-- TOC entry 4634 (class 2606 OID 16421)
-- Name: lecturers shopping_pkey; Type: CONSTRAINT; Schema: stud; Owner: postgres
--

ALTER TABLE ONLY stud.lecturers
    ADD CONSTRAINT shopping_pkey PRIMARY KEY (id);


-- Completed on 2023-11-10 01:54:45

--
-- PostgreSQL database dump complete
--

