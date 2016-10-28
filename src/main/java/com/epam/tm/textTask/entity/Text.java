package com.epam.tm.textTask.entity;

import java.util.ArrayList;
import java.util.List;

public class Text extends UnitText {

    public List<TextComponent> getAllParagraphs(){
        List<TextComponent> list = new ArrayList<>();
        getAllUnits(list,Paragraph.class);
        return  list;
    }
}