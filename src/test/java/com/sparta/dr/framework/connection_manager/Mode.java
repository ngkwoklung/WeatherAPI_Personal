package com.sparta.dr.framework.connection_manager;

public enum Mode {
    XML("xml"),
    HTML("html");

    private String value;

    Mode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}