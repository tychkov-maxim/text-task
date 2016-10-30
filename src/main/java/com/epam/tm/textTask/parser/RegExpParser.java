package com.epam.tm.textTask.parser;

import com.epam.tm.textTask.entity.*;
import com.epam.tm.textTask.parser.Exceptions.ParserException;
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

    private Map<Class<? extends TextComposite>,Class<? extends  TextComposite>> complianceClasses;
    private  Map<Class<? extends  TextComposite>, String> complianceRegex;

    public RegExpParser() {
        complianceClasses = new HashMap<>();
        complianceClasses.put(Text.class,Paragraph.class);
        complianceClasses.put(Paragraph.class,Sentence.class);
        complianceClasses.put(Sentence.class,Word.class);

        complianceRegex = new HashMap<>();
        complianceRegex.put(Text.class,"\\v+");
        complianceRegex.put(Paragraph.class,"[.|!|?]\\v+{0,}");
        complianceRegex.put(Sentence.class,"\\h|[!|?|.]\\v+{0,}");
        complianceRegex.put(Word.class,".\\v{0,}");
    }

    @Override
    public Text parseText(String source) throws ParserException {
            return parseTo(source,Text.class);
    }

    @Override
    public <T extends TextComposite> T parseTo(String source, Class<T> clazz) throws ParserException {
        T inst;

        try {
             inst = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Error when trying to create new instance {}",clazz);
            throw new ParserException("Error when trying to create new instance",e);
        }


        List<String> parts = split(complianceRegex.get(clazz), source);
        log.debug("{} splitted for {} by Regex: {}",clazz, parts, complianceRegex.get(clazz));
        for (String part : parts) {

            if (inst instanceof Word) {
                parseWord((Word)inst,part);
            }else {
                log.debug("Work with: {} and parse: {}", complianceClasses.get(clazz), part);
                inst.addUnit(parseTo(part, complianceClasses.get(clazz)));
            }

        }
        return inst;
    }

    private void parseWord(Word word,String lineWord) {

        for (int i = 0; i < lineWord.length(); i++) {
            log.debug("Letter: {}", lineWord.charAt(i));
            word.addUnit(new Letter(lineWord.charAt(i)));
        }
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

    private String findWithRegex(String regExp, String line){
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(line);

        String res;
        if (matcher.find()) {
            res = matcher.group();
        }
        else
            res = null;

        return res;

    }


}
