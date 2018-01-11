package com.mat.music.catalogue;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AlbumData {

    @Id
    @GeneratedValue
    private Long id;

    private String artist;

    private String album;

    private String year;

    private String artwork;

    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getYear() {
        return year;
    }

    public String getArtwork() {
        return artwork;
    }


}

