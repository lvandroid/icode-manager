package com.bsty.icode.smapper;

import com.bsty.icode.bean.Course;
import com.bsty.icode.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO from(Course course);

    Course from(CourseDTO dto);

    List<CourseDTO> from(List<Course> courses);

    List<Course> fromDto(List<CourseDTO> dtos);
}
