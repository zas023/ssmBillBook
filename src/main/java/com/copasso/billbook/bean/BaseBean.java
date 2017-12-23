package com.copasso.billbook.bean;
import java.io.Serializable;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * status : 100
     * message : 处理成功！
     */

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(){
        status=100;
        message="处理成功！";
    }
    public void setFail(){
        status=200;
        message="处理失败！";
    }

    public void success(String msg){
        status=100;
        message=msg;
    }
    public void fail(String msg){
        status=200;
        message=msg;
    }
}