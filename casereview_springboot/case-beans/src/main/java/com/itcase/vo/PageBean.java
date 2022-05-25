package com.itcase.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//封装查询到的数据(分页查询后) TODO:为什么要实现序列化
@Data
public class PageBean<T> implements Serializable {
    private List<T> rows;
    private Integer total;
}
