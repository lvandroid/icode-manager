package com.bsty.icode.service.impl;

import com.bsty.icode.bean.Genearch;
import com.bsty.icode.dao.GenearchDao;
import com.bsty.icode.dto.GenearchDTO;
import com.bsty.icode.reqparams.GenearchParamDTO;
import com.bsty.icode.service.GenearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenearchServiceImpl implements GenearchService {
    @Autowired
    private GenearchDao genearchDao;

    @Override
    public void addGenearch(Genearch genearch) throws Exception {
        if (genearch != null) {
            genearch.setId(genearch.getPhone());
            genearchDao.insert(genearch);
        }
    }

    @Override
    public boolean isExist(String id) throws Exception {
        if (genearchDao.selectCount(id) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<GenearchDTO> findByParams(GenearchParamDTO param) throws Exception {
        return genearchDao.selectByParams(param);
    }

}
