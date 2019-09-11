package com.bsty.icode;

public class ResponseData<T> {
    private T data;
    private int errCode;
    private String errMsg;
    private long total;

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

    public void setSuccess(T data) {
        setSuccess();
        this.data = data;
    }

    public void setSuccess(T data, long total) {
        this.data = data;
        this.total = total;
    }

    public static ResponseData newInstance() {
        return new ResponseData();
    }

    public static <K> ResponseData successInstance(K k) {
        ResponseData success = new ResponseData();
        success.setSuccess();
        success.setData(k);
        return success;
    }

    public static <K> ResponseData errorInstance(K k) {
        ResponseData error = new ResponseData();
        error.setError();
        error.setData(k);
        return error;
    }

    public static ResponseData errMsgInstance(String msg) {
        ResponseData error = ResponseData.newInstance();
        error.setError(msg);
        return error;
    }

    public void setError() {
        errCode = CODE_ERROR;
        errMsg = MSG_ERROR;
    }

    public void setError(String msg) {
        errCode = CODE_ERROR;
        errMsg = msg;
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

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                ", errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
