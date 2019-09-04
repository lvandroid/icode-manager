package com.bsty.icode.dto;

import com.bsty.icode.bean.*;
import lombok.Data;

import java.util.List;

@Data
public class StudentSchoolDTO {
    List<School> schools;
    List<Grade> grades;
    List<ClassName> classNames;
    List<HomeAddress> homeAddresses;
    List<Genearch> genearches;
    List<CourseType> courses;
    List<Campus> campuses;
    List<Channel> channels;
    List<ConsultType> conMethods;
    List<Intention> intentions;
    List<Keyword> keywords;
    List<FollowStatus> followStatuses;
}
