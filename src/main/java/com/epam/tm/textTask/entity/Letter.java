package com.epam.tm.textTask.entity;

import java.util.List;

public class Letter implements Textable {
    private char value;


    public Letter() {
    }

    public Letter(char value) {
        this.value = value;
    }

    public String getValue() {
        return "" + value;
    }

    @Override
    public void getAllUnits(List<Textable> unitText, Class clazz) {
        throw new UnsupportedOperationException("");
    }
    public void setValue(char value) {
        this.value = value;
    }
}
