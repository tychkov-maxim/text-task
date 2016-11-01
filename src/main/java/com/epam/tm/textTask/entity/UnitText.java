package com.epam.tm.textTask.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class UnitText implements TextComposite{
    private List<TextComponent> units;

    public UnitText() {
        units = new ArrayList<>();
    }

    public void addUnit(TextComponent unit) {
        units.add(unit);
    }

    public void removeUnit(TextComponent unit) {
        units.remove(unit);
    }

    public String getString() {
        String res = "";
        for (TextComponent unit : units) {
            res += unit.getString();
        }
        return res;
    }

    public void getAllUnits(List<TextComponent> unitsText, Class clazz) {
        for (TextComponent iter : units) {
            if (clazz.isInstance(iter)) {
                unitsText.add(iter);
            }else {
                if (!Symbol.class.isInstance(iter))
                    iter.getAllUnits(unitsText, clazz);
            }
        }
    }

    public List<TextComponent> getAllLetters(){
        List<TextComponent> list = new ArrayList<>();
        getAllUnits(list,Symbol.class);
        return  list;
    }

    public List<TextComponent> getAllWords(){
        List<TextComponent> list = new ArrayList<>();
        getAllUnits(list,Word.class);
        return  list;
    }

    public List<TextComponent> getAllSentences(){
        List<TextComponent> list = new ArrayList<>();
        getAllUnits(list,Sentence.class);
        return  list;
    }
}
