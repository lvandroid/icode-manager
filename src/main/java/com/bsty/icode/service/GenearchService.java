package com.bsty.icode.service;

import com.bsty.icode.bean.Genearch;
import com.bsty.icode.dto.GenearchDTO;
import com.bsty.icode.reqparams.GenearchParamDTO;

import java.util.List;

public interface GenearchService {
    void addGenearch(Genearch genearch) throws Exception;

    boolean isExist(String id) throws Exception;//是否已经存在

    List<GenearchDTO> findByParams(GenearchParamDTO param) throws Exception;
}
