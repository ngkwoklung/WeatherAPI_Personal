package com.sparta.dr.framework.connection_manager;

public enum Units {
    STANDARD("standard"),
    METRIC("metric"),
    IMPERIAL("imperial");

    private String value;

    Units(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
