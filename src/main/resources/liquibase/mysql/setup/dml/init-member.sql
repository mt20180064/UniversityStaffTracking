insert into tbl_member(firstname, lastname, academic_title, education_title, scientific_field ,department_id)
values ("Roko", "Todorovic", "professor", "phD", "database development", (select (id) from tbl_department WHERE name="department-6"));

insert into tbl_member(firstname, lastname, academic_title, education_title, scientific_field ,department_id)
values ("Eko", "Snaucerkovic", "assistent", "Master", "mathematics", (select (id) from tbl_department WHERE name="department-5"));

insert into tbl_member(firstname, lastname, academic_title, education_title, scientific_field ,department_id)
values ("Beli", "Mackat", "assistent", "Master", "mathematics", (select (id) from tbl_department WHERE name="department-67"));