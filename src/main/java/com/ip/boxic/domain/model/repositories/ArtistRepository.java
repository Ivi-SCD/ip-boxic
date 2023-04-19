package com.ip.boxic.domain.model.repositories;

import com.ip.boxic.domain.model.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(String name);

    @Query("SELECT a FROM Artist a INNER JOIN Country c ON a.country.id = c.id WHERE c.code = :countryCode")
    List<Artist> findArtistsByCountryCode(@Param("countryCode") String countryCode);
}
