package com.epam.tm.textTask;
import com.epam.tm.textTask.entity.*;
import com.epam.tm.textTask.parser.Exceptions.ParserException;
import com.epam.tm.textTask.parser.RegExpParser;
import com.epam.tm.textTask.util.TextScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ParserException, FileNotFoundException {

        TextScanner textScanner = new TextScanner();
        RegExpParser parser = new RegExpParser();


        Text text = parser.parseText(textScanner.readFile());


        List<Iterator> asd = new ArrayList<>();
                text.getIterator(asd,Sentence.class);

        System.out.println(asd.getClass());
    }
}
