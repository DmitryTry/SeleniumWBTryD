package com.issoft.training.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private final String name;
    private final String position;
    private final String office;

}
