# drop table permission;

# drop table role;

# drop table role_permission;
#
# drop table student_course;
#
# drop table course;
#
# drop table student;
#
# drop table genearch;
#
# drop table teacher;
#
# drop table user;
#
# drop table user_role;

#=====================================create table start====================================================================
# 创建用户表
CREATE TABLE IF NOT EXISTS `user`
(
    `id`       BIGINT(11) UNIQUE AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE IF NOT EXISTS `role`
(
    `id`   BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user_role`
(
    `user_id` BIGINT(11) NOT NULL,
    `role_id` BIGINT(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `role_permission`
(
    `role_id`       BIGINT(11) NOT NULL,
    `permission_id` BIGINT(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `permission`
(
    `id`          BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `url`         VARCHAR(255) NOT NULL,
    `name`        VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NULL,
    `pid`         BIGINT(11)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
# 学员家长表
CREATE TABLE IF NOT EXISTS `genearch`
(
    `id`         VARCHAR(11),
    `name`       VARCHAR(255) NOT NULL, # 家长姓名
    `sex`        INT          NOT NULL, # 家长性别
    `profession` VARCHAR(255),          # 家长职业
    `phone`      VARCHAR(11)  NOT NULL, # 家长电话号码
    `wechat`     VARCHAR(255),          # 家长微信号
    `qq`         VARCHAR(255),          # 家长qq号码
    `email`      VARCHAR(255),          # 家长邮箱
    `mark`       VARCHAR(255),          # 备注
    PRIMARY KEY
        (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


# 老师
CREATE TABLE IF NOT EXISTS `teacher`
(
    `id`         BIGINT(11) UNIQUE AUTO_INCREMENT,
    `name`       VARCHAR(255), # 教师名称
    `sex`        INT NOT NULL, # 教师性别
    `entry_date` BIGINT,
    `phone`      VARCHAR(11),
    `mark`       VARCHAR(255),

    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 创建学员表

CREATE TABLE IF NOT EXISTS `student`
(
    `id`          VARCHAR(11) UNIQUE PRIMARY KEY,
    `phone`       VARCHAR(11)  NOT NULL UNIQUE,
    `name`        VARCHAR(255) NOT NULL, # 学员姓名
    `sex`         INT          NOT NULL, # 学员性别
    `grade`       VARCHAR(16)  NOT NULL, # 学员年级
    `genearch_id` VARCHAR(11)  NOT NULL, # 学员家长姓名
    `mark`        VARCHAR(255),          # 备注
    `refer_id`    VARCHAR(11),
    `enable`      BOOL DEFAULT FALSE COMMENT '是否激活',
    FOREIGN KEY (genearch_id) REFERENCES genearch (id)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 课程
CREATE TABLE IF NOT EXISTS `course`
(
    `id`              BIGINT UNIQUE AUTO_INCREMENT,
    `name`            VARCHAR(255) NOT NULL COMMENT '课程名称',
    `start_date`      BIGINT       NOT NULL COMMENT '开课日期',
    `end_date`        BIGINT       NOT NULL COMMENT '结课日期',
    `course_type_id`  BIGINT,
    `teacher_id`      BIGINT       NULL COMMENT '任课老师',
    `course_sum`      INT          NOT NULL COMMENT '课时数',
    `total_price`     DOUBLE       NOT NULL COMMENT '课程原总价',
    `unit_price`      DOUBLE       NOT NULL COMMENT '课程原单价',
    `act_course_sum`  INT COMMENT '活动课时数',
    `act_total_price` DOUBLE COMMENT '活动总价',
    `act_unit_price`  DOUBLE COMMENT '活动单价',
    `act_name`        VARCHAR(255) COMMENT '活动名称',
    `class_ref`       VARCHAR(16) COMMENT '课程参考年级',
    `mark`            VARCHAR(255) COMMENT '备注',
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES teacher (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 学生课程
CREATE TABLE IF NOT EXISTS `course_type`
(
    `id`   BIGINT UNIQUE AUTO_INCREMENT COMMENT '课程类型id',
    `name` VARCHAR(128) COMMENT '课程名称',
    `type` INT COMMENT '课程类型',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '课程类型';
delete from course_type where id!='';

INSERT INTO course_type(name, type)
VALUES ('结构搭建', 1);
INSERT INTO course_type(name, type)
VALUES ('刷卡编程', 2);
INSERT INTO course_type(name, type)
VALUES ('Scratch', 3);
INSERT INTO course_type(name, type)
VALUES ('App Inventor', 4);
INSERT INTO course_type(name, type)
VALUES ('Python', 5);
INSERT INTO course_type(name, type)
VALUES ('C++', 6);
INSERT INTO course_type(name, type)
VALUES ('NOIP', 7);
INSERT INTO course_type(name, type)
VALUES ('其他', 8);

CREATE TABLE IF NOT EXISTS `teacher_course_type`
(
    `teacher_id`     BIGINT NOT NULL,
    `course_type_id` BIGINT NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES teacher (id),
    FOREIGN KEY (course_type_id) REFERENCES course_type (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '教师课程类型对应表';

CREATE TABLE IF NOT EXISTS `student_course`
(
    `student_id`    VARCHAR(11) COMMENT '学员ID',
    `course_id`     BIGINT(11) COMMENT '课程ID',
    `course_remain` DOUBLE COMMENT '剩余课程数',
    `remain_price`  DOUBLE COMMENT '剩余余额',
    `updateDate`    BIGINT COMMENT '上次更新时间',
    `enable`        BOOL COMMENT '是否可以被销课',
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

#*************************************create table end**************************************************************************************

#=====================================insert data start====================================================================
INSERT INTO user (id, username, password)
VALUES (1, 'user', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO user (id, username, password)
VALUES (2, 'admin', 'e10adc3949ba59abbe56e057f20f883e');

INSERT INTO role (id, name)
VALUES (1, 'USER');

INSERT INTO role (id, name)
VALUES (2, 'ADMIN');

INSERT INTO permission (id, url, name, pid)
VALUES (1, '/**', '', 0);

INSERT INTO permission (id, url, name, pid)
VALUES (2, '/**', '', 0);

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (2, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (2, 2);

INSERT INTO role_permission (role_id, permission_id)
VALUES (1, 1);
INSERT INTO role_permission (role_id, permission_id)
VALUES (2, 1);
INSERT INTO role_permission (role_id, permission_id)
VALUES (2, 2);

DELETE
FROM role_permission
WHERE role_id = 2;

# INSERT INTO teacher (name, sex)
# values ('海马', 2);
# INSERT INTO teacher (name, sex)
# values ('布丁', 1);
# INSERT INTO teacher (name, sex)
# values ('丸子', 1);
# INSERT INTO teacher (name, sex)
# values ('月亮', 1);
# INSERT INTO teacher (name, sex)
# values ('樱桃', 1);
# INSERT INTO teacher (name, sex)
# values ('太阳', 1);
# INSERT INTO teacher (name, sex)
# values ('小熊', 1);

#*************************************insert data end**************************************************************************************=


# ALTER TABLE course
#     ADD COLUMN course_type_id BIGINT;
ALTER TABLE course
    ADD FOREIGN KEY (course_type_id) REFERENCES course_type (id);


# 2019-08-14

# ALTER TABLE teacher
#     ADD COLUMN entry_date BIGINT;
# ALTER TABLE teacher
#     ADD COLUMN mark VARCHAR(128);



# SELECT c.*, ct.name AS course_type
# FROM course AS c LEFT JOIN course_type ct on c.course_type_id = ct.id
# ORDER BY id DESC;

/**
  查询教师课程关联
 */
# select t.*, GROUP_CONCAT(ct.name SEPARATOR ' ') AS course_type_names
# from teacher t
#          left join teacher_course_type tct on t.id = tct.teacher_id
#          left join course_type ct on tct.course_type_id = ct.id GROUP BY t.id;

# 20190815

SELECT *
FROM teacher
where teacher.phone = '';

# 修改学生课程表，涉及到销课
# ALTER TABLE student_course
#     ADD COLUMN unitPrice DOUBLE COMMENT '单价';
# ALTER TABLE student_course
#     ADD COLUMN updateDate BIGINT COMMENT '上次更新时间';
# ALTER TABLE student_course
#     ADD COLUMN enable BOOL COMMENT '是否可以被销课';

# 修改 student主键为手机号码
# ALTER TABLE student
#     DROP PRIMARY KEY;
# ALTER TABLE student
#     ADD COLUMN phone VARCHAR(11) PRIMARY KEY;
#删除原来的id外键
# ALTER TABLE student
#     DROP foreign key student_ibfk_1;

# 修改 student id类型
# ALTER TABLE student_course
# #     DROP FOREIGN KEY student_course_ibfk_1;
#     MODIFY student_id VARCHAR(11) NOT NULL;
# ALTER TABLE student_course
#     ADD FOREIGN KEY (student_id) REFERENCES student (id);
# ALTER TABLE student
#     ADD PRIMARY KEY (id);

# course添加是否有活动字段
# ALTER TABLE course
#     ADD COLUMN hasAct BOOL DEFAULT FALSE;
# student添加是否激活状态和推荐人字段，报名成功才算激活
# ALTER TABLE student
#     ADD COLUMN enable BOOL DEFAULT FALSE COMMENT '是否激活';
# ALTER TABLE student
#     ADD COLUMN referId VARCHAR(11) COMMENT '推荐人ID';
#修改家长id类型
# ALTER TABLE genearch
#     DROP PRIMARY KEY;
# ALTER TABLE genearch
#     MODIFY COLUMN id VARCHAR(11) UNIQUE;
# ALTER TABLE genearch
#     ADD PRIMARY KEY (id);
# ALTER TABLE student
#     ADD FOREIGN KEY (refer_id) REFERENCES genearch (id);
# ALTER TABLE student
#     MODIFY COLUMN genearch_id VARCHAR(11);
# ALTER TABLE student
#     change class grade VARCHAR(16);

#新增学员家长关系表
CREATE TABLE IF NOT EXISTS `student_genearch`
(
    `student_id`  VARCHAR(11) NOT NULL,
    `genearch_id` VARCHAR(11) NOT NULL,
    `relation`    VARCHAR(128) COMMENT '学员家长之间的关系',
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (genearch_id) REFERENCES genearch (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

#删除student genearch_relation字段
# ALTER TABLE student
#     DROP COLUMN genearch_relation;

ALTER TABLE student
    ADD COLUMN update_date BIGINT;

ALTER TABLE genearch
    ADD COLUMN update_date BIGINT;

delete
from student
where id = '';


