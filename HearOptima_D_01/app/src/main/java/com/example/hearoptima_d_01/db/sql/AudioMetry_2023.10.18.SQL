
drop table IF EXISTS ptt_test_unit;
drop table IF EXISTS pt_track;
drop table IF EXISTS sentence_word;
drop table IF EXISTS audiometry_unit;
drop table IF EXISTS audiometry_set;

drop table IF EXISTS hrtest_unit;
drop table IF EXISTS hrtest_set;
drop table IF EXISTS hrtest_group;

drop table IF EXISTS sentence_unit;
drop table IF EXISTS audiometry_track;

drop table IF EXISTS account;


CREATE TABLE IF NOT EXISTS account (
			acc_id 			INTEGER PRIMARY KEY AUTOINCREMENT
			, acc_phone_id 	TEXT UNIQUE NOT NULL
			, acc_phone 	TEXT
			, acc_pwd		TEXT
			, acc_name		TEXT
			, acc_gender	TEXT
			, acc_birth		TEXT );

CREATE TABLE IF NOT EXISTS utresult_group (
			utrg_id			INTEGER PRIMARY KEY AUTOINCREMENT
			, utrg_date 	TEXT
			, utrg_result	TEXT
			, acc_id		INTEGER
			, FOREIGN KEY(acc_id) REFERENCES account(acc_id) );

CREATE TABLE IF NOT EXISTS utresult_unit (
			utru_id 			INTEGER PRIMARY KEY AUTOINCREMENT
			, utrg_id			INTEGER
			, utru_right_ACT 	INTEGER
			, utru_right_BCT	INTEGER
			, utru_right_WRS    INTEGER
			, utru_left_ACT 	INTEGER
            , utru_left_BCT 	INTEGER
            , utru_left_WRS     INTEGER
            , acc_id            INTEGER
			, FOREIGN KEY(acc_id) REFERENCES account(acc_id));

CREATE TABLE IF NOT EXISTS hearing_aid (
			ha_id 			INTEGER PRIMARY KEY AUTOINCREMENT
			, ha_haname     TEXT
			, ha_type   	TEXT
			, ha_brand      TEXT
			, ha_bluetooth	TEXT
			, ha_content    TEXT
			, ha_price      INTEGER);

CREATE TABLE IF NOT EXISTS hraid_image (
			hri_id 			    INTEGER PRIMARY KEY AUTOINCREMENT
			, hri_file_name 	TEXT
			, hri_file_ext 	    TEXT
			, hri_content	    TEXT
			, ha_id             INTEGER
			, FOREIGN KEY(ha_id) REFERENCES hearing_aid(ha_id));

--CREATE TABLE IF NOT EXISTS my_hearing_aid (
--            mhr_id              INTEGER PRIMARY KEY AUTOINCREMENT
--)


INSERT INTO account (acc_id, acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth) VALUES ('1', '01012345678', '010-1234-5678', '111111', 'aaa', 'male', '11-11-11');
INSERT INTO account (acc_id, acc_phone_id, acc_phone, acc_pwd, acc_name, acc_gender, acc_birth) VALUES ('2', '01034567890', '010-3456-7890', '820101', '홍길동', '여', '82-01-01');

--
--INSERT INTO utresult_group (utrg_id, utrg_date, utrg_result, utrg_type, acc_id) VALUES ('1', '2023-10-19 23:48:56', '경도난청', 'PTA', '1');
--INSERT INTO utresult_group (utrg_id, utrg_date, utrg_result, utrg_type, acc_id) VALUES ('2', '2023-10-19 23:49:49', '심도난청', 'PTA', '1');
--INSERT INTO utresult_group (utrg_id, utrg_date, utrg_result, utrg_type, acc_id) VALUES ('3', '2023-10-19 23:50:56', '중도난청', '', '1');
--INSERT INTO utresult_group (utrg_id, utrg_date, utrg_result, utrg_type, acc_id) VALUES ('4', '2023-10-19 23:53:12', 'PTA', '중도난청', '2');
--
--
--INSERT INTO myhraid_unit (utru_id, utrg_id, utru_right_ACT, utru_right_BCT, utru_right_WRS, utru_left_ACT, utru_left_BCT, utru_left_WRS, acc_id) VALUES ('1', '5', '약', '약', '1', '50', '0');
--INSERT INTO myhraid_unit (utru_id, utrg_id, utru_right_ACT, utru_right_BCT, utru_right_WRS, utru_left_ACT, utru_left_BCT, utru_left_WRS, acc_id) VALUES ('2', '5', '능', '능', '1', '50', '0');
--INSERT INTO myhraid_unit (utru_id, utrg_id, utru_right_ACT, utru_right_BCT, utru_right_WRS, utru_left_ACT, utru_left_BCT, utru_left_WRS, acc_id) VALUES ('3', '5', '논', '논', '1', '50', '0');
--INSERT INTO myhraid_unit (utru_id, utrg_id, utru_right_ACT, utru_right_BCT, utru_right_WRS, utru_left_ACT, utru_left_BCT, utru_left_WRS, acc_id) VALUES ('4', '5', '상', '상', '1', '50', '0');
--
--
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('1', '1', 'LEFT', '21', '21 dB HL (경도난청)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('2', '1', 'RIGHT', '18', '18 dB HL (정상)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('3', '2', 'LEFT', '100', '100 dB HL (심도난청)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('4', '2', 'RIGHT', '53', '53 dB HL (중도난청)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('5', '3', 'LEFT', '100', '100 % (매우 우수)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('6', '3', 'RIGHT', '40', '40 % (매우 저조)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('7', '4', 'LEFT', '25', '25 dB HL (경도난청)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('8', '4', 'RIGHT', '50', '50 dB HL (중도난청)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('9', '5', 'LEFT', '90', '90 % (우수)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('10', '5', 'RIGHT', '40', '40 % (매우 저조)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('11', '6', 'LEFT', '90', '90 % (우수)');
--INSERT INTO hearing_aid (ha_id, ha_haname, ha_type, ha_brand, ha_bluetooth, ha_content, ha_price) VALUES ('12', '6', 'RIGHT', '40', '40 % (매우 저조)');
--
--
--INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content, ha_id) VALUES ('ks_sl_a1_001','mp3','sl_a1','백화점에 가서 목걸이와 반지를 샀습니다');
--INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content, ha_id) VALUES ('ks_sl_a1_002','mp3','sl_a1','휴지를 버려 주세요');
--INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content, ha_id) VALUES ('ks_sl_a1_003','mp3','sl_a1','우체국은 병원 앞에 있어요');
--INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content, ha_id) VALUES ('ks_sl_a1_004','mp3','sl_a1','약을 하루에 두 번씩 드세요');
--INSERT INTO hraid_image (hri_id, hri_file_name, hri_file_ext, hri_content, ha_id) VALUES ('ks_sl_a1_005','mp3','sl_a1','감기에 걸리지 않도록 조심해라');