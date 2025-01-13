package com.example.demo.model;

import com.example.demo.model.request.PageRequest;
import lombok.Data;

import java.util.List;

@Data
public class CustomPageable<T> {
    private Integer totalPage;

    private Integer totalRecords;

    private Integer currentPage;

    private Integer pageSize;

    private List<T> data;

    public CustomPageable(List<T> data, Integer totalRecords, PageRequest pageRequest) {
        this.data = data;
        this.totalRecords = totalRecords;
        this.pageSize = pageRequest.getLimit();
        this.currentPage = pageRequest.getPage();
        this.totalPage = (int) Math.ceil((double) totalRecords / pageSize);
    }
}
