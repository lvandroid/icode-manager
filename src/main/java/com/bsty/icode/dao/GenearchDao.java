package com.bsty.icode.dao;

import com.bsty.icode.bean.Genearch;
import com.bsty.icode.dto.GenearchDTO;
import com.bsty.icode.reqparams.GenearchParamDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenearchDao {
    void insert(Genearch genearch);

    int selectCount(String id);

    List<GenearchDTO> selectByParams(GenearchParamDTO param);
}
