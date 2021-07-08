-- Table: negozio.fornitore

--DROP TABLE negozio.prodotto;
--DROP TABLE negozio.fornitore;

CREATE TABLE negozio.fornitore
(
    id bigint NOT NULL,
    codice_fornitore character varying COLLATE pg_catalog."default" NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    indirizzo character varying COLLATE pg_catalog."default" NOT NULL,
    citta character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT fornitore_pkey PRIMARY KEY (id),
    CONSTRAINT codice_fornitore UNIQUE (codice_fornitore)
)

TABLESPACE pg_default;

ALTER TABLE negozio.fornitore
    OWNER to postgres;
	
	-- Table: negozio.prodotto



CREATE TABLE negozio.prodotto
(
    id bigint NOT NULL,
    codice_prodotto character varying COLLATE pg_catalog."default" NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    descrizione character varying COLLATE pg_catalog."default" NOT NULL,
    marca character varying COLLATE pg_catalog."default" NOT NULL,
    codice_fornitore_fk character varying COLLATE pg_catalog."default" NOT NULL,
    prezzo numeric NOT NULL,
    CONSTRAINT prodotto_pkey PRIMARY KEY (id),
    CONSTRAINT fornitura FOREIGN KEY (codice_fornitore_fk)
        REFERENCES negozio.fornitore (codice_fornitore) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE negozio.prodotto
    OWNER to postgres;