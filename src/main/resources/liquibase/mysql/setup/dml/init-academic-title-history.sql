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
INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  1,
  (SELECT academic_title_id FROM tbl_member WHERE id = 1),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 1),
  '2017-12-14 13:33:04',
  null
);
INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  2,
  (SELECT academic_title_id FROM tbl_member WHERE id = 2),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 2),
  '2018-12-10 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  3,
  (SELECT academic_title_id FROM tbl_member WHERE id = 3),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 3),
  '2020-09-14 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  4,
  (SELECT academic_title_id FROM tbl_member WHERE id = 4),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 4),
  '2015-12-11 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  5,
  (SELECT academic_title_id FROM tbl_member WHERE id = 5),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 5),
  '2022-12-14 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  6,
  (SELECT academic_title_id FROM tbl_member WHERE id = 6),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 6),
  '2020-02-14 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  7,
  (SELECT academic_title_id FROM tbl_member WHERE id = 7),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 7),
  '2010-10-14 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  8,
  (SELECT academic_title_id FROM tbl_member WHERE id = 8),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 8),
  '2019-10-05 13:33:04',
  null
);
INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  9,
  (SELECT academic_title_id FROM tbl_member WHERE id = 9),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 9),
  '2019-10-05 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  10,
  (SELECT academic_title_id FROM tbl_member WHERE id = 10),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 10),
  '2019-10-05 13:33:04',
  null
);
INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  11,
  (SELECT academic_title_id FROM tbl_member WHERE id = 11),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 11),
  '2020-10-05 13:33:04',
  null
);

INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  12,
  (SELECT academic_title_id FROM tbl_member WHERE id = 12),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 12),
  '2019-11-07 13:33:04',
  null
);
INSERT INTO tbl_academic_title_history (member_id, academic_title_id, scientific_field_id, start_date, end_date)
VALUES (
  13,
  (SELECT academic_title_id FROM tbl_member WHERE id = 13),
  (SELECT scientific_field_id FROM tbl_member WHERE id = 13),
  '2019-11-01 13:33:04',
  null
);

