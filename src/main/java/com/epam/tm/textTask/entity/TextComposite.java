package com.epam.tm.textTask.entity;


public interface TextComposite extends TextComponent{
    void addUnit(TextComponent textComponent);
    void removeUnit(TextComponent textComponent);

}
