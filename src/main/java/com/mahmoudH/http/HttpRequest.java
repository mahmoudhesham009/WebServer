package com.mahmoudH.http;

public class HttpRequest {
    private HttpMassage httpMassage;
    private HttpHeader httpHeader;
    private HttpBody httpBody;


    public HttpMassage getHttpMassage() {
        return httpMassage;
    }

    public void setHttpMassage(HttpMassage httpMassage) {
        this.httpMassage = httpMassage;
    }

    public HttpHeader getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(HttpHeader httpHeader) {
        this.httpHeader = httpHeader;
    }

    public HttpBody getHttpBody() {
        return httpBody;
    }

    public void setHttpBody(HttpBody httpBody) {
        this.httpBody = httpBody;
    }
}
