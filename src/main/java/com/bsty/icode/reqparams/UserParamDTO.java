package com.bsty.icode.reqparams;

import com.bsty.icode.dto.ParamDTO;
import lombok.Data;

@Data
public class UserParamDTO extends ParamDTO {
    private Long id;

    private String username;

    private String password;

    @Override
    public void initSortMap() throws Exception {
        super.initSortMap();
    }
}
