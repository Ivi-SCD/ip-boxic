package com.ip.boxic.controller;

import com.ip.boxic.domain.model.artist.Artist;
import com.ip.boxic.domain.model.repositories.ArtistRepository;
import com.ip.boxic.domain.model.repositories.CountryRepository;
import com.ip.boxic.dtos.artist.ArtistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private CountryRepository countryRepository;

    @MutationMapping
    public Artist addArtist(@Argument ArtistDTO artistDTO) {
        var artist = new Artist(artistDTO);
        var country = countryRepository.getReferenceById(artistDTO.country_id());
        artist.setCountry(country);
        artistRepository.save(artist);
        return artist;
    }

    @QueryMapping
    public List<Artist> findAllArtists() {
        return artistRepository.findAll();
    }
}
