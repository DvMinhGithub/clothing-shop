package com.example.demo.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApi<T> {
    private String message;

    private T data;

    public ResponseApi(String message) {
        this.message = message;
    }

    public ResponseApi(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
