package com.ip.boxic.domain.model.album;

import com.ip.boxic.domain.model.artist.Artist;
import com.ip.boxic.domain.model.music.GenreType;
import com.ip.boxic.domain.model.music.Music;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Album")
@Table(name = "album")
public class Album {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @OneToMany
    private List<Music> musics = new ArrayList<>();

    @Column(name = "release_year")
    private Integer releaseYear;
    @Enumerated(EnumType.STRING)
    private GenreType genre;

    public Album() {
    }

    public Album(String title, Artist artist, Integer releaseYear, GenreType genre) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Music> getMusics() {
        return musics;
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
