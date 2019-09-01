package com.bsty.icode.dto;

import com.bsty.icode.bean.ClassName;
import com.bsty.icode.bean.HomeAddress;
import com.bsty.icode.bean.School;
import lombok.Data;

import java.util.List;

@Data
public class StudentSchoolDTO {
    List<School> schools;
    List<ClassName> classNames;
    List<HomeAddress> homeAddresses;
}
