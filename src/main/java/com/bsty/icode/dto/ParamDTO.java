package com.bsty.icode.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ParamDTO {
    protected int pageNum;
    protected int pageSize;
    protected String orderKey;
    public static final String DESC_TYPE = "desc"; //降序
    public static final String ASC_TYPE = "asc"; //升序
    protected String orderType;
    protected Map<String, String> sortMap;
    protected static final String COMMA = ",";

    public void initSortMap() throws Exception {
        sortMap = new HashMap<>();
        String[] keys = getOrderKey().split(COMMA);
        String[] types = getOrderType().split(COMMA);
        for (int i = 0; i < keys.length; i++) {
            sortMap.put(keys[i], types[i]);
        }
    }

}
