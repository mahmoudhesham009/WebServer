package com.mahmoudH.http;

public class HttpBody {
    enum Method{
        GET,POST
    }

    private Method method;
    private int code;


    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
