package com.sparta.dr.connectionmanager;

public enum Units {
    STANDARD,
    METRIC,
    IMPERIAL;

    private String name;

    Units(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
