package com.epam.tm.textTask.parser;

import com.epam.tm.textTask.entity.Text;
import com.epam.tm.textTask.entity.TextComponent;
import com.epam.tm.textTask.entity.TextComposite;
import com.epam.tm.textTask.entity.UnitText;
import com.epam.tm.textTask.parser.Exceptions.ParserException;

public interface Parser {

   Text parseText(String text) throws ParserException;
   <T extends TextComposite> T parseTo(String source, Class<T> clazz) throws Exception;

}