package com.lanzendorf.maicon.visualnutstest.secondeexercise.service;

import com.lanzendorf.maicon.visualnutstest.secondeexercise.model.Country;
import com.lanzendorf.maicon.visualnutstest.secondeexercise.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository repository;

    private List<Country> findAll() {
        return repository.findAll();
    }

    public Integer getNumberOfCountries() {
        return findAll().size();
    }

    public Optional<String> getCountryWithMostOfficialLanguagesByLanguageSpoken(String language) {
        return findAll()
                .stream()
                .filter(country -> country.getLanguages().contains(language))
                .max(Comparator.comparing(country -> country.getLanguages().size()))
                .map(Country::getCountry);
    }

    public Integer getNumberOfOfficialLanguages() {
        return findAll()
                .stream()
                .flatMap(c -> c.getLanguages().stream())
                .collect(Collectors.toSet()).size();
    }

    public Optional<String> getCountryWithHighestOfficialLanguages() {
        return findAll()
                .stream()
                .max(Comparator.comparing(country -> country.getLanguages().size()))
                .map(Country::getCountry);
    }

    public Optional<String> getMostCommonLanguage() {
        return findAll()
                .stream()
                .flatMap(c -> c.getLanguages().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
