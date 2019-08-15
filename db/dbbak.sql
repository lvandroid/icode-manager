create table if not exists course_type
(
    id   bigint auto_increment comment '课程类型id',
    name varchar(128) null comment '课程名称',
    type int          null comment '课程类型',
    constraint id
        unique (id)
)
    comment '课程类型' charset = utf8;

alter table course_type
    add constraint `PRIMARY`
        primary key (id);

create table if not exists genearch
(
    id         varchar(11)  not null,
    name       varchar(255) not null,
    sex        int          not null,
    profession varchar(255) null,
    phone      varchar(255) not null,
    wechat     varchar(255) null,
    qq         varchar(255) null,
    email      varchar(255) null,
    mark       varchar(255) null,
    constraint id
        unique (id)
)
    charset = utf8;

alter table genearch
    add constraint `PRIMARY`
        primary key (id);

create table if not exists permission
(
    id          bigint(11) auto_increment primary key,
    url         varchar(255) not null,
    name        varchar(255) not null,
    description varchar(255) null,
    pid         bigint(11)   not null
)
    charset = utf8;

create table if not exists role
(
    id   bigint(11) auto_increment
        primary key,
    name varchar(255) not null
)
    charset = utf8;

create table if not exists role_permission
(
    role_id       bigint(11) not null,
    permission_id bigint(11) not null
)
    charset = utf8;

create table if not exists student
(
    name        varchar(255)         not null,
    sex         int                  not null,
    grade       varchar(16)          null,
    genearch_id varchar(11)          null,
    mark        varchar(255)         null,
    phone       varchar(11)          not null,
    enable      tinyint(1) default 0 null comment '是否激活',
    refer_id    varchar(11)          null comment '推荐人ID',
    id          varchar(11)          not null,
    constraint student_id_uindex
        unique (id),
    constraint student_ibfk_1
        foreign key (refer_id) references genearch (id)
)
    charset = utf8;

create index genearch_id
    on student (genearch_id);

create index referId
    on student (refer_id);

alter table student
    add constraint `PRIMARY`
        primary key (id);

create table if not exists student_genearch
(
    student_id  varchar(11)  not null,
    genearch_id varchar(11)  not null,
    relation    varchar(128) null comment '学员家长之间的关系',
    constraint student_genearch_ibfk_1
        foreign key (student_id) references student (id),
    constraint student_genearch_ibfk_2
        foreign key (genearch_id) references genearch (id)
)
    charset = utf8;

create index genearch_id
    on student_genearch (genearch_id);

create index student_id
    on student_genearch (student_id);

create table if not exists teacher
(
    id         bigint(11) auto_increment,
    name       varchar(255) null,
    sex        int          not null,
    entry_date bigint       null,
    mark       varchar(128) null,
    phone      varchar(11)  not null,
    constraint id
        unique (id),
    constraint phone
        unique (phone)
)
    charset = utf8;

alter table teacher
    add constraint `PRIMARY`
        primary key (id);

create table if not exists course
(
    id              bigint auto_increment,
    name            varchar(255)         not null comment '课程名称',
    start_date      bigint               null,
    end_date        bigint               null,
    teacher_id      bigint               null,
    course_sum      int                  not null comment '课时数',
    total_price     double               not null comment '课程原总价',
    unit_price      double               not null comment '课程原单价',
    act_course_sum  int                  null comment '活动课时数',
    act_total_price double               null comment '活动总价',
    act_unit_price  double               null comment '活动单价',
    act_name        varchar(255)         null comment '活动名称',
    class_ref       varchar(16)          null,
    mark            varchar(255)         null comment '备注',
    course_type_id  bigint               null,
    hasAct          tinyint(1) default 0 null,
    constraint id
        unique (id),
    constraint course_ibfk_1
        foreign key (teacher_id) references teacher (id),
    constraint course_ibfk_2
        foreign key (course_type_id) references course_type (id)
)
    charset = utf8;

create index course_type_id
    on course (course_type_id);

create index teacher_id
    on course (teacher_id);

alter table course
    add constraint `PRIMARY`
        primary key (id);

create table if not exists student_course
(
    student_id    varchar(11) not null,
    course_id     bigint(11)  null comment '课程ID',
    course_remain double      null comment '剩余课程数',
    remain_price  double      null comment '剩余余额',
    unitPrice     double      null comment '单价',
    updateDate    bigint      null comment '上次更新时间',
    enable        tinyint(1)  null comment '是否可以被销课',
    constraint student_course_ibfk_2
        foreign key (course_id) references course (id),
    constraint student_course_ibfk_3
        foreign key (student_id) references student (id)
)
    charset = utf8;

create index course_id
    on student_course (course_id);

create index student_id
    on student_course (student_id);

create table if not exists teacher_course_type
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

create table if not exists user
(
    id       bigint(11) auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    constraint id
        unique (id)
)
    charset = utf8;

alter table user
    add constraint `PRIMARY`
        primary key (id);

create table if not exists user_role
(
    user_id bigint(11) not null,
    role_id bigint(11) not null
)
    charset = utf8;

