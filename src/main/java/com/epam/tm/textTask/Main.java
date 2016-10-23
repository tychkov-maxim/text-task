package com.epam.tm.textTask;
import com.epam.tm.textTask.entity.Letter;
import com.epam.tm.textTask.entity.Sentence;
import com.epam.tm.textTask.entity.Textable;
import com.epam.tm.textTask.entity.Word;
import com.epam.tm.textTask.util.TextScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Sentence sentence = new Sentence();
        TextScanner textScanner = new TextScanner();
        try {
            sentence = textScanner.getSentence();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }

        System.out.println(sentence.getAllWords().get(1).getValue());

    }
}
