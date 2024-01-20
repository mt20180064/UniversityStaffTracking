INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Software development'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Roko')),
  '2022-03-11 14:56:00',  '2023-08-21 14:56:00'
  
);


INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Social sciences'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Tor')),
  '2022-08-15 14:40:00',  '2023-04-20 10:52:00'
  
);

INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Physics'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Mega')),
  '2020-11-07 14:56:00',  '2023-10-08 14:56:00'
  
);

INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Mathematics'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Ozutak')),
  '2021-11-15 14:56:00',  '2023-12-20 14:56:00'
  
);

INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  1,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 3),
  '2021-12-14 13:33:04',  null
  
);

INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  2,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 5),
  '2021-12-10 13:33:04',  null
  
);

INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  3,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 7),
  '2021-02-14 13:33:04',  null
  
);

INSERT INTO tbl_secretary_history (department_id, member_id, start_date, end_date)
VALUES (
  4,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 11),
  '2021-01-01 13:33:04',  null
  
);