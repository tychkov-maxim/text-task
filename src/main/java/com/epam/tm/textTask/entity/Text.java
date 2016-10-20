package com.epam.tm.textTask.entity;

import java.util.ArrayList;
import java.util.List;

public class Text extends UnitText {

    public List<Textable> getAllParagraphs(){
        List<Textable> list = new ArrayList<>();
        getAllUnits(list,Paragraph.class);
        return  list;
    }
}
