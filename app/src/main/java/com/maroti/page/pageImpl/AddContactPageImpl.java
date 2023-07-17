package com.maroti.page.pageImpl;

import com.maroti.model.Contact;
import com.maroti.page.AddContactPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
/*
 * @Author : Maroti Pawar
 * */
public class AddContactPageImpl implements AddContactPage {

    @FindBy(xpath = "//a[@href='/contacts']")
    private WebElement moveContact;
    @FindBy(xpath = "//div[@id='main-nav']/div[3]/button")
    private WebElement btnContact;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@class='search']")
    private WebElement company;

    @FindBy(xpath = "//div[@class='selected item addition']")
    private WebElement selectCompany;

    @FindBy(xpath = "//button[@class='ui small fluid positive toggle button']")
    private WebElement access;
    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement clickAccess;
    @FindBy(xpath = "//div[@class='selected item']/span")
    private WebElement selectAccess;
    @FindBy(xpath = "(//input[@name='value'])[1]")
    private WebElement email;

    @FindBy(xpath = "(//div[@name='category'])[1]")
    private WebElement category;

    @FindBy(xpath = "//div[@name='category'][2]")
    private WebElement selectCategory;

    @FindBy(xpath = "(//div[@name='status'])[1]")
    private WebElement status;
    @FindBy(xpath = "//div[@name='status'][2]")
    private WebElement selectStatus;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement description;
    @FindBy(xpath = "//input[@name='address']")
    private WebElement street;
    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;
    @FindBy(xpath = "//input[@name='state']")
    private WebElement state;
    @FindBy(xpath = "//input[@name='zip']")
    private WebElement postCode;
    @FindBy(xpath = "(//input[@class='search'])[4]")
    private WebElement country;
    @FindBy(xpath = "(//div[@class='visible menu transition']/div/span)[99]")
    private WebElement countryIndia;
    @FindBy(xpath = "(//input[@name='value'])[3]")
    private WebElement phone;
    @FindBy(xpath = "//input[@name='department']")
    private WebElement department;
    @FindBy(xpath = "//input[@name='day']")
    private WebElement day;

    @FindBy(xpath = "//div[@name='month']")
    private WebElement month;
    @FindBy(xpath = "//div[@class='visible menu transition']/div/span")
    private List<WebElement> selectMonth;
    @FindBy(xpath = "//input[@name='year']")
    private WebElement year;
    @FindBy(xpath = "//button[@class='ui linkedin button']")
    private WebElement btnSubmit;

    private WebDriver driver;

    public AddContactPageImpl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void addContacts(Contact contact) throws InterruptedException {
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.moveToElement(moveContact).build().perform();
        btnContact.click();
        firstName.sendKeys(contact.getFirstName());
        lastName.sendKeys(contact.getLastName());
        company.sendKeys(contact.getCompany());
        selectCompany.click();
        email.sendKeys(contact.getEmail());
        category.click();
        selectCategory.click();
        status.click();
        selectStatus.click();
        description.sendKeys(contact.getDescription());
        street.sendKeys(contact.getStreet());
        city.sendKeys(contact.getCity());
        state.sendKeys(contact.getState());
        postCode.sendKeys(contact.getPostCode());
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", country);
        countryIndia.click();
        phone.sendKeys(contact.getPhone());
        department.sendKeys(contact.getDept());
        /*day.sendKeys(contact.getDay());
        month.click();
        selectMonth.forEach(mon -> {
            if (mon.getText().equals(contact.getMonth())) {
                mon.click();
            }
        });
        year.sendKeys(contact.getYear());*/
        btnSubmit.click();
    }
}
