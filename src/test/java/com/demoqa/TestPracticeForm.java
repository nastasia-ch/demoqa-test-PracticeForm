package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {

    @BeforeAll
    static void setUp() {
        //Configuration.browser = "safari";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm() {
        String firstName = "Ann";
        String lastName = "Stone";
        String email = "ann-stone@gmail.com";
        String gender = "Female";
        String number = "XXXXXXXXXXX";
        String monthOfBirth = "January";
        String yearOfBirth = "1995";
        String dayOfBirth = "12";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();

        // Fill Date of Birth
        $("#userNumber").setValue(number);
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__year-select").selectOptionContainingText(yearOfBirth);
        $(byText(dayOfBirth)).click();

        //String dayIn = "react-datepicker__day react-datepicker__day--0" + day;
        //$("dayIn").selectOptionContainingText(day);
        //$("#dateOfBirthInput").setValue("08 Sep 2022");
        //$("#react-select-3-input").setValue(state).pressEnter();
        //$("#react-select-4-input").setValue(city).pressEnter();









    }

}
