package com.sparta.dr.connectionmanager;

public enum Mode {
    XML("xml"),
    HTML("html");

    private String name;

    Mode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}



