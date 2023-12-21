INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_member WHERE firstname = 'Eko'),
  (SELECT academic_title_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Eko')),
  (SELECT scientific_field_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Eko')),
  '2020-12-14 13:33:04',  '2022-11-15 14:56:00'
  
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_member WHERE firstname = 'Eko'),
  (SELECT academic_title_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Eko')-1),
  (SELECT scientific_field_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Eko')),
  '2017-12-14 13:33:04',
  '2020-12-14 13:33:04'
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_member WHERE firstname = 'Roko'),
  (SELECT academic_title_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Roko')+1),
  (SELECT scientific_field_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Roko')),
  '2017-12-14 13:33:04',
  '2018-12-14 13:33:04'
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_member WHERE firstname = 'Beli'),
  (SELECT academic_title_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')-2),
  (SELECT scientific_field_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')),
  '2018-12-14 13:33:04',
  '2019-12-14 13:33:04'
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_member WHERE firstname = 'Beli'),
  (SELECT academic_title_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')-1),
  (SELECT scientific_field_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')),
  '2019-12-14 13:33:04',
  '2021-12-14 13:33:04'
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_member WHERE firstname = 'Beli'),
  (SELECT academic_title_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')),
  (SELECT scientific_field_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Beli')),
  '2021-12-14 13:33:04' , '2023-05-06 14:56:00'

);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  (SELECT id FROM tbl_member WHERE firstname = 'Tor'),
  (SELECT academic_title_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Tor')),
  (SELECT scientific_field_id FROM tbl_member WHERE id = (SELECT id FROM tbl_member WHERE firstname = 'Tor')),
  '2020-12-14 13:33:04' , '2022-05-04 14:56:00'

);

