delete from item_venda;
delete from venda;
delete from disco;
delete from cashback;
delete from genero;


insert into genero values (1, "pop");
insert into genero values (2, "mpb");
insert into genero values (3, "classic");
insert into genero values (4, "rock");

insert into cashback values (1,  "SUNDAY",		0.25, 1);
insert into cashback values (2,  "MONDAY",		0.07, 1);
insert into cashback values (3,  "TUESDAY",		0.06, 1);
insert into cashback values (4,  "WEDNESDAY",	0.02, 1);
insert into cashback values (5,  "THURSDAY",	0.10, 1);
insert into cashback values (6,  "FRIDAY",		0.15, 1);
insert into cashback values (7,  "SATURDAY",	0.20, 1);

insert into cashback values (8,  "SUNDAY",		0.30, 2);
insert into cashback values (9,  "MONDAY",		0.05, 2);
insert into cashback values (10, "TUESDAY",		0.10, 2);
insert into cashback values (11, "WEDNESDAY",	0.15, 2);
insert into cashback values (12, "THURSDAY",	0.20, 2);
insert into cashback values (13, "FRIDAY",		0.25, 2);
insert into cashback values (14, "SATURDAY",	0.30, 2);

insert into cashback values (15, "SUNDAY",		0.35, 3);
insert into cashback values (16, "MONDAY",		0.03, 3);
insert into cashback values (17, "TUESDAY",		0.05, 3);
insert into cashback values (18, "WEDNESDAY",	0.08, 3);
insert into cashback values (19, "THURSDAY",	0.13, 3);
insert into cashback values (20, "FRIDAY",		0.18, 3);
insert into cashback values (21, "SATURDAY",	0.25, 3);

insert into cashback values (22, "SUNDAY",		0.40, 4);
insert into cashback values (23, "MONDAY",		0.10, 4);
insert into cashback values (24, "TUESDAY",		0.15, 4);
insert into cashback values (25, "WEDNESDAY",	0.15, 4);
insert into cashback values (26, "THURSDAY",	0.15, 4);
insert into cashback values (27, "FRIDAY",		0.20, 4);
insert into cashback values (28, "SATURDAY",	0.40, 4);