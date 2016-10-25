package com.epam.tm.textTask.util;

import com.epam.tm.textTask.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExpParser implements Parser{

    private static final Logger log = LoggerFactory.getLogger(RegExpParser.class);

    private static final String PARAGRAPHS_SPLITTER = "\\v";
    private static final String SENTENCES_SPLITTER = "[.,!,?]";
    private static final String PARTSENTENCES_SPLITTER = "\\h|[!,?,.]";

    public RegExpParser() {
    }

    @Override
    public Text parseText(String text) {
        Text parsedText = new Text();
        List<String> linesOfParagraphs = split(PARAGRAPHS_SPLITTER,text);

        for (String paragraph : linesOfParagraphs) {
            log.debug("Paragraph: {}", paragraph);
            Paragraph p = parseParagraph(paragraph);
            p.addUnit(getLastSymbolWhiteSpace(paragraph));
            parsedText.addUnit(p);
        }
        return  parsedText;
    }

    private WhiteSpace getLastSymbolWhiteSpace(String line){
        return new WhiteSpace(line.charAt(line.length()-1));
    }

    private Paragraph parseParagraph(String linePar){
        Paragraph paragraph = new Paragraph();
        List<String> linesOfSentences = split(SENTENCES_SPLITTER,linePar);

        for (String sentence : linesOfSentences) {
            log.debug("Sentence: {}",sentence);
            paragraph.addUnit(parseSentence(sentence));
        }

        return paragraph;
    }

    private Sentence parseSentence(String lineSentence){
        Sentence sentence = new Sentence();
        List<String> linesOfWords = split(PARTSENTENCES_SPLITTER, lineSentence);

        for (String s : linesOfWords) {
            log.debug("Word: {}",s);
            sentence.addUnit(parseWord(s.substring(0,s.length()-1)));
            sentence.addUnit(getLastSymbolAsPunctuationMark(s));
        }

        return sentence;
    }

    private PunctuationMark getLastSymbolAsPunctuationMark(String line){
        return new PunctuationMark(line.charAt(line.length()-1));
    }

    private Word parseWord(String lineWord){
        Word word = new Word();

        for (int i = 0; i < lineWord.length(); i++) {
            log.debug("Letter: {}",lineWord.charAt(i));
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
