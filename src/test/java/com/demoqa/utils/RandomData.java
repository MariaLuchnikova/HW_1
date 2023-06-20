package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class RandomData {
    Faker faker = new Faker();
    public Date dateBirth = faker.date().birthday();
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayBirth = new SimpleDateFormat("d").format(dateBirth),
            fullDateBirth = new SimpleDateFormat("dd MMMM,y").format(dateBirth),
            monthBirth = new SimpleDateFormat("MMMM").format(dateBirth),
            yearBirth = new SimpleDateFormat("y").format(dateBirth),
            picture = "AutoTesting.png",
            address = faker.address().fullAddress();
    Map<String, String> valueStateCity = Map.ofEntries(
            Map.entry("Delhi", "NCR"),
            Map.entry("Gurgaon", "NCR"),
            Map.entry("Agra", "Uttar Pradesh"),
            Map.entry("Lucknow", "Uttar Pradesh"),
            Map.entry("Merrut", "Uttar Pradesh"),
            Map.entry("Karnal", "Haryana"),
            Map.entry("Panipat", "Haryana"),
            Map.entry("Jaipur", "Rajasthan"),
            Map.entry("Jaiselmer", "Rajasthan")
    );

    Object[] arrayCity = valueStateCity.keySet().toArray();
    public String valueCity = arrayCity[new Random().nextInt(arrayCity.length)].toString();

    public String valueState = valueStateCity.get(valueCity);

    public String optionGenderUser() {
        String[] typeGender = {"Male", "Female", "Other"};
        int n = new Random().nextInt(typeGender.length);
        return typeGender[n];
    }

    public String choiceSubject() {
        String[] kindSubject = {"Math", "Accounting", "Arts", "Social", "Biology", "Physics", "Chemistry", "Civics"};
        return faker.options().option(kindSubject);
    }

    public String selectionHobby() {
        String[] kindHobby = {"Sports", "Reading", "Music"};
        return faker.options().option(kindHobby);
    }
}
