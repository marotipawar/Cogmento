package com.maroti.serviceImpl;

import com.maroti.util.MyPropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class Login extends CongmentoServiceImpl {
    @FindBy(xpath = "//ul[@class='rd-navbar-nav']/a")
    private WebElement login;
    @FindBy(xpath = "(//div[@class='ui stacked segment']//input)[1]")
    private WebElement username;
    @FindBy(xpath = "(//div[@class='ui stacked segment']//input)[2]")
    private WebElement password;
    @FindBy(xpath = "//div[text()='Login']")
    private WebElement btnLogin;

    public Login(WebDriver driver) throws FileNotFoundException {
        super(driver);
        super.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Override
    public boolean login(String userName, String pass) {
        if(login.isEnabled() && login.isDisplayed()){
            login.click();
            username.sendKeys(userName);
            password.sendKeys(pass);
            btnLogin.click();
            return true;
        }
        return false;
    }
}
