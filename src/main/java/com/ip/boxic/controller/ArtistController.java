package com.ip.boxic.controller;

import com.ip.boxic.domain.model.artist.Artist;
import com.ip.boxic.domain.repositories.ArtistRepository;
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
    private ArtistRepository artistRepository;

    @MutationMapping
    public ArtistDTO addArtist(@Argument ArtistDTO artistDTO) {
        var artist = new Artist(artistDTO);

        artistRepository.save(artist);

        return artistDTO;
    }

    @MutationMapping
    @Transactional
    public ArtistDTO deleteArtistById(@Argument Long id) {
        var artist = artistRepository.getReferenceById(id);

        artistRepository.delete(artist);

        return new ArtistDTO(artist);
    }

    @MutationMapping
    @Transactional
    public ArtistDTO updateArtist(@Argument ArtistDTO artistDTO) {
        var artist = artistRepository.findByName(artistDTO.name());

        var artistResponse = artist.updateInfo(artistDTO);

        return new ArtistDTO(artistResponse);
    }

    @QueryMapping
    public ArtistDTO findArtistByName(@Argument String name) {
        var artist = artistRepository.findByName(name);

        return new ArtistDTO(artist);
    }

    @QueryMapping
    public List<ArtistDTO> findArtistsByCountryCode(@Argument String code) {
        List<Artist> artists = artistRepository.findArtistsByCountryCode(code);

        return artists.stream().map(ArtistDTO::new).toList();
    }

    @QueryMapping
    public List<ArtistDTO> findAllArtists() {
        return artistRepository.findAll().stream().map(ArtistDTO::new).toList();
    }
}
