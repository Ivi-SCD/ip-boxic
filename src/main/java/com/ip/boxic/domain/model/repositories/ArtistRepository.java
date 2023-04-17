package com.ip.boxic.domain.model.repositories;

import com.ip.boxic.domain.model.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
