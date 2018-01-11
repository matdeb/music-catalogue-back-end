package com.mat.music.catalogue;

import com.mat.music.repositories.CatalogueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.mat.music.repositories")
public class CatalogueApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogueApplication.class);

    @Autowired
    CatalogueRepository catalogueRepository;

    public static void main(String[] args) {

        SpringApplication.run(CatalogueApplication.class, args);

    }

    @Bean
    public CommandLineRunner demo() {
        return (e) -> {
            List<AlbumData> albums = new ArrayList<>();

            albums.add(AlbumData.builder().album("Greatest Hits").artist("Mat").year("1991").artwork("http://www.trendzified.net/wp-content/uploads/2017/01/face-reveals-your-health1.jpg").build());
            albums.add(AlbumData.builder().album("The Comeback Kid").artist("Mat").year("1993").artwork("http://i872.photobucket.com/albums/ab289/awkwardsound/awkwardsound080/samhunt_zpskjjkvswd.jpg").build());
            MusicCatalogue mc = MusicCatalogue.builder().albumData(albums).build();
            LOGGER.info("SAVING MC: {}",mc);
            catalogueRepository.save(mc);

            Iterable<MusicCatalogue> mcs = catalogueRepository.findAll();
            LOGGER.info("Returned MCs: {}", mcs);
        };
    }
}
