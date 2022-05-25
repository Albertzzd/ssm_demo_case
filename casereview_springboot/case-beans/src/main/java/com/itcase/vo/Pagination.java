package com.itcase.vo;

import lombok.Data;

@Data
//封装前端传输的数据
public class Pagination {
    private Integer currentPage;//当前页
    private Integer pageSize;//每页显示条数
    private String param;//搜索条件

}
