package com.bsty.icode.smapper;

import com.bsty.icode.bean.Student;
import com.bsty.icode.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO from(Student student);

    Student from(StudentDTO dto);

    List<StudentDTO> from(List<Student> students);

    List<Student> fromDto(List<StudentDTO> dtos);
}
