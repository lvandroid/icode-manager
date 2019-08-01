# 创建用户表
CREATE TABLE IF NOT EXISTS `user`
(
    `id`              INT UNIQUE AUTO_INCREMENT,
    `name`            VARCHAR(100) NOT NULL,
    `password`        VARCHAR(100) NOT NULL,
    `role`            INT          NOT NULL,
    `phone`           VARCHAR(11),
    `submission_date` DATE,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 学员家长表
CREATE TABLE IF NOT EXISTS `genearch`
(
    `id`         INT AUTO_INCREMENT,
    `name`       VARCHAR(30) NOT NULL, # 家长姓名
    `sex`        INT         NOT NULL, # 家长性别
    `profession` VARCHAR(30),          # 家长职业
    `phone`      VARCHAR(11) NOT NULL, # 家长电话号码
    `wechat`     VARCHAR(50),          # 家长微信号
    `qq`         VARCHAR(20),          # 家长qq号码
    `email`      VARCHAR(50),          # 家长邮箱
    `mark`       VARCHAR(100),         # 备注
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


# 老师
CREATE TABLE IF NOT EXISTS `teacher`
(
    `id`   INT UNIQUE AUTO_INCREMENT,
    `name` VARCHAR(30),  # 教师名称
    `sex`  INT NOT NULL, # 教师性别
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 创建学员表

CREATE TABLE IF NOT EXISTS `student`
(
    `id`                INT UNIQUE AUTO_INCREMENT,
    `name`              VARCHAR(30) NOT NULL, # 学员姓名
    `sex`               INT         NOT NULL, # 学员性别
    `class`             VARCHAR(10) NOT NULL, # 学员年级
    `genearch_id`       INT         NOT NULL, # 学员家长姓名
    `genearch_relation` VARCHAR(20),          # 学员和家长关系
    `mark`              VARCHAR(100),         # 备注
    PRIMARY KEY (id),
    FOREIGN KEY (genearch_id) REFERENCES genearch (id)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 课程
CREATE TABLE IF NOT EXISTS `course`
(
    `id`              INT UNIQUE AUTO_INCREMENT,
    `name`            VARCHAR(60) NOT NULL, # 课程名称
    `date`            DATE        NOT NULL, # 开课日期
    `teacher_id`      INT         NOT NULL, # 任课老师
    `course_sum`      INT         NOT NULL, # 课时数
    `total_price`     DOUBLE      NOT NULL, # 课程原总价
    `unit_price`      DOUBLE      NOT NULL, # 课程原单价
    `act_course_sum`  INT,                  # 活动课时数
    `act_total_price` DOUBLE,               # 活动总价
    `act_unit_price`  DOUBLE,               # 活动单价
    `act_name`        VARCHAR(30),          # 活动名称
    `course_remain`   INT,                  # 剩余课时数
    `remain_price`    DOUBLE,               # 剩余余额
    `class_ref`       INT,                  # 课程参考年级
    `mark`            VARCHAR(100),         # 备注
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES teacher (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 学生课程

CREATE TABLE IF NOT EXISTS `student_course`
(
    `student_id` INT, # 学员ID
    `course_id`  INT, # 课程ID
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
