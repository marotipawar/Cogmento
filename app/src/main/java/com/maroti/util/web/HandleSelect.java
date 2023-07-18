package com.maroti.util.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

/*
 * @Author : Maroti Pawar
 * */
public interface HandleSelect {

    default Select selectOptionByText(WebElement element, String text) {
        return selectByText(element, text);
    }

    default Select selectOptionByValue(WebElement element, String value) {
        return selectByValue(element, value);
    }

    default Select selectOptionByIndex(WebElement element, int index) {
        return selectByIndex(element, index);
    }

    default List<WebElement> getAllSelectOptions(WebElement element) {
        return getSelectOptions(element);
    }

    default String getSelectTextByVisibleText(WebElement element, String text) {
        return getSelectedOptionTextByVisibleText(element, text);
    }

    default String getSelectedTextByValue(WebElement element, String value) {
        return getSelectedOptionTextByValue(element, value);
    }

    default String getSelectedTextByIndex(WebElement element, int index) {
        return getSelectedOptionTextByIndex(element, index);
    }


    public static List<WebElement> getSelectOptions(WebElement element) {
        return new Select(element).getOptions();
    }

    public static Select selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        return select;
    }

    public static Select selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
        return select;
    }

    public static Select selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
        return select;
    }

    public static String getSelectedOptionTextByVisibleText(WebElement element, String text) {
        return selectByText(element, text).getFirstSelectedOption().getText();
    }

    public static String getSelectedOptionTextByValue(WebElement element, String value) {
        return selectByValue(element, value).getFirstSelectedOption().getText();
    }

    public static String getSelectedOptionTextByIndex(WebElement element, int index) {
        return selectByIndex(element, index).getFirstSelectedOption().getText();
    }


}
