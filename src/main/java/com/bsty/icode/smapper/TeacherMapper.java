package com.bsty.icode.smapper;

import com.bsty.icode.bean.Teacher;
import com.bsty.icode.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO from(Teacher teacher);

    Teacher from(TeacherDTO dto);

    List<TeacherDTO> from(List<Teacher> teachers);

    List<Teacher> fromDto(List<TeacherDTO> dtos);
}
