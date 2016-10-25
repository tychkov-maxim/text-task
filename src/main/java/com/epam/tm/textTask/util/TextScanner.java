package com.epam.tm.textTask.util;

import com.epam.tm.textTask.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;


public class TextScanner {

    public static final Logger log = LoggerFactory.getLogger(TextScanner.class);
    private static String FILENAME = "123.txt";

    public String readFile(){

        String text = "";
        try
        {
            byte[] b = Files.readAllBytes(new File(FILENAME).toPath());
            text = new String(b);

        } catch (IOException e) {
            log.error("Can't read file",e);
        }

        return text;
    }

}
