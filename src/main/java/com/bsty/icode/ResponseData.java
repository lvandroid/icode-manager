package com.bsty.icode;

public class ResponseData<T> {
    private T data;
    private int errCode;
    private String errMsg;

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR = -1;
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_ERROR = "error";

    public boolean isSuccess() {
        if (errCode == CODE_SUCCESS) {
            return true;
        } else {
            return false;
        }
    }

    public void setSuccess() {
        errCode = CODE_SUCCESS;
        errMsg = MSG_SUCCESS;
    }
    public static ResponseData newInstance(){
        return new ResponseData();
    }

    public void setError() {
        errCode = CODE_ERROR;
        errMsg = MSG_ERROR;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
