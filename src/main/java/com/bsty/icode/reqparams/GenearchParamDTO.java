package com.bsty.icode.reqparams;

import com.bsty.icode.dto.ParamDTO;
import lombok.Data;

@Data
public class GenearchParamDTO extends ParamDTO {
    private String id; //11位手机号码
    private String name;
    private int sex;
    private String profession; //职业
    private String phone;
    private String wechat;
    private String qq;
    private String email;
    private String mark;

    @Override
    public void initSortMap() throws Exception {
        super.initSortMap();
    }
}
