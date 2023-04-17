package com.ip.boxic.domain.model.country;

import com.ip.boxic.dtos.country.CountryDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Country")
@Table(name = "country")
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    public Country() {}

    public Country(String code) {
        this.code = code.toUpperCase();
    }

    public Country(CountryDTO countryDTO) {
        this.code = countryDTO.code();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
