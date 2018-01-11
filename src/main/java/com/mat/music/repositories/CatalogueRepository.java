package com.mat.music.repositories;

import com.mat.music.catalogue.MusicCatalogue;
import org.springframework.data.repository.CrudRepository;

public interface CatalogueRepository extends CrudRepository<MusicCatalogue, Long> {

}
