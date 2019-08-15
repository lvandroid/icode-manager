package com.bsty.icode;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

@Data
public class ListResultData<T> {
    private List<T> list;
    private int pageSize;
    private int pageNum;
    private long total;

    public void setPage(Page page) {
        if (page != null) {
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
        }
    }
}
