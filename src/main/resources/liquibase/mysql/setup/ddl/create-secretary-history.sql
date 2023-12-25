create table tbl_secretary_history(
	id bigint unsigned not null AUTO_INCREMENT,
	start_date datetime not null,
        end_date datetime,
        member_id bigint unsigned,
        department_id bigint unsigned,
	primary key (id),
        constraint memberfkfkf FOREIGN KEY (member_id) REFERENCES tbl_member(id),
        constraint departmentfkfkf FOREIGN KEY (department_id) REFERENCES tbl_department(id)
)

