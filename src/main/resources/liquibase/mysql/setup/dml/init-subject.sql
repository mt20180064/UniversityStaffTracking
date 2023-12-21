

insert into tbl_subject(name,espb,department_id)
values ("subject-2", 10, (select (id) from tbl_department WHERE name="Mathematics"));

insert into tbl_subject(name,espb,department_id)
values ("subject-3", 5, (select (id) from tbl_department WHERE name="Social sciences"));
insert into tbl_subject(name,espb,department_id)
values ("subject-4", 5, (select (id) from tbl_department WHERE name="Software development"));
insert into tbl_subject(name,espb,department_id)
values ("subject-5", 5, (select (id) from tbl_department WHERE name="Physics"));
