package com.pushpakumaracode;


public class MassageRequest {
    private String massage;

    public MassageRequest() {
    }

    @Override
    public String toString() {
        return "MassageRequest{" +
                "massage='" + massage + '\'' +
                '}';
    }

    public MassageRequest(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
