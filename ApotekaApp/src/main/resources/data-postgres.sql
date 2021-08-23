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
-- TOC entry 3175 (class 0 OID 24026)
-- Dependencies: 204
-- Data for Name: authority; Type: TABLE DATA; Schema: public; Owner: postgres


-- INSERT INTO public.authority (id, name) VALUES (1, 'ROLE_PACIJENT');
-- INSERT INTO public.authority (id, name) VALUES (2, 'ROLE_DERMATOLOG');
-- INSERT INTO public.authority (id, name) VALUES (3, 'ROLE_FARMACEUT');
--
-- insert into public.korisnici (id,email, lozinka, ime, prezime, adresa,grad, drzava, broj, type, pretplacen, enabled, penali, token_id) values (1,'markomarkovic@gmail.com','$2y$10$PlcypQuCmM65W7MikuEIW.vBAMLar2o9UQroEu/fpCN/r06BltbOO','Marko', 'Markovic','Adresa 1','Novi Sad', 'Srbija','0600000000','P' ,'false','true', 0, NULL);
-- insert into public.korisnici (id,email, lozinka, ime, prezime, adresa,grad, drzava, broj, type, pretplacen, enabled, penali, token_id, tip_strucnog_lica) values (2,'anaanic@gmail.com','$2y$10$PlcypQuCmM65W7MikuEIW.vBAMLar2o9UQroEu/fpCN/r06BltbOO','Ana', 'Anic','Adresa 2','Novi Sad', 'Srbija','0600000001','S' ,'false','true', 0, NULL, 1);
-- insert into public.korisnici (id,email, lozinka, ime, prezime, adresa,grad, drzava, broj, type, pretplacen, enabled, penali, token_id, tip_strucnog_lica) values (3,'janajanic@gmail.com','$2y$10$PlcypQuCmM65W7MikuEIW.vBAMLar2o9UQroEu/fpCN/r06BltbOO','Jana', 'Janic','Adresa 3','Novi Sad', 'Srbija','0600000002','S' ,'false','true', 0, NULL, 0);
--
--
-- INSERT INTO public.authorities_korsinik (korisnik_id, authority_id) VALUES (1, 1);
--
-- INSERT INTO public.apoteka (id, naziv, grad, adresa, drzava) VALUES (1, 'Apoteka 1', 'Novi Sad', 'Adresa 1', 'Srbija');
--
-- INSERT INTO public.termin (id, termin_kraj, termin_pocetak) VALUES (1, '10:00', '09:00');
-- INSERT INTO public.termin (id, termin_kraj, termin_pocetak) VALUES (2, '13:30', '13:00');
--
-- INSERT INTO public.tip_pregleda (id, cena, tip, trajanje) VALUES (1, 1000, 0, 30);
--
-- INSERT INTO public.radnje (id, datum, type, izvrsen, definisan, termin_id, strlice_id, pacijent_id, tip_pregleda_id) VALUES (1, '2021-6-25', 'P', true, false, 1, 2, 1, 1);
-- INSERT INTO public.radnje (id, datum, type, izvrsen, definisan, termin_id, strlice_id, pacijent_id) VALUES (2, '2021-6-26', 'S', true, false, 2, 3, 1);
--
--
-- INSERT INTO public.dijagnoze (id, tip) VALUES (1, 0);
--
-- INSERT INTO public.erecept (id, datum_izdavanja, status, pacijent_id) VALUES (1, '2021-6-25', 0, 1);
--
-- INSERT INTO public.izvestaji (id, informacije, dijagnoza_id, recept_id, radnja_id) VALUES (1, 'informacije', 1, 1, 1);
