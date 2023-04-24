package com.example.chatbot.Shared.Response.Model;

public class Response<T, S> {

    public String message;
    public Integer status;
    public T data;
    public S error;

    public Response() {
    }

    public void ResponseError(String message, Integer status, S error) {
        this.message = message;
        this.status = status;
        this.error = error;
    }

    public void ResponseSuccess(String message, Integer status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public S getError() {
        return error;
    }

    public void setError(S error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
