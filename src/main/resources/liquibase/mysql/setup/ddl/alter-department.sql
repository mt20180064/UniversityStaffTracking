ALTER TABLE tbl_department
ADD CONSTRAINT manager_fk FOREIGN KEY (manager_id) REFERENCES tbl_member(id),
ADD CONSTRAINT secretary_fk FOREIGN KEY (secretary_id) REFERENCES tbl_member(id);
