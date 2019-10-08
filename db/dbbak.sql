create table campus
(
    id   bigint auto_increment
        primary key,
    name varchar(32) null
)
    comment '校区' charset = utf8;

create table channel
(
    id   bigint auto_increment
        primary key,
    name varchar(32) null
)
    comment '渠道' charset = utf8;

create table class_name
(
    id   bigint auto_increment
        primary key,
    name varchar(32) not null comment '班级名称'
)
    charset = utf8;

create table consult_type
(
    id   bigint auto_increment
        primary key,
    name varchar(32) not null
)
    comment '咨询方式' charset = utf8;

create table course_type
(
    id   bigint auto_increment comment '课程类型id',
    name varchar(128) null comment '课程名称',
    type int          null comment '课程类型',
    constraint id
        unique (id)
)
    comment '课程类型' charset = utf8;

alter table course_type
    add primary key (id);

create table follow_status
(
    id   bigint auto_increment
        primary key,
    name varchar(32) null
)
    comment '跟进状态' charset = utf8;

create table genearch
(
    id          bigint auto_increment
        primary key,
    name        varchar(32) not null,
    update_date bigint      null
)
    charset = utf8;

create table grade
(
    id   bigint auto_increment
        primary key,
    name varchar(32) not null
)
    comment '年级' charset = utf8;

create table home_address
(
    id   bigint auto_increment
        primary key,
    name varchar(128) not null
)
    comment '居住地址' charset = utf8;

create table intention
(
    id   bigint auto_increment
        primary key,
    name varchar(32) null
)
    comment '意向度' charset = utf8;

create table keyword
(
    id   bigint auto_increment
        primary key,
    name varchar(32) null
)
    comment '关键词' charset = utf8;

create table permission
(
    id          bigint(11) auto_increment
        primary key,
    url         varchar(255) null,
    name        varchar(255) not null,
    description varchar(255) null,
    pid         bigint(11)   not null
)
    charset = utf8;

create table personnel_status
(
    id   bigint auto_increment
        primary key,
    name varchar(32) null comment '人事状态'
)
    comment '人事状态表' charset = utf8;

create table post
(
    id   bigint auto_increment
        primary key,
    name varchar(64) null comment '岗位名称'
)
    comment '岗位' charset = utf8;

create table role
(
    id          bigint(11) auto_increment
        primary key,
    name        varchar(255) not null,
    description varchar(255) null
)
    charset = utf8;

create table role_permission
(
    role_id       bigint(11) not null,
    permission_id bigint(11) not null
)
    charset = utf8;

create table router
(
    id        bigint auto_increment comment '路由编号'
        primary key,
    pid       bigint       not null comment '路由父节点编号',
    name      varchar(32)  null comment '路由名称',
    label     varchar(32)  null comment '标签',
    id_path   varchar(128) null comment '全路径，每级使用 , 分割',
    path      varchar(128) null comment '路由path',
    component varchar(128) not null comment '路由组件',
    redirect  varchar(128) null comment '重定向路径',
    hidden    tinyint(1)   null,
    meta      varchar(128) null comment '路由元信息',
    level     int          null comment '路由层级',
    type      int          null comment '类型'
)
    comment '路由表' charset = utf8;

create table role_router
(
    id        bigint auto_increment
        primary key,
    role_id   bigint null,
    router_id bigint null,
    constraint role_router_ibfk_1
        foreign key (role_id) references role (id),
    constraint role_router_ibfk_2
        foreign key (router_id) references router (id)
)
    charset = utf8;

create index role_id
    on role_router (role_id);

create index router_id
    on role_router (router_id);

create table school
(
    id   bigint auto_increment
        primary key,
    name varchar(32) not null comment '学校名称'
)
    charset = utf8;

create table student
(
    id             bigint auto_increment
        primary key,
    name           varchar(255)         not null comment '学员姓名',
    phone          varchar(11)          not null comment '联系电话',
    genearch       varchar(16)          not null comment '联系电话人关系',
    phone_sec      varchar(11)          null comment '次要联系人',
    genearch_sec   varchar(16)          null comment '次要联系人关系',
    phone_other    varchar(11)          null comment '其他联系人',
    genearch_other varchar(16)          null comment '其他联系人关系',
    sex            varchar(16)          not null comment '学员性别',
    id_card        varchar(18)          null comment '身份证号码',
    wechat         varchar(64)          null comment '微信号',
    birthday       bigint               null comment '生日',
    school         varchar(64)          null comment '学校',
    grade          varchar(16)          null comment '学员年级',
    class_name     varchar(16)          null comment '班级',
    home_address   varchar(64)          null comment '居住地址',
    refer_phone    varchar(11)          null comment '推荐人电话',
    mark           varchar(255)         null comment '备注',
    entry_time     bigint               null comment '录入时间',
    create_time    bigint               null comment '录入时间',
    update_time    bigint               null comment '更新时间',
    enable         tinyint(1) default 0 null comment '是否激活',
    update_date    bigint               null
)
    charset = utf8;

create table communicate_info
(
    id             bigint auto_increment
        primary key,
    student_id     bigint       null comment '学员id',
    content        varchar(128) null comment '沟通内容',
    revisit_remind mediumtext   null comment '回访提醒时间',
    create_time    bigint       null comment '添加时间',
    constraint communicate_info_ibfk_1
        foreign key (student_id) references student (id)
)
    comment '沟通记录' charset = utf8;

create index student_id
    on communicate_info (student_id);

create table follow_info
(
    id             bigint auto_increment
        primary key,
    student_id     bigint       null comment '学员id',
    consult_method varchar(32)  null comment '咨询方式',
    intention      varchar(32)  null comment '意向度',
    courses        varchar(128) null comment '咨询课程',
    status         varchar(32)  null comment '跟进状态',
    keyword        varchar(32)  null comment '关键词',
    update_time    bigint       null comment '更新时间',
    constraint follow_info_ibfk_1
        foreign key (student_id) references student (id)
)
    comment '跟进信息' charset = utf8;

create index student_id
    on follow_info (student_id);

create table teacher
(
    id         bigint(11) auto_increment,
    name       varchar(255) null,
    sex        int          not null,
    entry_date bigint       null,
    phone      varchar(11)  null,
    mark       varchar(255) null,
    constraint id
        unique (id)
)
    charset = utf8;

alter table teacher
    add primary key (id);

create table course
(
    id              bigint auto_increment,
    name            varchar(255) not null comment '课程名称',
    start_date      bigint       not null comment '开课日期',
    end_date        bigint       not null comment '结课日期',
    course_type_id  bigint       null,
    teacher_id      bigint       null comment '任课老师',
    course_sum      int          not null comment '课时数',
    total_price     double       not null comment '课程原总价',
    unit_price      double       not null comment '课程原单价',
    act_course_sum  int          null comment '活动课时数',
    act_total_price double       null comment '活动总价',
    act_unit_price  double       null comment '活动单价',
    act_name        varchar(255) null comment '活动名称',
    class_ref       varchar(16)  null comment '课程参考年级',
    mark            varchar(255) null comment '备注',
    constraint id
        unique (id),
    constraint course_ibfk_1
        foreign key (teacher_id) references teacher (id),
    constraint course_ibfk_2
        foreign key (course_type_id) references course_type (id),
    constraint course_ibfk_3
        foreign key (course_type_id) references course_type (id),
    constraint course_ibfk_4
        foreign key (course_type_id) references course_type (id)
)
    charset = utf8;

create index course_type_id
    on course (course_type_id);

create index teacher_id
    on course (teacher_id);

alter table course
    add primary key (id);

create table student_course
(
    student_id    bigint     null comment '学员ID',
    course_id     bigint(11) null comment '课程ID',
    course_remain double     null comment '剩余课程数',
    remain_price  double     null comment '剩余余额',
    updateDate    bigint     null comment '上次更新时间',
    enable        tinyint(1) null comment '是否可以被销课',
    constraint student_course_ibfk_1
        foreign key (student_id) references student (id),
    constraint student_course_ibfk_2
        foreign key (course_id) references course (id)
)
    charset = utf8;

create index course_id
    on student_course (course_id);

create index student_id
    on student_course (student_id);

create table teacher_course_type
(
    teacher_id     bigint not null,
    course_type_id bigint not null,
    constraint teacher_course_type_ibfk_1
        foreign key (teacher_id) references teacher (id),
    constraint teacher_course_type_ibfk_2
        foreign key (course_type_id) references course_type (id)
)
    comment '教师课程类型对应表' charset = utf8;

create index course_type_id
    on teacher_course_type (course_type_id);

create index teacher_id
    on teacher_course_type (teacher_id);

create table user
(
    id       bigint(11) auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    constraint id
        unique (id)
)
    charset = utf8;

alter table user
    add primary key (id);

create table staff
(
    id                  bigint auto_increment comment '员工ID'
        primary key,
    user_id             bigint       null comment '登录系统的ID',
    name                varchar(16)  not null comment '姓名',
    nick_name           varchar(32)  null comment '花名',
    name_en             varchar(128) null comment '英文名',
    phone               varchar(11)  null comment '本人联系方式',
    phone_company       varchar(11)  null comment '公司分配的手机号',
    sex                 int          null comment '性别',
    department_id       bigint       null comment '部门ID',
    id_card_no          varchar(18)  not null comment '身份证号码',
    id_card_address     varchar(256) not null comment '身份证地址',
    birthday            mediumtext   null comment '生日',
    email               varchar(128) null comment '邮箱',
    address_now         varchar(256) null comment '现住地址',
    famous_family       varchar(32)  null comment '名族',
    political_status    varchar(16)  null comment '政治面貌',
    married             int          null comment '婚姻',
    graduated_school    varchar(128) null comment '毕业学校',
    profession          varchar(32)  null comment '专业',
    education           varchar(32)  null comment '学历',
    train_experience    varchar(128) null comment '培训经历',
    entry_date          mediumtext   null comment '入职时间',
    turn_positive_date  mediumtext   null comment '转正时间',
    payroll_card        varchar(32)  null comment '工资卡号',
    pay_roll_card_bank  varchar(128) null comment '开户行',
    emergency_one_name  varchar(16)  null comment '紧急联系人一',
    emergency_one_phone varchar(11)  null comment '紧急联系人一号码',
    emergency_two_name  varchar(16)  null comment '紧急联系人二',
    emergency_two_phone varchar(11)  null comment '紧急联系人二号码',
    parent_name         varchar(32)  null comment '父母亲姓名',
    parent_id_card      varchar(18)  null comment '父母亲身份证号码',
    parent_card_no      varchar(32)  null comment '父母亲银行卡号',
    parent_card_bank    varchar(128) null comment '父母亲银行卡开户行',
    mark                varchar(256) null comment '备注',
    constraint staff_ibfk_1
        foreign key (user_id) references user (id)
)
    comment '员工' charset = utf8;

create table hand_info
(
    id              bigint auto_increment
        primary key,
    student_id      bigint      null,
    campus          varchar(32) null comment '校区',
    create_time     bigint      null comment '录入时间',
    channel         varchar(32) null comment '渠道',
    clerk_id        bigint      null comment '采单员id',
    salesman_id     bigint      null comment '销售员id',
    telemarketer_id bigint      null comment '电话销售员id',
    constraint hand_info_ibfk_1
        foreign key (clerk_id) references staff (id),
    constraint hand_info_ibfk_2
        foreign key (salesman_id) references staff (id),
    constraint hand_info_ibfk_3
        foreign key (telemarketer_id) references staff (id)
)
    comment '经办信息' charset = utf8;

create index clerk_id
    on hand_info (clerk_id);

create index salesman_id
    on hand_info (salesman_id);

create index telemarketer_id
    on hand_info (telemarketer_id);

create index user_id
    on staff (user_id);

create table staff_personnel_status
(
    id                  bigint auto_increment
        primary key,
    staff_id            bigint null,
    personnel_status_id bigint null,
    constraint staff_personnel_status_ibfk_1
        foreign key (staff_id) references staff (id),
    constraint staff_personnel_status_ibfk_2
        foreign key (personnel_status_id) references personnel_status (id)
)
    charset = utf8;

create index personnel_status_id
    on staff_personnel_status (personnel_status_id);

create index staff_id
    on staff_personnel_status (staff_id);

create table staff_post
(
    id       bigint auto_increment
        primary key,
    staff_id bigint null,
    post_id  bigint null,
    constraint staff_post_ibfk_1
        foreign key (staff_id) references staff (id),
    constraint staff_post_ibfk_2
        foreign key (post_id) references post (id)
)
    comment '员工岗位表' charset = utf8;

create index post_id
    on staff_post (post_id);

create index staff_id
    on staff_post (staff_id);

create table user_role
(
    user_id   bigint(11)           not null,
    role_id   bigint(11)           not null,
    root_role tinyint(1) default 0 null comment '是否是最高权限的角色'
)
    charset = utf8;

create
    definer = icode@localhost procedure add_all_router(IN roleId bigint)
begin
    declare maxId bigint;
    declare i bigint;
    set i = 1;
    select max(id) into maxid from router;
    while i <= maxId
        do
            if exists(select 1 from router r where r.id = i) then
                insert into role_router(role_id, router_id) values (roleId, i);
            end if;
            set i = i + 1;
        end while;
end;

