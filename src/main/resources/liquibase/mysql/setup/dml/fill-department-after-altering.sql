

UPDATE tbl_department
SET manager_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Eko"),
 secretary_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Roko")
WHERE name = 'Software development';

UPDATE tbl_department
SET manager_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Beli"),
 secretary_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Tor")
WHERE name = 'Social sciences';

UPDATE tbl_department
SET manager_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Ozi"),
 secretary_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Djino")
WHERE name = 'Mathematics';

UPDATE tbl_department
SET manager_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Viktor"),
 secretary_id = (select (m.id) from tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.firstname="Mega")
WHERE name = 'Physics';