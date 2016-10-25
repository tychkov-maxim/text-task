package com.epam.tm.textTask.util;

import com.epam.tm.textTask.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExpParser implements Parser{

    public static final Logger log = LoggerFactory.getLogger(RegExpParser.class);

    private static final String PARAGRAPHS_SPLITTER = "\\n";
    private static final String SENTENCES_SPLITTER = "[.|!|?]";
    private static final String PARTSENTENCES_SPLITTER = "\\h|[!|?|.]";

    public RegExpParser() {
    }

    @Override
    public Text parseText(String text) {
        Text parsedText = new Text();
        List<String> paragraphs = split(PARAGRAPHS_SPLITTER,text);

        for (String paragraph : paragraphs) {
            log.debug("paragraph: {}", paragraph);
            parsedText.addUnit(parseParagraph(paragraph));
        }

        return  parsedText;
    }


    private Paragraph parseParagraph(String linePar){
        Paragraph paragraph = new Paragraph();
        List<String> sentences = split(SENTENCES_SPLITTER,linePar);

        for (String sentence : sentences) {
            log.debug("Sentence: {}",sentence);
            paragraph.addUnit(parseSentence(sentence));
        }

        return paragraph;
    }

    private Sentence parseSentence(String lineSentence){
        Sentence sentence = new Sentence();
        List<String> partsOfSentence = split(PARTSENTENCES_SPLITTER, lineSentence);

        for (String s : partsOfSentence) {
            log.debug("partOfSentence: {}",s);
            sentence.addUnit(parseWord(s));
        }

        return sentence;
    }

    private Word parseWord(String lineWord){
        Word word = new Word();

        for (int i = 0; i < lineWord.length(); i++) {
            log.debug("parseWord: {}",lineWord.charAt(i));
            word.addUnit(new Letter(lineWord.charAt(i)));
        }

        return word;
    }

    private List<String> split(String regExp, String line){
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(line);

        int val = 0;
        while (matcher.find()) {
            list.add(line.substring(val,matcher.end()));
            val = matcher.end();
        }
        return list;
    }

}
