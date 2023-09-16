--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id numeric NOT NULL,
    title character varying NOT NULL,
    description text,
    category character varying NOT NULL,
    etalase character varying NOT NULL,
    images character varying NOT NULL,
    weight character varying NOT NULL,
    price numeric DEFAULT 0 NOT NULL,
    create_date timestamp without time zone DEFAULT now() NOT NULL,
    sku character varying NOT NULL
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_reviews; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product_reviews (
    id numeric NOT NULL,
    rating numeric NOT NULL,
    productid numeric NOT NULL,
    review_comment text NOT NULL,
    create_date timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.product_reviews OWNER TO postgres;

--
-- Name: product_reviews_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_reviews_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_reviews_id_seq OWNER TO postgres;

--
-- Name: product_reviews_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_reviews_id_seq OWNED BY public.product_reviews.id;


--
-- Name: product_sku_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_sku_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_sku_seq OWNER TO postgres;

--
-- Name: product_sku_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_sku_seq OWNED BY public.product.id;


--
-- Name: product id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_sku_seq'::regclass);


--
-- Name: product_reviews id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_reviews ALTER COLUMN id SET DEFAULT nextval('public.product_reviews_id_seq'::regclass);


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, title, description, category, etalase, images, weight, price, create_date, sku) FROM stdin;
3	SSD PORTABLE CRUCIAL X6 2TB USB C SSD EXTERNAL MOBILE ORIGINAL	SSD PORTABLE CRUCIAL X6 2TB USB C SSD EXTERNAL MOBILE ORIGINAL	Media Simpan Data	Komputer dan Laptop	/images/elektronic/ssd_portable_2tb.png	50 gram	40000	2023-09-16 10:48:53.820953	ELEK-KOM-00003
2	SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL	SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL	Media Simpan Data	Komputer dan Laptop	/images/elektronic/ssd_portable_1tb.png	50 gram	18000	2023-09-16 10:46:44.201309	ELEK-KOM-00002
1	SSD PORTABLE CRUCIAL X6 500GB USB C SSD EXTERNAL MOBILE ORIGINAL	SSD PORTABLE CRUCIAL X6 500GB USB C SSD EXTERNAL MOBILE ORIGINAL	Media Simpan Data	Komputer dan Laptop	/images/elektronic/ssd_portable.png	40 gram	10000	2023-09-16 10:46:43.201309	ELEK-KOM-00001
5	SSD PORTABLE CRUCIAL X6 4TB USB C SSD EXTERNAL MOBILE ORIGINAL	SSD PORTABLE CRUCIAL X6 4TB USB C SSD EXTERNAL MOBILE ORIGINAL	Media Simpan Data	Komputer dan Laptop	/images/elektronic/ssd_portable_3tb.png	60 gram	60000	2023-09-16 11:26:21.127248	ELEK-KOM-00005
4	SSD PORTABLE CRUCIAL X6 3TB USB C SSD EXTERNAL MOBILE ORIGINAL	SSD PORTABLE CRUCIAL X6 3TB USB C SSD EXTERNAL MOBILE ORIGINAL	Media Simpan Data	Komputer dan Laptop	/images/elektronic/ssd_portable_3tb.png	50 gram	50000	2023-09-16 11:06:32.766492	ELEK-KOM-00004
\.


--
-- Data for Name: product_reviews; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product_reviews (id, rating, productid, review_comment, create_date) FROM stdin;
2	3	1	barang mantap, response cepat sellernya	2023-09-16 11:37:56.349386
3	3.3	1	barang mantap, response cepat sellernya	2023-09-16 11:38:54.331928
4	3.4	1	barang mantap, response cepat sellernya	2023-09-16 11:38:58.442901
5	3.4	1	barang mantap, response cepat sellernya, top banget dah	2023-09-16 11:40:20.111097
6	3.3	2	seller tidak responsif, jangan di pesan lagi barangny	2023-09-16 11:41:39.203834
\.


--
-- Name: product_reviews_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_reviews_id_seq', 6, true);


--
-- Name: product_sku_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_sku_seq', 5, true);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: product_reviews product_reviews_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_reviews
    ADD CONSTRAINT product_reviews_pkey PRIMARY KEY (id);


--
-- Name: product_reviews product_reviews_productid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product_reviews
    ADD CONSTRAINT product_reviews_productid_fkey FOREIGN KEY (productid) REFERENCES public.product(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

