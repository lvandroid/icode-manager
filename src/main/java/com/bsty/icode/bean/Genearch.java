package com.bsty.icode.bean;

import com.bsty.icode.dto.GenearchDTO;
import lombok.Data;

/**
 * 家长
 */
@Data
public class Genearch {
    private String id; //11位手机号码
    private String name;
    private int sex;
    private String profession; //职业
    private String phone;
    private String wechat;
    private String qq;
    private String email;
    private String mark;

    public Genearch() {
    }

    public Genearch(GenearchDTO dto) {
        if (dto != null) {
            this.id = dto.getId();
            this.name = dto.getName();
            this.sex = dto.getSex();
            this.profession = dto.getProfession();
            this.phone = dto.getPhone();
            this.wechat = dto.getWechat();
            this.qq = dto.getQq();
            this.email = dto.getEmail();
            this.mark = dto.getMark();
        }
    }
}
