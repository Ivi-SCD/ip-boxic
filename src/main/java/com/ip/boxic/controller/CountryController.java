package com.ip.boxic.controller;

import com.ip.boxic.domain.model.country.Country;
import com.ip.boxic.domain.model.repositories.CountryRepository;
import com.ip.boxic.dtos.country.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @MutationMapping
    public Country addCountry(@Argument CountryDTO countryDTO) {
        var country = new Country(countryDTO);
        countryRepository.save(country);
        return country;
    }

    @QueryMapping
    public Country findCountryById(@Argument Long id) {
        var country = countryRepository.getReferenceById(id);
        return country;
    }

    @QueryMapping
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

}
