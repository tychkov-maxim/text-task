package com.epam.tm.textTask;
import com.epam.tm.textTask.entity.Letter;
import com.epam.tm.textTask.entity.Sentence;
import com.epam.tm.textTask.entity.Textable;
import com.epam.tm.textTask.entity.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {



        Letter h = new Letter('H');
        Letter e = new Letter('e');
        Letter l = new Letter('l');
        Letter o = new Letter('o');
        Letter w = new Letter('W');
        Letter r = new Letter('r');
        Letter d = new Letter('d');

        Word word = new Word();
        word.addUnit(h);
        word.addUnit(e);
        word.addUnit(l);
        word.addUnit(l);
        word.addUnit(o);
        word.addUnit(w);
        word.addUnit(o);
        word.addUnit(r);
        word.addUnit(l);
        word.addUnit(d);


        Word word1 = new Word();
        word1.addUnit(h);
        word1.addUnit(e);
        word1.addUnit(l);
        word1.addUnit(l);
        word1.addUnit(o);
        word1.addUnit(w);
        word1.addUnit(o);
        word1.addUnit(r);
        word1.addUnit(l);
        word1.addUnit(d);

        Sentence sentence = new Sentence();
        sentence.addUnit(word);
        sentence.addUnit(word1);



        List<Textable> list = new ArrayList<>();

        System.out.println(sentence.getAllLetters().get(12).getValue());

    }
}
