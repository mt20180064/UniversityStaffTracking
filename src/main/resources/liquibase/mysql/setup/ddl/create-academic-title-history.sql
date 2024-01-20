create table tbl_academic_title_history(
	id bigint unsigned not null AUTO_INCREMENT,
	start_date datetime not null,
        end_date datetime,
        academic_title_id bigint unsigned not null,
        scientific_field_id bigint unsigned not null,
        member_id bigint unsigned not null,
	primary key (id),
        
        constraint academic_title_fk2 FOREIGN KEY (academic_title_id) REFERENCES tbl_academic_title(id),
        constraint scientific_field_fk2 FOREIGN KEY (scientific_field_id) REFERENCES tbl_scientific_field(id),
constraint member_fikk FOREIGN KEY (member_id) REFERENCES tbl_member(id) 
) 