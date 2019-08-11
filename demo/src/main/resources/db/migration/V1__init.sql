CREATE TABLE public.users (
  id bigserial primary key ,
  username character varying NOT NULL,
  first_name character varying NOT NULL,
  last_name character varying DEFAULT NULL
) 