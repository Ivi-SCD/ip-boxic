package com.ip.boxic.dtos.artist;

import com.ip.boxic.domain.model.artist.Artist;
import com.ip.boxic.domain.model.artist.ArtistType;
import com.ip.boxic.domain.model.country.Country;

public record ArtistDTO(
        String name,
        String birthdate,
        Country country,
        ArtistType artistType
) {
    public ArtistDTO(Artist artist) {
        this(artist.getName(), artist.getBirthdate().toString(), artist.getCountry(), artist.getArtistType());
    }
}
