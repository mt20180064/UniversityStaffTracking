create table tbl_member(
	id bigint unsigned not null AUTO_INCREMENT,
	firstname varchar(100) not null,
        lastname varchar(100) not null,
        academic_title_id bigint unsigned not null,
        education_title_id bigint unsigned not null,
        scientific_field_id bigint unsigned not null,
        department_id bigint unsigned,
	primary key (id),
        constraint department_fk2 FOREIGN KEY (department_id) REFERENCES tbl_department(id),
constraint academic_title_fk FOREIGN KEY (academic_title_id) REFERENCES tbl_academic_title(id) ,
constraint education_title_fk FOREIGN KEY (education_title_id) REFERENCES tbl_education_title(id) ,

constraint scientific_field_fk FOREIGN KEY (scientific_field_id) REFERENCES tbl_scientific_field(id)  
)
