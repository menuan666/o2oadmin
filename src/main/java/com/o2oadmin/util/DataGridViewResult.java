package com.o2oadmin.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataGridViewResult {
    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data;
    /**
     * 封装数据表格
     * @param count
     * @param data
     */
    public DataGridViewResult(Long count, Object data) {
        this.count = count;
        this.data = data;
    }
}