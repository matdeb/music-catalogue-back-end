package com.mat.music.catalogue;

import lombok.*;

import javax.persistence.*;
import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MusicCatalogue {

    @Id
    @GeneratedValue
    private Long id;

    @Singular("albumData")
    @OneToMany(targetEntity = AlbumData.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "music_catalogue")
    private List<AlbumData> albumData;

    public Long getId() {
        return id;
    }

    public List<AlbumData> getAlbumData() {
        return albumData;
    }
}
