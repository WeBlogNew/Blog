package com.threeFarmer.core;

import java.io.Serializable;

/**
 * 响应结果信息
 */
public class ResponseModel<T> implements Serializable{

    //-2参数错误，-1操作失败，0操作成功，1成功刷新当前页，2成功并跳转到url，3成功并刷新iframe的父界面
    private int code;

    private String message;

    private String url;

    private T data;

    public ResponseModel(int code) {
        this.code = code;
        if(code == -2){
            setMessage("参数错误");
        }else if(code == -1){
            setMessage("操作失败");
        }else if(code == 0){
            setMessage("操作成功");
        }
    }

    public ResponseModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseModel(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseModel(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.url = url;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
