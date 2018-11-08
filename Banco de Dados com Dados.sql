--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.9
-- Dumped by pg_dump version 9.6.0

-- Started on 2018-11-08 02:13:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2251 (class 1262 OID 33637)
-- Name: padraoprojeto; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE padraoprojeto WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE padraoprojeto OWNER TO postgres;

\connect padraoprojeto

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2253 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 203 (class 1259 OID 33784)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE endereco (
    id_endereco integer NOT NULL,
    id_usuario integer NOT NULL,
    rua character varying(150) NOT NULL,
    bairro character varying(150),
    cep character varying(8),
    cidade character varying(150) NOT NULL,
    estado character varying(2) NOT NULL,
    complemento character varying(150),
    numero character varying(15) NOT NULL
);


ALTER TABLE endereco OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 33782)
-- Name: endereco_id_endereco_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE endereco_id_endereco_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE endereco_id_endereco_seq OWNER TO postgres;

--
-- TOC entry 2254 (class 0 OID 0)
-- Dependencies: 202
-- Name: endereco_id_endereco_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE endereco_id_endereco_seq OWNED BY endereco.id_endereco;


--
-- TOC entry 188 (class 1259 OID 33648)
-- Name: forma_pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE forma_pagamento (
    id_forma_pagamento integer NOT NULL,
    descricao character varying(100) NOT NULL
);


ALTER TABLE forma_pagamento OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 33646)
-- Name: forma_pagamento_id_forma_pagamento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE forma_pagamento_id_forma_pagamento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE forma_pagamento_id_forma_pagamento_seq OWNER TO postgres;

--
-- TOC entry 2255 (class 0 OID 0)
-- Dependencies: 187
-- Name: forma_pagamento_id_forma_pagamento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE forma_pagamento_id_forma_pagamento_seq OWNED BY forma_pagamento.id_forma_pagamento;


--
-- TOC entry 200 (class 1259 OID 33761)
-- Name: historico_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE historico_pedido (
    id_historico_pedido integer NOT NULL,
    fk_pedido integer NOT NULL,
    estado character varying(45) NOT NULL,
    data_alteracao timestamp without time zone NOT NULL,
    atual boolean NOT NULL
);


ALTER TABLE historico_pedido OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 33759)
-- Name: historico_pedido_id_historico_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE historico_pedido_id_historico_pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE historico_pedido_id_historico_pedido_seq OWNER TO postgres;

--
-- TOC entry 2256 (class 0 OID 0)
-- Dependencies: 199
-- Name: historico_pedido_id_historico_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE historico_pedido_id_historico_pedido_seq OWNED BY historico_pedido.id_historico_pedido;


--
-- TOC entry 198 (class 1259 OID 33741)
-- Name: ingrediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ingrediente (
    id_ingrediente integer NOT NULL,
    id_item_composto integer NOT NULL,
    id_item_componente integer NOT NULL
);


ALTER TABLE ingrediente OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 33739)
-- Name: ingrediente_id_ingrediente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ingrediente_id_ingrediente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ingrediente_id_ingrediente_seq OWNER TO postgres;

--
-- TOC entry 2257 (class 0 OID 0)
-- Dependencies: 197
-- Name: ingrediente_id_ingrediente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ingrediente_id_ingrediente_seq OWNED BY ingrediente.id_ingrediente;


--
-- TOC entry 194 (class 1259 OID 33708)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE item (
    id_item integer NOT NULL,
    nome character varying(100) NOT NULL,
    preco double precision,
    fk_restaurante integer NOT NULL,
    ingrediente boolean NOT NULL
);


ALTER TABLE item OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 33706)
-- Name: item_id_item_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE item_id_item_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE item_id_item_seq OWNER TO postgres;

--
-- TOC entry 2258 (class 0 OID 0)
-- Dependencies: 193
-- Name: item_id_item_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE item_id_item_seq OWNED BY item.id_item;


--
-- TOC entry 196 (class 1259 OID 33721)
-- Name: item_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE item_pedido (
    id_item_pedido integer NOT NULL,
    fk_pedido integer NOT NULL,
    fk_item integer NOT NULL,
    quantidade integer NOT NULL,
    valortotal numeric(7,2) NOT NULL
);


ALTER TABLE item_pedido OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 33719)
-- Name: item_pedido_id_item_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE item_pedido_id_item_pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE item_pedido_id_item_pedido_seq OWNER TO postgres;

--
-- TOC entry 2259 (class 0 OID 0)
-- Dependencies: 195
-- Name: item_pedido_id_item_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE item_pedido_id_item_pedido_seq OWNED BY item_pedido.id_item_pedido;


--
-- TOC entry 192 (class 1259 OID 33678)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pedido (
    id_pedido integer NOT NULL,
    descricao character varying(255) NOT NULL,
    status character varying(100) DEFAULT 'Esperando Confirmação'::character varying NOT NULL,
    valorpedido numeric,
    valordesconto numeric,
    valorliquido numeric,
    fk_forma_pagamento integer,
    fk_usuario_cliente integer NOT NULL,
    fk_usuario_restaurante integer NOT NULL
);


ALTER TABLE pedido OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 33676)
-- Name: pedido_id_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pedido_id_pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pedido_id_pedido_seq OWNER TO postgres;

--
-- TOC entry 2260 (class 0 OID 0)
-- Dependencies: 191
-- Name: pedido_id_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pedido_id_pedido_seq OWNED BY pedido.id_pedido;


--
-- TOC entry 201 (class 1259 OID 33773)
-- Name: restaurante_desconto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE restaurante_desconto (
    id_usuario_restaurante integer NOT NULL,
    desconto_nivel_um numeric(7,2),
    quantidade_nivel_um integer,
    desconto_nivel_dois numeric(7,2),
    quantidade_nivel_dois integer,
    desconto_nivel_tres numeric(7,2),
    quantidade_nivel_tres integer
);


ALTER TABLE restaurante_desconto OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 33640)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id_usuario integer NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    tipo character varying(50)
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 33638)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2261 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_usuario_seq OWNED BY usuario.id_usuario;


--
-- TOC entry 189 (class 1259 OID 33654)
-- Name: usuariocliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuariocliente (
    id_usuario_cliente integer NOT NULL,
    cpf character varying(11) NOT NULL
);


ALTER TABLE usuariocliente OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 33665)
-- Name: usuariorestaurante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuariorestaurante (
    id_usuario_restaurante integer NOT NULL,
    avaliacao numeric(5,2)
);


ALTER TABLE usuariorestaurante OWNER TO postgres;

--
-- TOC entry 2065 (class 2604 OID 33787)
-- Name: endereco id_endereco; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco ALTER COLUMN id_endereco SET DEFAULT nextval('endereco_id_endereco_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 33651)
-- Name: forma_pagamento id_forma_pagamento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY forma_pagamento ALTER COLUMN id_forma_pagamento SET DEFAULT nextval('forma_pagamento_id_forma_pagamento_seq'::regclass);


--
-- TOC entry 2064 (class 2604 OID 33764)
-- Name: historico_pedido id_historico_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historico_pedido ALTER COLUMN id_historico_pedido SET DEFAULT nextval('historico_pedido_id_historico_pedido_seq'::regclass);


--
-- TOC entry 2063 (class 2604 OID 33744)
-- Name: ingrediente id_ingrediente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingrediente ALTER COLUMN id_ingrediente SET DEFAULT nextval('ingrediente_id_ingrediente_seq'::regclass);


--
-- TOC entry 2061 (class 2604 OID 33711)
-- Name: item id_item; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item ALTER COLUMN id_item SET DEFAULT nextval('item_id_item_seq'::regclass);


--
-- TOC entry 2062 (class 2604 OID 33724)
-- Name: item_pedido id_item_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_pedido ALTER COLUMN id_item_pedido SET DEFAULT nextval('item_pedido_id_item_pedido_seq'::regclass);


--
-- TOC entry 2059 (class 2604 OID 33681)
-- Name: pedido id_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido ALTER COLUMN id_pedido SET DEFAULT nextval('pedido_id_pedido_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 33643)
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_id_usuario_seq'::regclass);


--
-- TOC entry 2246 (class 0 OID 33784)
-- Dependencies: 203
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2262 (class 0 OID 0)
-- Dependencies: 202
-- Name: endereco_id_endereco_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('endereco_id_endereco_seq', 1, false);


--
-- TOC entry 2231 (class 0 OID 33648)
-- Dependencies: 188
-- Data for Name: forma_pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO forma_pagamento (id_forma_pagamento, descricao) VALUES (1, 'Dinheiro');
INSERT INTO forma_pagamento (id_forma_pagamento, descricao) VALUES (2, 'Credito');
INSERT INTO forma_pagamento (id_forma_pagamento, descricao) VALUES (3, 'Debito');


--
-- TOC entry 2263 (class 0 OID 0)
-- Dependencies: 187
-- Name: forma_pagamento_id_forma_pagamento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('forma_pagamento_id_forma_pagamento_seq', 3, true);


--
-- TOC entry 2243 (class 0 OID 33761)
-- Dependencies: 200
-- Data for Name: historico_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO historico_pedido (id_historico_pedido, fk_pedido, estado, data_alteracao, atual) VALUES (1, 1, 'Aguardando', '2018-11-08 01:37:16.967', false);
INSERT INTO historico_pedido (id_historico_pedido, fk_pedido, estado, data_alteracao, atual) VALUES (3, 1, 'Preparando', '2018-11-08 02:00:59.558', false);
INSERT INTO historico_pedido (id_historico_pedido, fk_pedido, estado, data_alteracao, atual) VALUES (2, 1, 'Confirmacao', '2018-11-08 02:00:42.664', false);
INSERT INTO historico_pedido (id_historico_pedido, fk_pedido, estado, data_alteracao, atual) VALUES (4, 1, 'Preparando', '2018-11-08 02:01:27.699', false);
INSERT INTO historico_pedido (id_historico_pedido, fk_pedido, estado, data_alteracao, atual) VALUES (5, 1, 'SaindoEntrega', '2018-11-08 02:01:34.804', false);
INSERT INTO historico_pedido (id_historico_pedido, fk_pedido, estado, data_alteracao, atual) VALUES (6, 1, 'Concluido', '2018-11-08 02:02:33.039', true);


--
-- TOC entry 2264 (class 0 OID 0)
-- Dependencies: 199
-- Name: historico_pedido_id_historico_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('historico_pedido_id_historico_pedido_seq', 6, true);


--
-- TOC entry 2241 (class 0 OID 33741)
-- Dependencies: 198
-- Data for Name: ingrediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ingrediente (id_ingrediente, id_item_composto, id_item_componente) VALUES (1, 5, 1);
INSERT INTO ingrediente (id_ingrediente, id_item_composto, id_item_componente) VALUES (2, 5, 2);
INSERT INTO ingrediente (id_ingrediente, id_item_composto, id_item_componente) VALUES (3, 5, 4);


--
-- TOC entry 2265 (class 0 OID 0)
-- Dependencies: 197
-- Name: ingrediente_id_ingrediente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ingrediente_id_ingrediente_seq', 3, true);


--
-- TOC entry 2237 (class 0 OID 33708)
-- Dependencies: 194
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO item (id_item, nome, preco, fk_restaurante, ingrediente) VALUES (2, 'Maionese', 1, 5, true);
INSERT INTO item (id_item, nome, preco, fk_restaurante, ingrediente) VALUES (3, 'Açúcar', 1, 5, true);
INSERT INTO item (id_item, nome, preco, fk_restaurante, ingrediente) VALUES (4, 'Bife de Frango', 1, 5, true);
INSERT INTO item (id_item, nome, preco, fk_restaurante, ingrediente) VALUES (5, 'Pão Especial', 12, 5, false);
INSERT INTO item (id_item, nome, preco, fk_restaurante, ingrediente) VALUES (1, 'Pão', 1, 5, true);


--
-- TOC entry 2266 (class 0 OID 0)
-- Dependencies: 193
-- Name: item_id_item_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('item_id_item_seq', 5, true);


--
-- TOC entry 2239 (class 0 OID 33721)
-- Dependencies: 196
-- Data for Name: item_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO item_pedido (id_item_pedido, fk_pedido, fk_item, quantidade, valortotal) VALUES (1, 1, 5, 5, 60.00);


--
-- TOC entry 2267 (class 0 OID 0)
-- Dependencies: 195
-- Name: item_pedido_id_item_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('item_pedido_id_item_pedido_seq', 1, true);


--
-- TOC entry 2235 (class 0 OID 33678)
-- Dependencies: 192
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO pedido (id_pedido, descricao, status, valorpedido, valordesconto, valorliquido, fk_forma_pagamento, fk_usuario_cliente, fk_usuario_restaurante) VALUES (1, 'Pão Especial.', 'Concluido', 60, 3, 57, 2, 4, 5);


--
-- TOC entry 2268 (class 0 OID 0)
-- Dependencies: 191
-- Name: pedido_id_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pedido_id_pedido_seq', 1, true);


--
-- TOC entry 2244 (class 0 OID 33773)
-- Dependencies: 201
-- Data for Name: restaurante_desconto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO restaurante_desconto (id_usuario_restaurante, desconto_nivel_um, quantidade_nivel_um, desconto_nivel_dois, quantidade_nivel_dois, desconto_nivel_tres, quantidade_nivel_tres) VALUES (2, 0.05, 5, 0.10, 10, 0.15, 15);
INSERT INTO restaurante_desconto (id_usuario_restaurante, desconto_nivel_um, quantidade_nivel_um, desconto_nivel_dois, quantidade_nivel_dois, desconto_nivel_tres, quantidade_nivel_tres) VALUES (5, 0.05, 5, 0.10, 10, 0.15, 15);


--
-- TOC entry 2229 (class 0 OID 33640)
-- Dependencies: 186
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario (id_usuario, nome, senha, email, tipo) VALUES (1, 'JOAO PAULO DIAS', '102030', 'diasjp1997@gmail.com', 'CLIENTE');
INSERT INTO usuario (id_usuario, nome, senha, email, tipo) VALUES (2, 'Carlos Silva', '102030', 'JPDIAS1997@HOTMAIL.COM', 'RESTAURANTE');
INSERT INTO usuario (id_usuario, nome, senha, email, tipo) VALUES (4, 'JOAO PAULO DIAS', '12345', 'diasjp1997@gmail.com', 'CLIENTE');
INSERT INTO usuario (id_usuario, nome, senha, email, tipo) VALUES (5, 'JOAO PAULO DIAS', '12345', 'diasjp1997@gmail.com', 'RESTAURANTE');


--
-- TOC entry 2269 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 5, true);


--
-- TOC entry 2232 (class 0 OID 33654)
-- Dependencies: 189
-- Data for Name: usuariocliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuariocliente (id_usuario_cliente, cpf) VALUES (1, '16148567709');
INSERT INTO usuariocliente (id_usuario_cliente, cpf) VALUES (4, '16148567709');


--
-- TOC entry 2233 (class 0 OID 33665)
-- Dependencies: 190
-- Data for Name: usuariorestaurante; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuariorestaurante (id_usuario_restaurante, avaliacao) VALUES (2, NULL);
INSERT INTO usuariorestaurante (id_usuario_restaurante, avaliacao) VALUES (5, NULL);


--
-- TOC entry 2096 (class 2606 OID 33792)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id_endereco);


--
-- TOC entry 2069 (class 2606 OID 33653)
-- Name: forma_pagamento forma_pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY forma_pagamento
    ADD CONSTRAINT forma_pagamento_pkey PRIMARY KEY (id_forma_pagamento);


--
-- TOC entry 2093 (class 2606 OID 33766)
-- Name: historico_pedido historico_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historico_pedido
    ADD CONSTRAINT historico_pedido_pkey PRIMARY KEY (id_historico_pedido, fk_pedido);


--
-- TOC entry 2090 (class 2606 OID 33746)
-- Name: ingrediente ingrediente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingrediente
    ADD CONSTRAINT ingrediente_pkey PRIMARY KEY (id_ingrediente);


--
-- TOC entry 2086 (class 2606 OID 33726)
-- Name: item_pedido item_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT item_pedido_pkey PRIMARY KEY (id_item_pedido);


--
-- TOC entry 2082 (class 2606 OID 33713)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id_item);


--
-- TOC entry 2080 (class 2606 OID 33687)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido);


--
-- TOC entry 2067 (class 2606 OID 33645)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 2072 (class 2606 OID 33658)
-- Name: usuariocliente usuariocliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuariocliente
    ADD CONSTRAINT usuariocliente_pkey PRIMARY KEY (id_usuario_cliente);


--
-- TOC entry 2075 (class 2606 OID 33669)
-- Name: usuariorestaurante usuariorestaurante_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuariorestaurante
    ADD CONSTRAINT usuariorestaurante_pkey PRIMARY KEY (id_usuario_restaurante);


--
-- TOC entry 2097 (class 1259 OID 33798)
-- Name: fk_endereco_usuario1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_endereco_usuario1_idx ON public.endereco USING btree (id_usuario);


--
-- TOC entry 2091 (class 1259 OID 33772)
-- Name: fk_historico_pedido_pedido1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_historico_pedido_pedido1_idx ON public.historico_pedido USING btree (fk_pedido);


--
-- TOC entry 2087 (class 1259 OID 33757)
-- Name: fk_ingrediente_item1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_ingrediente_item1_idx ON public.ingrediente USING btree (id_item_composto);


--
-- TOC entry 2088 (class 1259 OID 33758)
-- Name: fk_ingrediente_item2_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_ingrediente_item2_idx ON public.ingrediente USING btree (id_item_componente);


--
-- TOC entry 2083 (class 1259 OID 33738)
-- Name: fk_item_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_item_idx ON public.item_pedido USING btree (fk_item);


--
-- TOC entry 2076 (class 1259 OID 33703)
-- Name: fk_pedido_forma_pagamento1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_pedido_forma_pagamento1_idx ON public.pedido USING btree (fk_forma_pagamento);


--
-- TOC entry 2084 (class 1259 OID 33737)
-- Name: fk_pedido_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_pedido_idx ON public.item_pedido USING btree (fk_pedido);


--
-- TOC entry 2077 (class 1259 OID 33704)
-- Name: fk_pedido_usuariocliente1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_pedido_usuariocliente1_idx ON public.pedido USING btree (fk_usuario_cliente);


--
-- TOC entry 2078 (class 1259 OID 33705)
-- Name: fk_pedido_usuariorestaurante1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_pedido_usuariorestaurante1_idx ON public.pedido USING btree (fk_usuario_restaurante);


--
-- TOC entry 2094 (class 1259 OID 33781)
-- Name: fk_restaurante_desconto_usuariorestaurante1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_restaurante_desconto_usuariorestaurante1_idx ON public.restaurante_desconto USING btree (id_usuario_restaurante);


--
-- TOC entry 2070 (class 1259 OID 33664)
-- Name: fk_usuariocliente_usuario1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_usuariocliente_usuario1_idx ON public.usuariocliente USING btree (id_usuario_cliente);


--
-- TOC entry 2073 (class 1259 OID 33675)
-- Name: fk_usuariofuncionario_usuario1_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fk_usuariofuncionario_usuario1_idx ON public.usuariorestaurante USING btree (id_usuario_restaurante);


--
-- TOC entry 2110 (class 2606 OID 33793)
-- Name: endereco fk_endereco_usuario1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk_endereco_usuario1 FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 2108 (class 2606 OID 33767)
-- Name: historico_pedido fk_historico_pedido_pedido1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historico_pedido
    ADD CONSTRAINT fk_historico_pedido_pedido1 FOREIGN KEY (fk_pedido) REFERENCES pedido(id_pedido);


--
-- TOC entry 2106 (class 2606 OID 33747)
-- Name: ingrediente fk_ingrediente_item1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingrediente
    ADD CONSTRAINT fk_ingrediente_item1 FOREIGN KEY (id_item_composto) REFERENCES item(id_item);


--
-- TOC entry 2107 (class 2606 OID 33752)
-- Name: ingrediente fk_ingrediente_item2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingrediente
    ADD CONSTRAINT fk_ingrediente_item2 FOREIGN KEY (id_item_componente) REFERENCES item(id_item);


--
-- TOC entry 2105 (class 2606 OID 33732)
-- Name: item_pedido fk_item; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT fk_item FOREIGN KEY (fk_item) REFERENCES item(id_item);


--
-- TOC entry 2103 (class 2606 OID 33714)
-- Name: item fk_item_restaurante1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item
    ADD CONSTRAINT fk_item_restaurante1 FOREIGN KEY (fk_restaurante) REFERENCES usuariorestaurante(id_usuario_restaurante);


--
-- TOC entry 2104 (class 2606 OID 33727)
-- Name: item_pedido fk_pedido; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item_pedido
    ADD CONSTRAINT fk_pedido FOREIGN KEY (fk_pedido) REFERENCES pedido(id_pedido);


--
-- TOC entry 2100 (class 2606 OID 33688)
-- Name: pedido fk_pedido_forma_pagamento1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT fk_pedido_forma_pagamento1 FOREIGN KEY (fk_forma_pagamento) REFERENCES forma_pagamento(id_forma_pagamento);


--
-- TOC entry 2101 (class 2606 OID 33693)
-- Name: pedido fk_pedido_usuariocliente1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT fk_pedido_usuariocliente1 FOREIGN KEY (fk_usuario_cliente) REFERENCES usuariocliente(id_usuario_cliente);


--
-- TOC entry 2102 (class 2606 OID 33698)
-- Name: pedido fk_pedido_usuariorestaurante1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT fk_pedido_usuariorestaurante1 FOREIGN KEY (fk_usuario_restaurante) REFERENCES usuariorestaurante(id_usuario_restaurante);


--
-- TOC entry 2109 (class 2606 OID 33776)
-- Name: restaurante_desconto fk_restaurante_desconto_usuariorestaurante1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY restaurante_desconto
    ADD CONSTRAINT fk_restaurante_desconto_usuariorestaurante1 FOREIGN KEY (id_usuario_restaurante) REFERENCES usuariorestaurante(id_usuario_restaurante);


--
-- TOC entry 2098 (class 2606 OID 33659)
-- Name: usuariocliente fk_usuariocliente_usuario1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuariocliente
    ADD CONSTRAINT fk_usuariocliente_usuario1 FOREIGN KEY (id_usuario_cliente) REFERENCES usuario(id_usuario);


--
-- TOC entry 2099 (class 2606 OID 33670)
-- Name: usuariorestaurante fk_usuariofuncionario_usuario1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuariorestaurante
    ADD CONSTRAINT fk_usuariofuncionario_usuario1 FOREIGN KEY (id_usuario_restaurante) REFERENCES usuario(id_usuario);


-- Completed on 2018-11-08 02:13:27

--
-- PostgreSQL database dump complete
--

