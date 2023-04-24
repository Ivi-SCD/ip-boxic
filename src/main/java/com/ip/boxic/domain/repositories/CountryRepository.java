package com.ip.boxic.domain.repositories;

import com.ip.boxic.domain.model.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCode(String code);
}
