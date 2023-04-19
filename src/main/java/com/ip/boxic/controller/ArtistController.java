package com.ip.boxic.controller;

import com.ip.boxic.domain.model.artist.Artist;
import com.ip.boxic.domain.model.repositories.ArtistRepository;
import com.ip.boxic.domain.model.repositories.CountryRepository;
import com.ip.boxic.dtos.artist.ArtistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @MutationMapping
    public Artist addArtist(@Argument ArtistDTO artistDTO) {
        var artist = new Artist(artistDTO);

        return artistRepository.save(artist);
    }

    @MutationMapping
    @Transactional
    public Artist deleteArtistById(@Argument Long id) {
        var artist = artistRepository.getReferenceById(id);

        artistRepository.delete(artist);

        return artist;
    }

    @MutationMapping
    @Transactional
    public Artist updateArtist(@Argument ArtistDTO artistDTO) {
        var country = countryRepository.getReferenceById(artistDTO.country_id());
        var artist = artistRepository.findByName(artistDTO.name());

        artist.updateInfo(artistDTO);
        artist.setCountry(country);

        return artist;
    }

    @QueryMapping
    public Artist findArtistByName(@Argument String name) {
        return artistRepository.findByName(name);
    }

    @QueryMapping
    public List<Artist> findArtistsByCountryCode(@Argument String code) {
        return artistRepository.findArtistsByCountryCode(code);
    }

    @QueryMapping
    public List<Artist> findAllArtists() {
        return artistRepository.findAll();
    }
}
