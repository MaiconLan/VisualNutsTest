package com.lanzendorf.maicon.visualnutstest.secondeexercise;

import com.lanzendorf.maicon.visualnutstest.secondeexercise.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class SecondExercise {

    private final CountryService service;

    public void execute() {
        alert("---------------------Exercise 2---------------------");

        print("Number of countries: " + service.getNumberOfCountries());
        print("Country with the most official languages, where they officially speak German: "
                + service.getCountryWithMostOfficialLanguagesByLanguageSpoken("de").orElse("None"));

        print("Number of all official languages: " + service.getNumberOfOfficialLanguages());
        print("Country with the highest number of languages: " + service.getCountryWithHighestOfficialLanguages().orElse("None"));
        print("Most common language of all countries: " + service.getMostCommonLanguage().orElse("None"));
    }

    private void print(String message) {
        log.info(message);
    }
    private void alert(String content) {
        log.warn(content);
    }

}
