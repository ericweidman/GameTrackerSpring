package com.theironyard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ericweidman on 3/8/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByUser(User user);
    List<Game> findByUserAndGenre(User user, String genre);
    List<Game> findByUserAndGenreAndReleaseYear(User user, String genre, int releaseYear);

    Game findFirstByGenre(String genre);
    int countByGenre(String genre);
    List<Game> findByGenreOrderByNameAsc(String genre);

    @Query("SELECT g FROM Game g WHERE g.platform LIKE ?1%")
    List<Game> findByAprroximatePlatform(String platform);
}
