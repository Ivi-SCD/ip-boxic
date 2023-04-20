package com.ip.boxic.controller;

import com.ip.boxic.domain.model.country.Country;
import com.ip.boxic.domain.model.repositories.CountryRepository;
import com.ip.boxic.dtos.country.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @MutationMapping
    public Country addCountry(@Argument CountryDTO countryDTO) {
        var country = new Country(countryDTO);
        return countryRepository.save(country);
    }

    @MutationMapping
    @Transactional
    public Country deleteCountry(Long id) {
        var country = countryRepository.getReferenceById(id);

        countryRepository.delete(country);

        return country;
    }

    @MutationMapping
    @Transactional
    public Country updateCountry(@Argument CountryDTO countryDTO) {
        return null;
    }

    @QueryMapping
    public Country findCountryById(@Argument Long id) {

        return countryRepository.getReferenceById(id);
    }

    @QueryMapping
    public Country findCountryByCode(@Argument String code) {
        return countryRepository.findByCode(code);
    }

    @QueryMapping
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }
}
