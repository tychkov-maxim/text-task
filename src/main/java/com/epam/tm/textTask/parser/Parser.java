package com.epam.tm.textTask.parser;

import com.epam.tm.textTask.entity.Text;
import com.epam.tm.textTask.entity.TextComponent;
import com.epam.tm.textTask.entity.UnitText;

public interface Parser {

   Text parseText(String text);
   <T extends TextComponent> T parseTo(String source, Class<T> clazz) throws Exception;

}