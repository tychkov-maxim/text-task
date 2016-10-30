package com.epam.tm.textTask;
import com.epam.tm.textTask.entity.Text;
import com.epam.tm.textTask.entity.TextComponent;
import com.epam.tm.textTask.entity.UnitText;
import com.epam.tm.textTask.parser.RegExpParser;
import com.epam.tm.textTask.util.TextScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        TextScanner textScanner = new TextScanner();
        RegExpParser parser = new RegExpParser();

        Text text = parser.parseText(textScanner.readFile());




    }

}
