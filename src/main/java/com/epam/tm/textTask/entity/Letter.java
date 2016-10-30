package com.epam.tm.textTask.entity;

import java.util.List;

public class Letter implements TextLeaf {
    private char value;


    public Letter() {
    }

    public Letter(char value) {
        this.value = value;
    }

    public String getString() {
        return "" + value;
    }

    public void getAllUnits(List<TextComponent> unitText, Class clazz) {
        throw new UnsupportedOperationException("");
    }
    public void setValue(char value) {
        this.value = value;
    }
}
