package com.epam.tm.textTask.entity;

import java.util.Iterator;
import java.util.List;

public class Symbol implements TextLeaf {
    private char value;

    public Symbol(){}

    public Symbol(char value) {
        this.value = value;
    }

    public String getString() {
        return "" + value;
    }
    public void getAllUnits(List<TextComponent> unitText, Class clazz) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public void getIterator(List<Iterator> iterators, Class clazz) {
        throw new UnsupportedOperationException("");
    }
}
