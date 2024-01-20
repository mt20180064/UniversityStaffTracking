INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Software development'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Eko')),
  '2020-12-14 13:33:04',  '2022-11-15 14:56:00'
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Software development'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Roko')),
  '2022-11-15 14:56:00',  '2023-12-20 14:56:00'
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Social sciences'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Tor')),
  '2020-12-14 13:33:04',  '2022-11-15 14:56:00'
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Social sciences'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')),
  '2020-12-14 13:33:04',  '2022-11-15 14:56:00'
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Social sciences'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')),
  '2020-12-14 13:33:04',  '2022-11-15 14:56:00'
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Mathematics'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Djino')),
  '2020-12-14 13:33:04',  '2022-11-15 14:56:00'
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_department WHERE name = 'Physics'),
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = (SELECT id FROM tbl_member WHERE firstname = 'Dona')),
  '2020-12-14 13:33:04',  '2022-11-15 14:56:00'
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  1,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 2),
  '2021-12-14 13:33:04',  null
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  2,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 6),
  '2021-12-10 13:33:04',  null
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  3,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 8),
  '2021-02-14 13:33:04',  null
  
);

INSERT INTO tbl_manager_history (department_id, member_id, start_date, end_date)
VALUES (
  4,
  (SELECT m.id FROM tbl_member m JOIN tbl_department d ON (m.department_id=d.id) WHERE m.id = 10),
  '2021-01-01 13:33:04',  null
  
);
