package com.mengya.security.core.response;

/**
 * 返回结果
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
public class ResponseEntity {
    /** 状态码 */
    private int code;

    /** 提示语 */
    private String msg;

    /** 返回数据 */
    private Object data;
    /** */
    private Object extra;

    public ResponseEntity() {
    }

    public ResponseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseEntity data(Object data) {
        this.data = data;
        return this;
    }

    public ResponseEntity extra(Object extra) {
        this.extra = extra;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
