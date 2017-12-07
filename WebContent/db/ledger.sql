--DROP TABLE member_table;
--DROP TABLE group_table;
--DROP TABLE comment_table;
--DROP TABLE record_table;
--DROP TABLE event_table;
--DROP TABLE message_table;
--DROP TABLE invite_table;
--DROP TABLE request_table;
--DROP TABLE groupMember_table;
--DROP TABLE eventMember_table;
--DROP TABLE messageMember_table;
--DROP SEQUENCE group_seq;
--DROP SEQUENCE comments_seq;
--DROP SEQUENCE message_seq;
--DROP SEQUENCE record_seq;
--DROP SEQUENCE event_seq;




CREATE TABLE member_table(
memberId VARCHAR2(50) PRIMARY KEY,
password VARCHAR2(100),
nickName VARCHAR2(100),
name VARCHAR2(50),
email VARCHAR2(100),
account VARCHAR(100),
phoneNumber VARCHAR(100));

CREATE TABLE group_table(
groupId NUMBER PRIMARY KEY,
memberId VARCHAR2(50),
groupName VARCHAR2(100),
account VARCHAR2(100),
groupIntroduce VARCHAR2(300),
balance NUMBER(10,1) DEFAULT 0,
regDate DATE
);

CREATE TABLE comment_table(
commnetId NUMBER PRIMARY KEY,
recordId NUMBER,
memberId VARCHAR2(50),
content VARCHAR2(500),
regDate DATE
);

CREATE TABLE record_table(
recordId NUMBER PRIMARY KEY,
eventId NUMBER,
groupId NUMBER,
memberId VARCHAR2(50),
image VARCHAR2(500),
title VARCHAR2(100),
regDate DATE,
content VARCHAR2(1000),
accounting VARCHAR2(50) DEFAULT '수입',
caution VARCHAR2(20) DEFAULT '정상',
price NUMBER,
category VARCHAR2(50)
);

CREATE TABLE event_table(
eventId NUMBER PRIMARY KEY,
groupId NUMBER,
memberId VARCHAR2(50),
balance NUMBER(10,1) DEFAULT 0,
eventName VARCHAR2(100),
collection NUMBER(10,1) DEFAULT 0,
regDate DATE
);

CREATE TABLE message_table(
messageId NUMBER PRIMARY KEY,
eventId NUMBER,
sendMemberId VARCHAR2(50),
title VARCHAR2(100),
content VARCHAR2(1000),
regDate DATE
);

CREATE TABLE invite_table(
groupId NUMBER,
receiveMemberId VARCHAR2(50)
);

CREATE TABLE request_table(
groupId NUMBER,
memberId VARCHAR2(50),
regDate DATE
);

CREATE TABLE groupMember_table(
groupId NUMBER,
memberId VARCHAR2(50),
grade VARCHAR2(50) DEFAULT '멤버'
);

CREATE TABLE eventMember_table(
eventId NUMBER,
memberId VARCHAR2(50),
payment VARCHAR2(50) DEFAULT '미납'
);

CREATE TABLE messageMember_table(
memberId VARCHAR2(50),
messageId NUMBER
);


CREATE SEQUENCE group_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comments_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE message_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE record_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE event_seq START WITH 1 INCREMENT BY 1;

commit;
ALTER TABLE group_table ADD groupImage varchar(300);
commit;
ALTER TABLE event_table ADD budget NUMBER(10,1);
ALTER TABLE event_table ADD groupSupport NUMBER(10,1);
commit;