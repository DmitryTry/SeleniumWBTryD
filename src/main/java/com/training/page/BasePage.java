package com.training.page;

import com.training.driver.Driver;
import com.training.helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    protected Waiter wait;

    public BasePage() {
        driver = Driver.getDriver();
        wait = new Waiter(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public WebElement loginButton(){
        return driver.findElement(By.xpath("//button[@autocomplete='off']"));
    }

    public WebElement userMenu(){
        return driver.findElement(By.xpath("//span[@class='user-account__name']/following-sibling::div"));
    }

    public WebElement logoutButton(){
        return driver.findElement(By.xpath("//a[contains(@class, 'item_action_exit')]"));
    }

    public WebElement loginField(){
        return driver.findElement(By.id("passp-field-login"));
    }

    public WebElement passwordField(){
        return driver.findElement(By.id("passp-field-passwd"));
    }

    public WebElement signInButton(){
        return driver.findElement(By.id("passp:sign-in"));
    }

    public final static By MESSAGE_BOX = By.xpath("//div[@data-key='box=left-box']");

    public final static String INITIAL_URL = "https://mail.yandex.com/";

}
