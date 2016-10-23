package com.epam.tm.textTask.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class UnitText implements Textable {
    private List<Textable> units;

    public UnitText() {
        units = new ArrayList<>();
    }

    public void addUnit(Textable unit) {
        units.add(unit);
    }

    public void removeUnit(Textable unit) {
        units.remove(unit);
    }

    @Override
    public String getValue() {
        String res = new String();
        for (Textable unit : units) {
            res += unit.getValue();
        }
        return res;
    }
//

    @Override
    public void getAllUnits(List<Textable> unitsText,Class clazz) {
        for (Textable iter : units) {
            if (clazz.isInstance(iter)) {
                unitsText.add(iter);
            }else {
                if (!Letter.class.isInstance(iter))
                    iter.getAllUnits(unitsText, clazz);
            }
        }


    }

    public List<Textable> getAllLetters(){
        List<Textable> list = new ArrayList<>();
        getAllUnits(list,Letter.class);
        return  list;
    }

    public List<Textable> getAllWords(){
        List<Textable> list = new ArrayList<>();
        getAllUnits(list,Word.class);
        return  list;
    }

    public List<Textable> getAllSentences(){
        List<Textable> list = new ArrayList<>();
        getAllUnits(list,Sentence.class);
        return  list;
    }
}
