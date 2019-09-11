package com.bsty.icode.smapper;

import com.bsty.icode.bean.CommunicateInfo;
import com.bsty.icode.bean.FollowInfo;
import com.bsty.icode.bean.HandInfo;
import com.bsty.icode.bean.Student;
import com.bsty.icode.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings(
            {
                    @Mapping(source = "student.id", target = "id"),
                    @Mapping(source = "student.createTime", target = "createTime"),
                    @Mapping(source = "student.updateTime", target = "updateTime"),
                    @Mapping(source = "communicateInfo.content", target = "communicateContent"),
                    @Mapping(source = "communicateInfo.revisitRemind", target = "revisitRemind"),
                    @Mapping(source = "followInfo.consultMethod", target = "consultMethod"),
                    @Mapping(source = "followInfo.intention", target = "intention"),
                    @Mapping(source = "followInfo.courses", target = "courseStr"),
                    @Mapping(source = "followInfo.status", target = "followStatus"),
                    @Mapping(source = "followInfo.keyword", target = "keyword"),
                    @Mapping(source = "handInfo.campus", target = "campus"),
                    @Mapping(source = "handInfo.channel", target = "channel"),
                    @Mapping(source = "handInfo.clerkId", target = "clerk"),
                    @Mapping(source = "handInfo.salesmanId", target = "salesman"),
                    @Mapping(source = "handInfo.telemarketerId", target = "telemarketer"),
            }
    )
    StudentDTO from(Student student, CommunicateInfo communicateInfo, FollowInfo followInfo, HandInfo handInfo);

    Student from(StudentDTO dto);

    List<Student> fromDto(List<StudentDTO> dtos);
}
