package com.issoft.training.selenium;

import com.issoft.training.settings.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.issoft.training.helpers.ByVariables.MULTISELECT_LIST;

public class MultiSelectTest extends TestBase {

    @DisplayName("Select for three options - Test")
    @Test
    public void selectOptionsTest() {
        driver.get(testProperties.getProperty("seleniumeasy.dropdown-url"));
        WebElement list = driver.findElement(MULTISELECT_LIST);
        Select multiSelectList = new Select(list);
        List<String> expectedOptions = new Random().ints(3, 0, multiSelectList.getOptions().size()).boxed()
                .map(i -> multiSelectList.getOptions().get(i).getText()).collect(Collectors.toList());
        for (String state : expectedOptions) {
            multiSelectList.selectByVisibleText(state);
        }
        List<String> selectedOptions = multiSelectList.getAllSelectedOptions().stream()
                .map(WebElement::getText).collect(Collectors.toList());
        Collections.sort(expectedOptions);
        Collections.sort(selectedOptions);

        Assertions.assertEquals(expectedOptions, selectedOptions, "Options not found!");
    }
}
