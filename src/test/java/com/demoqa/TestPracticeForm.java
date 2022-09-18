package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm() {
        String firstName = "Ann";
        String lastName = "Stone";
        String email = "ann-stone@gmail.com";
        String gender = "Female";
        String number = "8000000000";
        String monthOfBirth = "January";
        String yearOfBirth = "1995";
        String dayOfBirth = "12";
        String[] subject = {"Maths","English"};
        String[] hobby = {"Music","Sports"};
        String address = "Current address";
        String state = "NCR";
        String city = "Delhi";

        // Open Form
        open("/automation-practice-form");


        //$("#Katalon").clear();

        // Fill First name
        $("#firstName").setValue(firstName);

        // Fill Last name
        $("#lastName").setValue(lastName);

        // Fill Email
        $("#userEmail").setValue(email);

        // Fill gender
        $(byText(gender)).click();

        // Fill Number
        $("#userNumber").setValue(number);

        // Fill Date of Birth
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__year-select").selectOptionContainingText(yearOfBirth);
        $(byText(dayOfBirth)).click();

        // Fill Subject
        for (int j=0; j<subject.length; j++) {
            $("#subjectsInput").setValue(subject[j]).pressEnter();
        }

        // Fill Hobby
        for (int i=0; i<hobby.length; i++) {
            $(byText(hobby[i])).click();
        }

        // Add picture
        $("#uploadPicture").uploadFile(new File("/Users/admin/Pictures/raccoon.jpeg"));
        //$("#uploadPicture").setValue("/Users/admin/Pictures/raccoon.jpeg");

        // Fill Current address
        $("#currentAddress").setValue(address);

        // Choose state
        $("#react-select-3-input").setValue(state).pressEnter();

        // Choose city
        $("#react-select-4-input").setValue(city).pressEnter().pressEnter();

        //Click Submit
        $("#submit").doubleClick();

        // Assertions
        $(".table-responsive").shouldHave(Condition.text(firstName+" "+lastName));
        $(".table-responsive").shouldHave(Condition.text(email));
        $(".table-responsive").shouldHave(Condition.text(gender));
        $(".table-responsive").shouldHave(Condition.text(number));
        $(".table-responsive").shouldHave(Condition.text(dayOfBirth+" "+monthOfBirth+","+yearOfBirth));
        for(int i=0; i< subject.length; i++) {
            $(".table-responsive").shouldHave(Condition.text(subject[i]));
        }
        for(int j=0; j< subject.length; j++) {
            $(".table-responsive").shouldHave(Condition.text(hobby[j]));
        }
        $(".table-responsive").shouldHave(Condition.text("raccoon.jpeg"));
        $(".table-responsive").shouldHave(Condition.text(address));
        $(".table-responsive").shouldHave(Condition.text(state+" "+city));

    }

}
