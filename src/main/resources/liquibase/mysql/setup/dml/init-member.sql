insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id)
values ("Roko", "Todorovic", (select (id) from tbl_academic_title WHERE name="docent"), (select (id) from tbl_education_title WHERE name="Bachelor"), (select (id) from tbl_scientific_field WHERE name="databases"), (select (id) from tbl_department WHERE name="Software development"));

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id)
values ("Eko", "Snaucerkovic", (select (id) from tbl_academic_title WHERE name="professor"), (select (id) from tbl_education_title WHERE name="phD"), (select (id) from tbl_scientific_field WHERE name="mathematics"), (select (id) from tbl_department WHERE name="Software development"));

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id)
values ("Beli", "Mackat", (select (id) from tbl_academic_title WHERE name="assistant"), (select (id) from tbl_education_title WHERE name="Master"), (select (id) from tbl_scientific_field WHERE name="networks"), (select (id) from tbl_department WHERE name="Social sciences"));

insert into tbl_member(firstname, lastname, academic_title_id, education_title_id, scientific_field_id ,department_id)
values ("Tor", "Todorovic", (select (id) from tbl_academic_title WHERE name="lecturer"), (select (id) from tbl_education_title WHERE name="Bachelor"), (select (id) from tbl_scientific_field WHERE name="languages"), (select (id) from tbl_department WHERE name="Social sciences"));