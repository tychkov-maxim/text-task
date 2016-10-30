package com.epam.tm.textTask.entity;

import com.epam.tm.textTask.parser.RegExpParser;
import com.epam.tm.textTask.util.TextScanner;
import org.junit.Assert;
import org.junit.Test;

public class TextTest{
    @Test
    public void CheckSourceStringAndParsedString() throws Exception {

        TextScanner textScanner = new TextScanner();
        RegExpParser parser = new RegExpParser();

        String source = textScanner.readFile();
        Text text = parser.parseText(source);

        Assert.assertEquals(source,text.getString());
    }
}