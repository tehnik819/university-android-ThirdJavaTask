package com.noveogroup.data;

public class StringData implements Data {
    private String name;

    public StringData(String data) {
        this.name = data;
    }

    @Override
    public String getName() {
        return name;
    }
}
