package com.bsty.icode.dto;

import com.bsty.icode.bean.HomeAddress;
import lombok.Data;

import java.util.List;

@Data
public class StudentSchoolDTO {
    List<String> schools;
    List<String> classNames;
    List<String> homeAddresses;
}
