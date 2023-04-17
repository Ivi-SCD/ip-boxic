package com.ip.boxic.dtos.artist;

import com.ip.boxic.domain.model.artist.ArtistType;

public record ArtistDTO(
        String name,
        String birthdate,
        Long country_id,
        ArtistType artistType
) {
}
