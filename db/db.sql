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
    `id`          BIGINT(11)   NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(255) NOT NULL,
    `description` VARCHAR(255),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `user_role`
(
    `user_id`   BIGINT(11) NOT NULL,
    `role_id`   BIGINT(11) NOT NULL,
    `root_role` boolean default false comment '是否是最高权限的角色'
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
    `id`             BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name`           VARCHAR(255) NOT NULL COMMENT '学员姓名',
    `phone`          VARCHAR(11)  NOT NULL COMMENT '联系电话',
    `genearch`       VARCHAR(16)  NOT NULL COMMENT '联系电话人关系',
    `phone_sec`      VARCHAR(11) COMMENT '次要联系人',
    `genearch_sec`   VARCHAR(16) COMMENT '次要联系人关系',
    `phone_other`    VARCHAR(11) COMMENT '其他联系人',
    `genearch_other` VARCHAR(16) COMMENT '其他联系人关系',
    `sex`            VARCHAR(16)  NOT NULL COMMENT '学员性别',
    `id_card`        VARCHAR(18) COMMENT '身份证号码',
    `wechat`         VARCHAR(64) COMMENT '微信号',
    `birthday`       BIGINT COMMENT '生日',
    `school`         VARCHAR(64) COMMENT '学校',
    `grade`          VARCHAR(16) COMMENT '学员年级',
    `class_num`      VARCHAR(16) COMMENT '班级',
    `home_address`   VARCHAR(64) COMMENT '居住地址',
    `refer_phone`    VARCHAR(11) COMMENT '推荐人电话',
    `mark`           VARCHAR(255) COMMENT '备注',
    `entry_time`     BIGINT COMMENT '录入时间',
    `create_time`    timestamp    null                             DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
    `update_time`    timestamp    null on update CURRENT_TIMESTAMP default CURRENT_TIMESTAMP COMMENT '更新时间',
    `enable`         BOOL                                          DEFAULT FALSE COMMENT '是否激活'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table if not exists `school`
(
    `id`   BIGINT AUTO_INCREMENT primary key,
    `name` VARCHAR(32) NOT NULL COMMENT '学校名称'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table if not exists `class_name`
(
    `id`   BIGINT AUTO_INCREMENT primary key,
    `name` VARCHAR(32) NOT NULL COMMENT '班级名称'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table if not exists `home_address`
(
    `id`   BIGINT auto_increment primary key,
    `name` VARCHAR(128) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '居住地址';

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
delete
from course_type
where id != '';

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

# 员工表
CREATE TABLE IF NOT EXISTS `staff`
(
    `id`                  BIGINT AUTO_INCREMENT COMMENT '员工ID',
    `user_id`             BIGINT COMMENT '登录系统的ID',
    `name`                VARCHAR(16)  NOT NULL COMMENT '姓名',
    `nick_name`           VARCHAR(32) COMMENT '花名',
    `name_en`             VARCHAR(128) COMMENT '英文名',
    `phone`               VARCHAR(11) COMMENT '本人联系方式',
    `phone_company`       VARCHAR(11) COMMENT '公司分配的手机号',
    `sex`                 INT COMMENT '性别',
    `department_id`       BIGINT COMMENT '部门ID',
    `id_card_no`          VARCHAR(18)  NOT NULL COMMENT '身份证号码',
    `id_card_address`     VARCHAR(256) NOT NULL COMMENT '身份证地址',
    `birthday`            LONG COMMENT '生日',
    `email`               VARCHAR(128) COMMENT '邮箱',
    `address_now`         VARCHAR(256) COMMENT '现住地址',
    `famous_family`       VARCHAR(32) COMMENT '名族',
    `political_status`    VARCHAR(16) COMMENT '政治面貌',
    `married`             INT COMMENT '婚姻',
    `graduated_school`    VARCHAR(128) COMMENT '毕业学校',
    `profession`          VARCHAR(32) COMMENT '专业',
    `education`           VARCHAR(32) COMMENT '学历',
    `train_experience`    VARCHAR(128) COMMENT '培训经历',
    `entry_date`          LONG COMMENT '入职时间',
    `turn_positive_date`  LONG COMMENT '转正时间',
    `payroll_card`        VARCHAR(32) COMMENT '工资卡号',
    `pay_roll_card_bank`  VARCHAR(128) COMMENT '开户行',
    `emergency_one_name`  VARCHAR(16) COMMENT '紧急联系人一',
    `emergency_one_phone` VARCHAR(11) COMMENT '紧急联系人一号码',
    `emergency_two_name`  VARCHAR(16) COMMENT '紧急联系人二',
    `emergency_two_phone` VARCHAR(11) COMMENT '紧急联系人二号码',
    `parent_name`         VARCHAR(32) COMMENT '父母亲姓名',
    `parent_id_card`      VARCHAR(18) COMMENT '父母亲身份证号码',
    `parent_card_no`      VARCHAR(32) COMMENT '父母亲银行卡号',
    `parent_card_bank`    VARCHAR(128) COMMENT '父母亲银行卡开户行',
    `mark`                VARCHAR(256) COMMENT '备注',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '员工';

# 岗位表

CREATE TABLE IF NOT EXISTS `post`
(
    `id`   BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(64) COMMENT '岗位名称'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '岗位';

#员工岗位关联表 多对对
CREATE TABLE IF NOT EXISTS `staff_post`
(
    `id`       BIGINT AUTO_INCREMENT PRIMARY KEY,
    `staff_id` BIGINT,
    `post_id`  BIGINT,
    FOREIGN KEY (staff_id) REFERENCES staff (id),
    FOREIGN KEY (post_id) REFERENCES post (id)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '员工岗位表';

CREATE TABLE IF NOT EXISTS `personnel_status`
(
    `id`   BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(32) COMMENT '人事状态'
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8 COMMENT '人事状态表';

CREATE TABLE IF NOT EXISTS `staff_personnel_status`
(
    `id`                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    `staff_id`            BIGINT,
    `personnel_status_id` BIGINT,
    FOREIGN KEY (staff_id) REFERENCES staff (id),
    FOREIGN KEY (personnel_status_id) REFERENCES personnel_status (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 路由数据表

CREATE TABLE IF NOT EXISTS `router`
(
    `id`        BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '路由编号',
    `pid`       BIGINT       NOT NULL COMMENT '路由父节点编号',
    `name`      VARCHAR(32) COMMENT '路由名称',
    `label`     VARCHAR(32) COMMENT '标签',
    `id_path`   VARCHAR(128) COMMENT '全路径，每级使用 , 分割',
    `path`      VARCHAR(128) COMMENT '路由path',
    `component` VARCHAR(128) NOT NULL COMMENT '路由组件',
    `redirect`  VARCHAR(128) COMMENT '重定向路径',
    `hidden`    BOOL,
    `meta`      VARCHAR(128) COMMENT '路由元信息',
    `level`     INT COMMENT '路由层级',
    `type`      INT COMMENT '类型'

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '路由表';

# select *
# from router;
#
# INSERT INTO router(pid, path, component, hidden)
# VALUES (0, '/redirect', 'layout/Layout', true);
#
# INSERT INTO router(pid, path, component)
# VALUES (1, '/redirect/:path*', 'views/redirect/index');
#
# INSERT INTO router(pid, path, component, hidden)
# values (0, '/login', 'views/login/index', true);
#
# INSERT INTO router(pid, path, component, hidden)
# values (0, '/auth-redirect', 'views/login/auth-redirect', true);
#
# INSERT INTO router(pid, path, component, hidden)
# values (0, '/404', 'views/error-page/404', true);
#
# INSERT INTO router(pid, path, component, hidden)
# values (0, '/401', 'views/error-page/401', true);
#
# INSERT INTO router(pid, component, redirect)
# values (0, 'layout/Layout', 'dashboard');
#
# INSERT INTO router(pid, path, component, name, meta)
# values (7, 'dashboard', 'views/dashboard/index', 'Dashboard',
#         '{ title: ''Dashboard'', icon: ''dashboard'', affix: true }');
#
# INSERT INTO router(pid, path, component)
# values (0, '/documentation', 'layout/Layout');
#
# INSERT INTO router(pid, path, component, name, meta)
# values (9, 'index', 'views/documentation/index', 'Documentation',
#         '{ title: ''Documentation'', icon: ''documentation'', affix: true }');
#
# INSERT INTO router(pid, path, component, redirect)
# values (0, '/guide', 'layout/Layout', '/guide/index');
#
# INSERT INTO router(pid, path, component, name, meta)
# values (11, 'index', 'views/guide/index', 'Guide', '{ title: ''Guide'', icon: ''guide'', noCache: true }');
#

INSERT INTO router(pid, name, path, component, redirect, meta, type)
VALUES (0, 'Student', '/student', 'layout/Layout', '/student/list', '{ title: ''学员'', icon: ''example'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (13, 'StudentList', 'list', 'views/student/index', '{ title: ''学员列表'', icon: ''table'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (13, 'AddStudent', 'add', 'views/student/add', '{ title: ''新增学员'', icon: ''form'' }', 2);


INSERT INTO router(pid, name, path, component, redirect, meta, type)
VALUES (0, 'Staff', '/staff', 'layout/Layout', '/staff/list', '{ title: ''员工'', icon: ''example'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (16, 'StaffList', 'list', 'views/staff/index', '{ title: ''员工列表'', icon: ''table'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (16, 'AddStaff', 'add', 'views/staff/add', '{ title: ''新增员工'', icon: ''form'' }', 2);


INSERT INTO router(pid, name, path, component, redirect, meta, type)
VALUES (0, 'Teacher', '/teacher', 'layout/Layout', '/teacher/list', '{ title: ''教师'', icon: ''example'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (19, 'TeacherList', 'list', 'views/teacher/index', '{ title: ''教师列表'', icon: ''table'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (19, 'AddTeacher', 'add', 'views/teacher/add', '{ title: ''新增教师'', icon: ''form'' }', 2);


INSERT INTO router(pid, name, path, component, redirect, meta, type)
VALUES (0, 'Course', '/course', 'layout/Layout', '/course/list', '{ title: ''课程'', icon: ''example'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (23, 'CourseList', 'list', 'views/course/index', '{ title: ''课程列表'', icon: ''table'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (23, 'AddCourse', 'add', 'views/course/add', '{ title: ''新增课程'', icon: ''form'' }', 2);


INSERT INTO router(pid, name, path, component, redirect, meta, type)
VALUES (0, 'Account', '/accout', 'layout/Layout', '/account/role', '{ title: ''账号'', icon: ''example'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type)
VALUES (26, 'AccountList', 'list', 'views/account/role', '{ title: ''角色管理'', icon: ''table'' }', 2);

INSERT INTO router(pid, name, path, component, meta, type, label)
VALUES (26, 'UserList', 'userList', 'userList', 'userList ', 2, '用户管理');

insert into role_router(role_id, router_id)
values (2, 28);

create function getChildrenRouter(routerId bigint)
    returns varchar(10000)
begin
    declare oTemp varchar(10000);
    declare oTempChild varchar(10000);

    set oTemp = '';
    set oTempChild = cast(routerId as char);

    while oTempChild is not null
    do
    set oTemp = concat(oTemp, ',', oTempChild);
    select group_concat(id) into oTempChild from router where find_in_set(pid, oTempChild) > 0;
    end while;
    return otemp;
end;

# select *
# from router
# where find_in_set(id, getChildrenRouter(23));

# 角色路由表
create table if not exists `role_router`
(
    `id`        bigint auto_increment primary key,
    `role_id`   bigint,
    `router_id` bigint,
    foreign key (role_id) references role (id),
    foreign key (router_id) references router (id)
) engine = InnoDB
  default charset = utf8;

# select 1
# from router
# where id = 30
# limit 1;

# delete
# from role_router
# where id > 0;

# 批量插入admin 角色路由 存储过程

create procedure add_all_router(roleId bigint)
begin
    declare maxId bigint;
    declare i bigint;
    set i = 1;
    select max(id) into maxid from router;
    while i <= maxId do
    if exists(select 1 from router r where r.id = i) then
        insert into role_router(role_id, router_id) values (roleId, i);
    end if;
    set i = i + 1;
    end while;
end;

# select id
# from role
# where name = 'admin';

# call add_all_router(2);
# select count(1) from role_router;

# select r.*
# from role_router rr left join router r on rr.router_id = r.id where rr.role_id=2;

# select role_id
# from user_role
# where user_id = 2
#   and root_role = true;

# select component, meta
# from router;
# select r.id          AS id,
#        r.name        AS name,
#        r.description AS description,
#        rr.router_id  AS rr_id
# from role r
#          left join role_router rr on rr.role_id = r.id;
#
#
# select r.id          AS id,
#        r.name        AS name,
#        r.description AS description,
#        rr.id         as rr_id,
#        rr.router_id  AS router_id
# from role r
#          left join role_router rr on rr.role_id = r.id;


# select u.*, group_concat(r.name SEPARATOR ' ') as role_ids
# from user as u
#          left join user_role as ur on u.id = ur.user_id
#          left join role as r on ur.role_id = r.id
# where u.username like concat('%', 'ad', '%')
# group by u.id;
#
# select u.id       as id,
#        u.username as username,
#        u.password as password,
#        ur.role_id as role_id
# from user u
#          left join user_role ur on u.id = ur.user_id;

# select u.id       as user_id,
#        u.username as username,
#        u.password as password,
#        ur.role_id as role_id
#        group_concat(r.name SEPARATOR ' ') as role_names
# from user as u
#          left join user_role as ur on u.id = ur.user_id
#          left join role as r on ur.role_id = r.id;
# where ur.root_role = true;
# group by u.id;

SELECT @@GLOBAL.sql_mode;
SELECT @@SESSION.sql_mode;

set @@GLOBAL.sql_mode = '';

set sql_mode =
        'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

# select u.id as id,
#        u.username as username,
#        u.password as password,
#        ur.role_id as role_id
# from user as u left join user_role as ur on u.id=ur.user_id
#                left join role as r on ur.role_id=r.id
#
# select ur.role_id
# from user_role ur
# where user_id = 31
#   and ur.root_role = true

insert into permission(name, description, pid)
VALUES ('admin', '所有权限', 0);
insert into permission(name, description, pid)
VALUES ('staff', '员工', 3);
insert into permission(name, description, pid)
VALUES ('staffNew', '新建员工', 4);
insert into permission(name, description, pid)
VALUES ('staffEdit', '编辑员工', 4);
insert into permission(name, description, pid)
VALUES ('staffImport', '导出员工', 4);
insert into permission(name, description, pid)
VALUES ('staffDel', '删除员工', 4);

insert into permission(name, description, pid)
VALUES ('student', '学员', 3);
insert into permission(name, description, pid)
VALUES ('studentNew', '新建学员', 8);
insert into permission(name, description, pid)
VALUES ('studentEdit', '编辑学员', 8);
insert into permission(name, description, pid)
VALUES ('studentImport', '导出学员', 8);
insert into permission(name, description, pid)
VALUES ('studentDel', '删除学员', 8);

insert into permission(name, description, pid)
VALUES ('teacher', '教师', 3);
insert into permission(name, description, pid)
VALUES ('teacherNew', '新建教师', 12);
insert into permission(name, description, pid)
VALUES ('teacherEdit', '编辑教师', 12);
insert into permission(name, description, pid)
VALUES ('teacherImport', '导出教师', 12);
insert into permission(name, description, pid)
VALUES ('teacherDel', '删除教师', 12);

insert into permission(name, description, pid)
VALUES ('class', '班级', 3);
insert into permission(name, description, pid)
VALUES ('classNew', '新建班级', 16);
insert into permission(name, description, pid)
VALUES ('classEdit', '编辑班级', 16);
insert into permission(name, description, pid)
VALUES ('classImport', '导出班级', 16);
insert into permission(name, description, pid)
VALUES ('classDel', '删除班级', 16);


insert into school(name)
values ('邗江实验学校');
insert into school(name)
values ('外国语学校');
insert into school(name)
values ('施桥一小');
insert into school(name)
values ('求实实验小学');
insert into school(name)
values ('花园一小');

show variables like "%time_zone%";
SET global time_zone = "+8:00";