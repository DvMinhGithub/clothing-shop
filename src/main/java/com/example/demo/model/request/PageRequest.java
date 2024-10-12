package com.example.demo.model.request;

import lombok.Data;

@Data
public class PageRequest {
    private int limit = 20;

    private int page = 1;

    private int offset;

    public PageRequest(int limit, int page) {
        this.limit = limit;
        this.page = page;
        this.offset = (page - 1) * limit;
    }
}
