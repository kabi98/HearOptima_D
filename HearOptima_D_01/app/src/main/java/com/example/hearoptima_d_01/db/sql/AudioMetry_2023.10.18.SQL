drop table IF EXISTS survey_list;
drop table IF EXISTS hrs_unit;
drop table IF EXISTS hrdi_unit;
drop table IF EXISTS hrdi_set;
drop table IF EXISTS hearing_aid;
drop table IF EXISTS hraid_image;
drop table IF EXISTS hraid_inform_image;
drop table IF EXISTS account;


CREATE TABLE IF NOT EXISTS account (
			acc_id 			INTEGER PRIMARY KEY AUTOINCREMENT
			, acc_phone_id 	TEXT UNIQUE NOT NULL
			, acc_phone 	TEXT
			, acc_pwd		TEXT
			, acc_name		TEXT
			, acc_gender	TEXT
			, acc_birth		TEXT );

CREATE TABLE IF NOT EXISTS hrdi_set (
            hrdis_id			INTEGER PRIMARY KEY AUTOINCREMENT
            , acc_id            INTEGER
            , hrdis_date        TEXT
            , hrdis_result      TEXT
            , hrdis_type        TEXT
            , FOREIGN KEY(acc_id) REFERENCES account(acc_id) );

CREATE TABLE IF NOT EXISTS hrdi_unit (
			hrdiu_id 			INTEGER PRIMARY KEY AUTOINCREMENT
			, hrdis_id			INTEGER
			, hrdiu_right_ACT 	INTEGER
			, hrdiu_right_BCT	INTEGER
			, hrdiu_right_WRS    INTEGER
			, hrdiu_left_ACT 	INTEGER
            , hrdiu_left_BCT 	INTEGER
            , hrdiu_left_WRS     INTEGER
			, FOREIGN KEY(hrdis_id) REFERENCES hrdi_set(hrdis_id));

CREATE TABLE IF NOT EXISTS hrs_unit (
            hrsu_id			INTEGER PRIMARY KEY AUTOINCREMENT
            , hrdis_id      INTEGER
            , hrsu_result	TEXT
            , FOREIGN KEY(hrdis_id) REFERENCES hrdi_set(hrdis_id) );

CREATE TABLE IF NOT EXISTS survey_list (
            sl_id			INTEGER PRIMARY KEY AUTOINCREMENT
            , sl_question   TEXT
            , sl_answer     TEXT
            , hrsu_id       INTEGER
            , FOREIGN KEY(hrsu_id) REFERENCES hrs_unit(hrsu_id) );

CREATE TABLE IF NOT EXISTS hearing_aid (
			ha_id 			INTEGER PRIMARY KEY AUTOINCREMENT
			, ha_name     TEXT
			, ha_type   	TEXT
			, ha_brand      TEXT
			, ha_bluetooth	TEXT
			, ha_content    TEXT
			, ha_insurance TEXT
			, ha_min_price      INTEGER
			, ha_max_price      INTEGER
			, ha_etc		TEXT
			, hri_id        INTEGER
			, hrii_id       INTEGER
			, FOREIGN KEY(hri_id) REFERENCES hraid_image(hri_id)
			, FOREIGN KEY(hrii_id) REFERENCES hraid_inform_image(hrii_id));

CREATE TABLE IF NOT EXISTS hraid_image (
			hri_id 			    INTEGER PRIMARY KEY AUTOINCREMENT
			, hri_file_name 	TEXT
			, hri_file_ext 	    TEXT
			, hri_content	    TEXT);

CREATE TABLE IF NOT EXISTS hraid_inform_image (
			hrii_id 			    INTEGER PRIMARY KEY AUTOINCREMENT
			, hrii_file_name 	TEXT
			, hrii_file_ext 	    TEXT
			, hrii_content	    TEXT);


INSERT INTO account (acc_id, acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth) VALUES ('1', '01012345678', '010-1234-5678', '111111', 'aaa', 'male', '11-11-11');
INSERT INTO account (acc_id, acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth) VALUES ('2', '01034567890', '010-3456-7890', '820101', '홍길동', '여', '82-01-01');


INSERT INTO hrdi_set (hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id) VALUES ('1', '2023-10-19 23:48:56', '정상', '정상', '1');
INSERT INTO hrdi_set (hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id) VALUES ('2', '2023-10-19 23:49:49', '중도난청', '보청기', '1');
INSERT INTO hrdi_set (hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id) VALUES ('3', '2023-10-19 23:50:56', '고도난청', '인공와우', '1');
INSERT INTO hrdi_set (hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id) VALUES ('4', '2023-10-19 23:53:12', '정상', '보청기', '2');
INSERT INTO hrdi_set (hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id) VALUES ('5', '2023-10-19 23:53:12', '중도난청', '보청기', '2');
INSERT INTO hrdi_set (hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id) VALUES ('6', '2023-10-19 23:53:12', '중도난청', '보청기', '2');
INSERT INTO hrdi_set (hrdis_id, hrdis_date, hrdis_result, hrdis_type, acc_id) VALUES ('7', '2023-10-19 23:53:12', '중고도난청', '보청기', '2');


INSERT INTO hrdi_unit (hrdiu_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS, hrdis_id) VALUES ('1', '10', '10', '100', '10', '10', '100', '1');
INSERT INTO hrdi_unit (hrdiu_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS, hrdis_id) VALUES ('2', '40', '40', '90', '40', '40', '90', '2');
INSERT INTO hrdi_unit (hrdiu_id, hrdiu_right_ACT, hrdiu_right_BCT, hrdiu_right_WRS, hrdiu_left_ACT, hrdiu_left_BCT, hrdiu_left_WRS, hrdis_id) VALUES ('3', '80', '80', '40', '80', '80', '40', '3');

INSERT INTO hrs_unit (hrsu_id, hrsu_result, hrdis_id) VALUES ('1', '정상', '4');
INSERT INTO hrs_unit (hrsu_id, hrsu_result, hrdis_id) VALUES ('2', '중도난청', '5');
INSERT INTO hrs_unit (hrsu_id, hrsu_result, hrdis_id) VALUES ('3', '중도난청', '6');
INSERT INTO hrs_unit (hrsu_id, hrsu_result, hrdis_id) VALUES ('4', '중고도난청', '7');

INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('1', 'Q1', 'A1', '1');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('2', 'Q2', 'A2', '1');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('3', 'Q3', 'A3', '1');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('4', 'Q4', 'A4', '1');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('5', 'Q5', 'A5', '1');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('6', 'Q6', 'A6', '1');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('7', 'Q7', 'A7', '1');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('8', 'Q1', 'A1', '2');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('9', 'Q2', 'A2', '2');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('10', 'Q3', 'A3', '2');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('11', 'Q4', 'A4', '2');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('12', 'Q5', 'A5', '2');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('13', 'Q6', 'A6', '2');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('14', 'Q7', 'A7', '2');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('15', 'Q1', 'A1', '3');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('16', 'Q2', 'A2', '3');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('17', 'Q3', 'A3', '3');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('18', 'Q4', 'A4', '3');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('19', 'Q5', 'A5', '3');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('20', 'Q6', 'A6', '3');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('21', 'Q7', 'A7', '3');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('22', 'Q1', 'A1', '4');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('23', 'Q2', 'A2', '4');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('24', 'Q3', 'A3', '4');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('25', 'Q4', 'A4', '4');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('26', 'Q5', 'A5', '4');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('27', 'Q6', 'A6', '4');
INSERT INTO survey_list (sl_id, sl_question, sl_answer, hrsu_id) VALUES ('28', 'Q7', 'A7', '4');

INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content) VALUES ('1', 'ks_sl_a1_001', 'jpg', 'sl_a1');
INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content) VALUES ('2', 'ks_sl_a1_002', 'jpg', 'sl_a1');
INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content) VALUES ('3', 'ks_sl_a1_003', 'jpg', 'sl_a1');
INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content) VALUES ('4', 'ks_sl_a1_004', 'jpg', 'sl_a1');
INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content) VALUES ('5', 'ks_sl_a1_005', 'jpg', 'sl_a1');

INSERT INTO hraid_inform_image (hrii_id, hrii_file_name, hrii_file_ext, hrii_content) VALUES ('1', 'ks_sl_a1_006', 'jpg', 'sl_a1');
INSERT INTO hraid_inform_image (hrii_id, hrii_file_name, hrii_file_ext, hrii_content) VALUES ('2', 'ks_sl_a1_007', 'jpg', 'sl_a1');
INSERT INTO hraid_inform_image (hrii_id, hrii_file_name, hrii_file_ext, hrii_content) VALUES ('3', 'ks_sl_a1_008', 'jpg', 'sl_a1');
INSERT INTO hraid_inform_image (hrii_id, hrii_file_name, hrii_file_ext, hrii_content) VALUES ('4', 'ks_sl_a1_009', 'jpg', 'sl_a1');
INSERT INTO hraid_inform_image (hrii_id, hrii_file_name, hrii_file_ext, hrii_content) VALUES ('5', 'ks_sl_a1_010', 'jpg', 'sl_a1');

INSERT INTO hearing_aid (ha_id, ha_name, ha_type, ha_brand, ha_bluetooth, ha_content, ha_insurance, ha_min_price, ha_max_price, ha_etc, hri_id, hrii_id) VALUES ('1', 'SKY M', '귀걸이형(BTE)', '포낙', '가능', '21 dB HL (경도난청)', '가능', '1200000', '3000000', '기타', '1', '1');
INSERT INTO hearing_aid (ha_id, ha_name, ha_type, ha_brand, ha_bluetooth, ha_content, ha_insurance, ha_min_price, ha_max_price, ha_etc, hri_id, hrii_id) VALUES ('2', 'Audeo P', '오픈형/충전형', '포낙', '가능', '18 dB HL (정상)', '가능', '1800000', '5000000', '기타', '2', '2');
INSERT INTO hearing_aid (ha_id, ha_name, ha_type, ha_brand, ha_bluetooth, ha_content, ha_insurance, ha_min_price, ha_max_price, ha_etc, hri_id, hrii_id) VALUES ('3', 'Audeo M', '오픈형 충전식', '포낙', '가능', '100 dB HL (심도난청)', '가능', '200000', '700000', '기타', '3', '3');
INSERT INTO hearing_aid (ha_id, ha_name, ha_type, ha_brand, ha_bluetooth, ha_content, ha_insurance, ha_min_price, ha_max_price, ha_etc, hri_id, hrii_id) VALUES ('4', 'Virto', '귓속형(ITE)', '포낙', '가능', '53 dB HL (중도난청)', '가능', '3000000', '8000000', '기타', '4', '4');
INSERT INTO hearing_aid (ha_id, ha_name, ha_type, ha_brand, ha_bluetooth, ha_content, ha_insurance, ha_min_price, ha_max_price, ha_etc, hri_id, hrii_id) VALUES ('5', 'Naida', '귀걸이형(BTE)', '포낙', '가능', '100 % (매우 우수)', '가능', '900000', '1500000', '기타', '5', '5');