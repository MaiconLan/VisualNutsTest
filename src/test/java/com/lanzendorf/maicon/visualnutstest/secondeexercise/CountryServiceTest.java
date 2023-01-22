package com.lanzendorf.maicon.visualnutstest.secondeexercise;

import com.lanzendorf.maicon.visualnutstest.secondeexercise.model.Country;
import com.lanzendorf.maicon.visualnutstest.secondeexercise.repository.CountryRepository;
import com.lanzendorf.maicon.visualnutstest.secondeexercise.service.CountryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CountryServiceTest {


    @InjectMocks
    private CountryService service;

    @Mock
    private CountryRepository repository;

    @Test
    void shouldGetMostCommonLanguage() {
        final var countries = mockCountryList();

        when(repository.findAll()).thenReturn(countries);

        final var language = service.getMostCommonLanguage().orElse("");

        assertEquals("de", language);
    }

    @Test
    void shouldGetNumberOfOfficialLanguages() {
        final var countries = mockCountryList();

        when(repository.findAll()).thenReturn(countries);

        final var numberOfOfficialLanguages = service.getNumberOfOfficialLanguages();

        assertEquals(9, numberOfOfficialLanguages);
    }

    @Test
    void shouldGetNumberOfCountries() {
        final var countries = mockCountryList();

        when(repository.findAll()).thenReturn(countries);

        final var numberOfCountries = service.getNumberOfCountries();

        assertEquals(2, numberOfCountries);
    }

    @Test
    void shouldGetCountryWithHighestOfficialLanguages() {
        final var countries = mockCountryList();

        when(repository.findAll()).thenReturn(countries);

        final var country = service.getCountryWithHighestOfficialLanguages().orElse("");

        assertEquals("BE", country);
    }

    @Test
    void shouldGetCountryWithMostOfficialLanguagesByLanguageSpoken() {
        final var countries = mockCountryList();

        when(repository.findAll()).thenReturn(countries);

        final var country = service.getCountryWithMostOfficialLanguagesByLanguageSpoken("de").orElse("");

        assertEquals("BE", country);
    }

    private List<Country> mockCountryList() {
        final var brLanguages = Arrays.asList("pt", "en", "es", "de");
        final var beLanguages = Arrays.asList("ar", "nl", "fr", "de", "it", "tr");

        return Arrays.asList(
                mockCountry("BR", brLanguages),
                mockCountry("BE", beLanguages)
        );
    }

    private Country mockCountry(String country, List<String> languages) {
        return Country.builder()
                .country(country)
                .languages(languages)
                .build();
    }
}
