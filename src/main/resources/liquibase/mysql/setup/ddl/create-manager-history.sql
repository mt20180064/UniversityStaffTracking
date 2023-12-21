create table tbl_manager_history(
	id bigint unsigned not null AUTO_INCREMENT,
	start_date datetime not null,
        end_date datetime not null,
        member_id bigint unsigned,
        department_id bigint unsigned,
	primary key (id),
        constraint memberfkfk FOREIGN KEY (member_id) REFERENCES tbl_member(id),
        constraint departmentfkfk FOREIGN KEY (department_id) REFERENCES tbl_department(id)
);

