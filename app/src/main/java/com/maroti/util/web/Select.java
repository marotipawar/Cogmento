package com.maroti.util.web;

import org.openqa.selenium.WebElement;


import java.util.List;

/*
 * @Author : Maroti Pawar
 * */
public interface Select {

    default org.openqa.selenium.support.ui.Select getOptionByText(WebElement element, String text) {
        return optionByText(element, text);
    }

    default org.openqa.selenium.support.ui.Select getOptionByValue(WebElement element, String value) {
        return optionByValue(element, value);
    }

    default org.openqa.selenium.support.ui.Select getOptionByIndex(WebElement element, int index) {
        return optionByIndex(element, index);
    }

    default List<WebElement> getOptionsList(WebElement element) {
        return optionList(element);
    }


    default String selectOptionText(org.openqa.selenium.support.ui.Select select, String value) {
        return optionText(select, value);
    }


    public static List<WebElement> optionList(WebElement element) {
        return new org.openqa.selenium.support.ui.Select(element).getOptions();
    }

    public static org.openqa.selenium.support.ui.Select optionByText(WebElement element, String text) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
        select.selectByVisibleText(text);
        return select;
    }

    public static org.openqa.selenium.support.ui.Select optionByValue(WebElement element, String value) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
        select.selectByValue(value);
        return select;
    }

    public static org.openqa.selenium.support.ui.Select optionByIndex(WebElement element, int index) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
        select.selectByIndex(index);
        return select;
    }

    public static String optionText(org.openqa.selenium.support.ui.Select select, String text) {
        return select.getFirstSelectedOption().getText();
    }


}
