package com.epam.tm.textTask.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class UnitText implements TextComposite, Iterable<TextComposite> {
    private List<TextComponent> units;
    private UnitTextIterator iterator;
    @Override
    public Iterator<TextComposite> iterator() {
        return this.iterator;
    }

    public UnitText() {
        units = new ArrayList<>();
        this.iterator = new UnitTextIterator();
    }

    public void addUnit(TextComponent unit) {
        units.add(unit);
    }

    public void removeUnit(TextComponent unit) {
        units.remove(unit);
    }

    //FIXME remake with stringbuilder
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

    public void getIterator(List<Iterator> iterators, Class clazz) {
        Iterator<TextComponent> iter = units.iterator();
        TextComponent value = null;
        while (iter.hasNext()) {
            value = iter.next();
            if (clazz.isInstance(value)) {
                iterators.add(iter);
            } else {
                if (!Symbol.class.isInstance(value)) {
                    value.getIterator(iterators, clazz);
                }
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

    private class UnitTextIterator implements Iterator<TextComposite>{

        private int i;

        public UnitTextIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return units.size() > i;
        }

        @Override
        public TextComposite next() {
            return (TextComposite)units.get(i++);
        }
    }

}

