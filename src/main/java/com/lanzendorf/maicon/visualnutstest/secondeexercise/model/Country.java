package com.lanzendorf.maicon.visualnutstest.secondeexercise.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(includeFieldNames = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {

    @ToString.Include
    private String country;

    private List<String> languages;

}
