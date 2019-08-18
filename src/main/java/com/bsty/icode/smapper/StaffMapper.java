package com.bsty.icode.smapper;

import com.bsty.icode.bean.Staff;
import com.bsty.icode.dto.StaffDTO;
import com.bsty.icode.reqparams.StaffParamsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    StaffDTO from(Staff staff);

    Staff from(StaffDTO dto);

    Staff from(StaffParamsDTO spdto);

    List<StaffDTO> from(List<Staff> staff);

    List<Staff> fromDto(List<StaffDTO> dtos);
}
