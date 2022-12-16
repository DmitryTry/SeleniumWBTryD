package com.issoft.training.selenium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.issoft.training.settings.TestBase;
import com.issoft.training.helpers.Employee;

import java.util.ArrayList;
import java.util.List;

import static com.issoft.training.helpers.ByVariables.*;

public class TableSortSearchTest extends TestBase {

    @DisplayName("Select for Age>60 and Salary<199999 - Test")
    @ParameterizedTest
    @CsvSource({"60, 199999"})
    public void tableSortSearchTest(int targetAge, int targetSalary) {
        driver.get(testProperties.getProperty("seleniumeasy.search-url"));
        Select dropdown = new Select(driver.findElement(LIST_LENGTH));
        dropdown.selectByValue("10");
        List<Employee> workers = getEmployeesByCondition(targetAge, targetSalary);
        workers.forEach(System.out::println);
    }

    private List<Employee> getEmployeesByCondition(int minAge, int maxSalary) {
        List<Employee> employees = new ArrayList<>();
        boolean enabled = true;
        while (enabled) {
            WebElement nextBtn = driver.findElement(NEXT_BTN);
            collectEmployeesByCondition(minAge, maxSalary, employees);
            if (!driver.findElement(NEXT_BTN).getAttribute("class").contains("disabled")) {
                nextBtn.click();
            } else {
                enabled = false;
            }
        }
        return employees;
    }

    public void collectEmployeesByCondition(int minAge, int maxSalary, List<Employee> employees) {
    List<WebElement> rows = driver.findElements(TAB_ROW);
        for (WebElement element : rows) {
            int age = Integer.parseInt(element.findElement(By.xpath("td[4]")).getText());
            int salary = Integer.parseInt(element.findElement(By.xpath("td[6]")).getAttribute("data-order"));
            if (age > minAge && salary <= maxSalary) {
                String name = element.findElement(By.xpath("td[1]")).getAttribute("data-search");
                String position = element.findElement(By.xpath("td[2]")).getText();
                String office = element.findElement(By.xpath("td[3]")).getText();
                employees.add(new Employee(name, position, office));
            }
        }
    }
}
