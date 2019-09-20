#查询咨询列表
select s.*,
       ci.content                                                         as communicate_content,
       ci.revisit_remind,
       fi.consult_method,
       fi.intention,
       fi.courses                                                         as course_str,
       fi.status                                                          as follow_status,
       fi.keyword,
       hi.campus,
       hi.channel,
       (select staff.name from staff where staff.id = hi.clerk_id)        as clerk,
       (select staff.name from staff where staff.id = hi.salesman_id)     as salesman,
       (select staff.name from staff where staff.id = hi.telemarketer_id) as telemarketer
from student s
         left join communicate_info ci on s.id = ci.student_id
         left join follow_info fi on s.id = fi.student_id
         left join hand_info hi on s.id = hi.student_id
order by s.id desc;
