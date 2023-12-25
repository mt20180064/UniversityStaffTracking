 insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Roko", "Todorovic", (select (id) from tbl_academic_title WHERE name="docent"), (select (id) from tbl_education_title WHERE name="Bachelor"), (select (id) from tbl_scientific_field WHERE name="databases"), (select (id) from tbl_department WHERE name="Software development"), '2020-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Eko", "Snaucerkovic", (select (id) from tbl_academic_title WHERE name="professor"), (select (id) from tbl_education_title WHERE name="phD"), (select (id) from tbl_scientific_field WHERE name="mathematics"), (select (id) from tbl_department WHERE name="Software development"), '2019-01-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Role", "Snasne", (select (id) from tbl_academic_title WHERE name="professor"), (select (id) from tbl_education_title WHERE name="phD"), (select (id) from tbl_scientific_field WHERE name="mathematics"), (select (id) from tbl_department WHERE name="Software development"), '2016-12-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Beli", "Mackat", (select (id) from tbl_academic_title WHERE name="assistant"), (select (id) from tbl_education_title WHERE name="Master"), (select (id) from tbl_scientific_field WHERE name="networks"), (select (id) from tbl_department WHERE name="Social sciences"), '2017-11-07 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Tor", "Todorovic", (select (id) from tbl_academic_title WHERE name="lecturer"), (select (id) from tbl_education_title WHERE name="Bachelor"), (select (id) from tbl_scientific_field WHERE name="languages"), (select (id) from tbl_department WHERE name="Social sciences"), '2017-10-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Nena", "Buldog", (select (id) from tbl_academic_title WHERE name="lecturer"), (select (id) from tbl_education_title WHERE name="Bachelor"), (select (id) from tbl_scientific_field WHERE name="languages"), (select (id) from tbl_department WHERE name="Social sciences"), '2018-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Djino", "Djinobil", (select (id) from tbl_academic_title WHERE name="associate"), (select (id) from tbl_education_title WHERE name="Master"), (select (id) from tbl_scientific_field WHERE name="management"), (select (id) from tbl_department WHERE name="Mathematics"), '2017-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Ozi", "Ozilije", (select (id) from tbl_academic_title WHERE name="lecturer"), (select (id) from tbl_education_title WHERE name="Bachelor"), (select (id) from tbl_scientific_field WHERE name="programming"), (select (id) from tbl_department WHERE name="Mathematics"), '2017-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Ozutak", "Novi", (select (id) from tbl_academic_title WHERE name="lecturer"), (select (id) from tbl_education_title WHERE name="Bachelor"), (select (id) from tbl_scientific_field WHERE name="programming"), (select (id) from tbl_department WHERE name="Mathematics"), '2017-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Viktor", "Mihajlovic", (select (id) from tbl_academic_title WHERE name="professor"), (select (id) from tbl_education_title WHERE name="phD"), (select (id) from tbl_scientific_field WHERE name="networks"), (select (id) from tbl_department WHERE name="Physics"), '2017-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Mega", "Morz", (select (id) from tbl_academic_title WHERE name="docent"), (select (id) from tbl_education_title WHERE name="phD"), (select (id) from tbl_scientific_field WHERE name="management"), (select (id) from tbl_department WHERE name="Physics"), '2017-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Dona", "Ciganka", (select (id) from tbl_academic_title WHERE name="docent"), (select (id) from tbl_education_title WHERE name="phD"), (select (id) from tbl_scientific_field WHERE name="management"), (select (id) from tbl_department WHERE name="Physics"), '2017-11-09 09:08:44');

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id,title_start)
values ("Lord", "Dzimi", (select (id) from tbl_academic_title WHERE name="docent"), (select (id) from tbl_education_title WHERE name="phD"), (select (id) from tbl_scientific_field WHERE name="management"), (select (id) from tbl_department WHERE name="Physics"), '2017-11-09 09:08:44');