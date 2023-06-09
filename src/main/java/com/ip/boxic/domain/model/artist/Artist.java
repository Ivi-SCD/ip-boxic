package com.ip.boxic.domain.model.artist;

import com.ip.boxic.domain.model.country.Country;
import com.ip.boxic.domain.model.music.Music;
import com.ip.boxic.dtos.artist.ArtistDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Artist")
@Table(name = "artist")
public class Artist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany
    private List<Music> musics = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private ArtistType artistType;

    public Artist() {}

    public Artist(String name, String birthdate, Country country, ArtistType artistType) {
        this.name = name;
        this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.country = country;
        this.artistType = artistType;
    }

    public Artist(ArtistDTO artistDTO) {
        this.name = artistDTO.name();
        this.birthdate = LocalDate.parse(artistDTO.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.artistType = artistDTO.artistType();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ArtistType getArtistType() {
        return artistType;
    }

    public void setArtistType(ArtistType artistType) {
        this.artistType = artistType;
    }


    public void addMusic(Music music) {
        this.musics.add(music);
    }

    public void removeMusic(int i) {
        this.musics.remove(i);
    }

    public void removeMusic(Music music) {
        this.musics.remove(music);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Artist updateInfo(ArtistDTO artistDTO) {
        this.name = artistDTO.name();
        this.birthdate = LocalDate.parse(artistDTO.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.artistType = artistDTO.artistType();
        this.country = artistDTO.country();
        return this;
    }
}
