package com.epam.tm.textTask.entity;

public class Letter extends Symbol {

    private Letter(char value) {
        super(value);
    }

    public static Letter of(char sym){
        if (CharacterCache.cache[sym] == null)
            CharacterCache.cache[sym] = new Letter(sym);

        return CharacterCache.cache[sym];
    }

    private static class CharacterCache {
        private CharacterCache(){}
        static final Letter[] cache = new Letter[Character.MAX_VALUE];
    }
}
