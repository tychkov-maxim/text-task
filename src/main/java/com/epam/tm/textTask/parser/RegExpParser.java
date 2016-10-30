package com.epam.tm.textTask.parser;

import com.epam.tm.textTask.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExpParser implements Parser{

    private static final Logger log = LoggerFactory.getLogger(RegExpParser.class);

    private  Map<Class<? extends TextComponent>,Class<? extends  TextComponent>> complianceClasses;
    private  Map<Class<? extends  TextComponent>, String> complianceRegex;

    public RegExpParser() {
        complianceClasses = new HashMap<>();
        complianceClasses.put(Text.class,Paragraph.class);
        complianceClasses.put(Paragraph.class,Sentence.class);
        complianceClasses.put(Sentence.class,Word.class);
        complianceClasses.put(Word.class,Letter.class);

        complianceRegex = new HashMap<>();
        complianceRegex.put(Text.class,"\\n");
        complianceRegex.put(Paragraph.class,"");
        complianceRegex.put(Sentence.class,"");
        complianceRegex.put(Word.class,"");
        complianceRegex.put(Letter.class,"");
    }

    //TODO not need catch exception here
    @Override
    public Text parseText(String source) {
        try {
            return parseTo(source,Text.class);
        } catch (Exception e) {
            log.error("Error when try to parse", e);
        }

        return null;
    }

    //TODO My exception
    @Override
    public <T extends TextComponent> T parseTo(String source, Class<T> clazz) throws Exception {
        T inst;
        try {
             inst = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Exception("MyException");
        }

        List<String> parts = split(source,complianceRegex.get(clazz));
        for (String part : parts) {
            parseTo(part,complianceClasses.get(clazz));
        }


        return inst;
    }

    public List<String> split(String regExp, String line){
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
