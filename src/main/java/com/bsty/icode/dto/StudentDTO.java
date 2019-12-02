package com.bsty.icode.dto;

import com.bsty.icode.bean.CommunicateInfo;
import com.bsty.icode.bean.CourseType;
import com.bsty.icode.bean.FollowInfo;
import com.bsty.icode.bean.HandInfo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StudentDTO {
    private long id;
    private String name;
    private String phone;
    private String genearch;
    private String phoneSec;
    private String genearchSec;
    private String phoneOther;
    private String genearchOther;
    private String sex;
    private String idCard;
    private String wechat;
    private long birthday;
    private String school;
    private String grade;
    private String className;
    private String homeAddress;
    private String referPhone;
    private String mark;
    private long entryTime; //录入时间
    private long createTime;
    private long updateTime;
    private long enable;
    private String consultMethod; //咨询方式
    private String intention;//意向度
//    private List<String> courses;
    private String courseStr;
    private String followStatus;//跟进状态
    private String keyword;//关键词
    private long revisitRemind;//回访提醒
    private String communicateContent;//沟通内容
    private String campus;//校区
    private String channel;//渠道
    private long clerk;//采单员id
    private long salesman;//销售员id
    private long telemarketer;//电话销售员id
    private long staffId; //员工id

    public CommunicateInfo getCommunicate(long id) {
        if ((consultMethod == null || consultMethod.isEmpty()) && (intention == null || intention.isEmpty()) &&
                (followStatus == null || followStatus.isEmpty())
                && (keyword == null || keyword.isEmpty())) {
            return null;
        }
        return new CommunicateInfo(
                id, staffId,communicateContent, revisitRemind, new Date().getTime()
        );
    }

    public HandInfo getHandInfo(long id) {
        if ((campus == null || campus.isEmpty()) && (channel == null || channel.isEmpty())
                && clerk <= 0 && salesman <= 0 && telemarketer <= 0) {
            return null;
        }
        return new HandInfo(id, campus, new Date().getTime(), channel, clerk, salesman, telemarketer);
    }

    public FollowInfo getFollowInfo(long id) {
        if ((consultMethod == null || consultMethod.isEmpty()) && (intention == null || intention.isEmpty()) && (courseStr == null || courseStr.isEmpty())
                && (followStatus == null || followStatus.isEmpty()) && (keyword == null || keyword.isEmpty())) {
            return null;
        }
        return new FollowInfo(id, consultMethod, intention, courseStr, followStatus, keyword, new Date().getTime());
    }
}
