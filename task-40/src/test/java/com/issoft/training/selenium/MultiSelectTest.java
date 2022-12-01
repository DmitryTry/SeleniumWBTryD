package com.issoft.training.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.issoft.training.settings.TestSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.issoft.training.helpers.ByVariables.MULTISELECT_LIST;

public class MultiSelectTest extends TestSettings {

    @DisplayName("Select for three options - Test")
    @Test
    public void selectOptionsTest() {
        driver.get(testProperties.getProperty("seleniumeasy.dropdown-url"));
        WebElement list = driver.findElement(MULTISELECT_LIST);
        Select multiSelectList = new Select(list);
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Florida", "Ohio", "Texas"));
        for (String state : expectedOptions) {
            multiSelectList.selectByVisibleText(state);
        }
        List<String> selectedOptions = multiSelectList.getAllSelectedOptions().stream()
                .map(WebElement::getText).collect(Collectors.toList());

        Assertions.assertEquals(expectedOptions, selectedOptions, "Options not found!");
    }
}
