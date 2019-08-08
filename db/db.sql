drop table permission;

drop table role;

drop table role_permission;

drop table student_course;

drop table course;

drop table student;

drop table genearch;

drop table teacher;

drop table user;

drop table user_role;

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
    `id`         BIGINT(11) AUTO_INCREMENT,
    `name`       VARCHAR(255) NOT NULL, # 家长姓名
    `sex`        INT          NOT NULL, # 家长性别
    `profession` VARCHAR(255),          # 家长职业
    `phone`      VARCHAR(255) NOT NULL, # 家长电话号码
    `wechat`     VARCHAR(255),          # 家长微信号
    `qq`         VARCHAR(255),          # 家长qq号码
    `email`      VARCHAR(255),          # 家长邮箱
    `mark`       VARCHAR(255),          # 备注
    PRIMARY KEY
        (
         `id`
            )
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


# 老师
CREATE TABLE IF NOT EXISTS `teacher`
(
    `id`   BIGINT(11) UNIQUE AUTO_INCREMENT,
    `name` VARCHAR(255), # 教师名称
    `sex`  INT NOT NULL, # 教师性别
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 创建学员表

CREATE TABLE IF NOT EXISTS `student`
(
    `id`                BIGINT(11) UNIQUE AUTO_INCREMENT,
    `name`              VARCHAR(255) NOT NULL, # 学员姓名
    `sex`               INT          NOT NULL, # 学员性别
    `class`             VARCHAR(255) NOT NULL, # 学员年级
    `genearch_id`       BIGINT(11)   NOT NULL, # 学员家长姓名
    `genearch_relation` VARCHAR(255),          # 学员和家长关系
    `mark`              VARCHAR(255),          # 备注
    PRIMARY KEY (id),
    FOREIGN KEY (genearch_id) REFERENCES genearch (id)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 课程
CREATE TABLE IF NOT EXISTS `course`
(
    `id`              BIGINT(11) UNIQUE AUTO_INCREMENT,
    `name`            VARCHAR(255) NOT NULL, # 课程名称
    `date`            DATE         NOT NULL, # 开课日期
    `teacher_id`      BIGINT(11)   NOT NULL, # 任课老师
    `course_sum`      INT          NOT NULL, # 课时数
    `total_price`     DOUBLE       NOT NULL, # 课程原总价
    `unit_price`      DOUBLE       NOT NULL, # 课程原单价
    `act_course_sum`  INT,                   # 活动课时数
    `act_total_price` DOUBLE,                # 活动总价
    `act_unit_price`  DOUBLE,                # 活动单价
    `act_name`        VARCHAR(255),          # 活动名称
    `course_remain`   INT,                   # 剩余课时数
    `remain_price`    DOUBLE,                # 剩余余额
    `class_ref`       INT,                   # 课程参考年级
    `mark`            VARCHAR(255),          # 备注
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES teacher (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 学生课程

CREATE TABLE IF NOT EXISTS `student_course`
(
    `student_id` BIGINT(11), # 学员ID
    `course_id`  BIGINT(11), # 课程ID
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

DELETE FROM teacher;
INSERT INTO teacher (name, sex)
values ('海马', 2);
INSERT INTO teacher (name, sex)
values ('布丁', 1);
INSERT INTO teacher (name, sex)
values ('丸子', 1);
INSERT INTO teacher (name, sex)
values ('月亮', 1);
INSERT INTO teacher (name, sex)
values ('樱桃', 1);
INSERT INTO teacher (name, sex)
values ('太阳', 1);
INSERT INTO teacher (name, sex)
values ('小熊', 1);
#*************************************insert data end**************************************************************************************=

