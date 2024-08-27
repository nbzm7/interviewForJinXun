package com.cxh.interview.entity;

import com.cxh.interview.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;

    public static final int NO_PAGE_FLAG = -1;
    public static final int MAX_SIZE = 9999;
    /**
     * 当前页面数据量
     */

    private Integer pageSize = 10;
    /**
     * 当前页码
     */
    private Integer pageNum = 1;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;

    public void setPageSize(int pageSize) {
        if (pageSize >MAX_SIZE){
            throw new BusinessException(41000,"分页查询单页数据不能超过"+MAX_SIZE);
        }
        this.pageSize = pageSize;
    }
}
