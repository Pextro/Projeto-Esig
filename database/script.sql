-- public.responsavel definition

-- Drop table

-- DROP TABLE public.responsavel;

CREATE TABLE public.responsavel (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT responsavel_pkey PRIMARY KEY (id)
);
-- public.tarefa definition

-- Drop table

-- DROP TABLE public.tarefa;

CREATE TABLE public.tarefa (
	id int8 NOT NULL,
	deadline varchar(255) NULL,
	descricao varchar(255) NULL,
	prioridade varchar(255) NULL,
	status bool NULL,
	titulo varchar(255) NULL,
	responsavel int8 NULL,
	CONSTRAINT tarefa_pkey PRIMARY KEY (id)
);


-- public.tarefa foreign keys

ALTER TABLE public.tarefa ADD CONSTRAINT fkevucq8v5sg5v8egpbqdpbgskc FOREIGN KEY (responsavel) REFERENCES public.responsavel(id);

