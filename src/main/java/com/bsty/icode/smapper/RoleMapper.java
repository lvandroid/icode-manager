package com.bsty.icode.smapper;

import com.bsty.icode.bean.Role;
import com.bsty.icode.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role from(RoleDTO dto);

    RoleDTO from(Role role);

    List<Role> fromDto(List<RoleDTO> dtos);

    List<RoleDTO> from(List<Role> roles);
}
