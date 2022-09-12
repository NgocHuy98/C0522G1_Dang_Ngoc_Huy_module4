package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String result(String firstNumber, String secondNumber, String calculator) {
        try {
            double num1 = Double.parseDouble(firstNumber);
            double num2 = Double.parseDouble(secondNumber);

            switch (calculator) {
                case "addition":
                    return String.valueOf(num1 + num2);
                case "subtraction":
                    return String.valueOf(num1 - num2);
                case "multiplication":
                    return String.valueOf(num1 * num2);
                case "division":
                    if (num2 == 0) {
                        return "Not division by 0";
                    } else {
                        return String.valueOf(num1 / num2);
                    }
            }
        } catch (NumberFormatException e) {
            return "Please input number!";
        }
        return "";
    }
}
