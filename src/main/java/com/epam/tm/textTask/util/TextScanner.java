package com.epam.tm.textTask.util;

import com.epam.tm.textTask.entity.*;
import java.io.*;


public class TextScanner {
    private static String FILENAME = "123.txt";

    public Sentence getSentence() throws IOException {
        File file = new File(FILENAME);
        FileReader r = new FileReader(file.getAbsoluteFile());

        Sentence sentence = new Sentence();

        try {
            int s;
            Word word = new Word();
            String s1;
            while((s = r.read()) != -1) {
                s1 = new String(Character.toChars(s));

                if (s1.equals("!")) {
                    sentence.addUnit(word);
                    sentence.addUnit(new Letter(s1));
                    word = new Word();
                }

                if (s1.equals(" ")) {
                    sentence.addUnit(word);
                    sentence.addUnit(new Letter(s1));
                    word = new Word();
                }else{
                    word.addUnit(new Letter(s1));
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return sentence;
    }
}
