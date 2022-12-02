package com.issoft.training.selenium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.issoft.training.settings.TestSettings;
import com.issoft.training.helpers.WorkerTable;

import java.util.ArrayList;
import java.util.List;

public class TableSortSearchTest extends TestSettings {


    @DisplayName("Select for Age>60 and Salary<199999 - Test")
    @ParameterizedTest
    @CsvSource({"60, 199999"})
    public void tableSortSearchTest(int targetAge, int targetSalary) {
        driver.get(testProperties.getProperty("seleniumeasy.search-url"));
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
        dropdown.selectByValue("10");
        List<WorkerTable> workers = sortedList(targetAge, targetSalary);
        workers.forEach(System.out::println);
    }

    private List<WorkerTable> sortedList(int targetAge, int targetSalary) {
        List<WorkerTable> employees = new ArrayList<>();
        List<WebElement> pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/child::a"));

        for (WebElement ignored : pages) {
            List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
            WebElement buttonNext = driver.findElement(By.xpath("//a[@id='example_next']"));

            for (WebElement element : rows) {
                String name = element.findElement(By.xpath("td[1]")).getText();
                String position = element.findElement(By.xpath("td[2]")).getText();
                String office = element.findElement(By.xpath("td[3]")).getText();
                String age = element.findElement(By.xpath("td[4]")).getText();
                String salary = element.findElement(By.xpath("td[6]")).getText()
                        .substring(1).replace("/y", "").replace(",", "");

                int convertedAge = Integer.parseInt(age);
                int convertedSalary = Integer.parseInt(salary);

                if (convertedAge > targetAge && convertedSalary <= targetSalary) {
                    employees.add(new WorkerTable(name, position, office));
                }
            }
            buttonNext.click();
        }
        return employees;
    }
}
