package com.bsty.icode;

import lombok.Data;

import java.util.List;

@Data
public class ListResultData<T> {
    private List<T> list;
    private int pageSize;
    private int pageNum;
    private long total;
}
