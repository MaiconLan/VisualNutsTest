package com.lanzendorf.maicon.visualnutstest.secondeexercise.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanzendorf.maicon.visualnutstest.secondeexercise.exception.DataNotFoundException;
import com.lanzendorf.maicon.visualnutstest.secondeexercise.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CountryRepository {

    private final ObjectMapper objectMapper;

    private Resource loadCountries() {
        return new ClassPathResource("data/second-exercise/countries.json");
    }

    public List<Country> findAll() {
        final var resource = loadCountries();

        if (!resource.exists())
            throw new DataNotFoundException();

        try {
            return objectMapper.readValue(resource.getFile(), new TypeReference<>() { });
        } catch (IOException e) {
            throw new DataNotFoundException(e);
        }
    }

}
