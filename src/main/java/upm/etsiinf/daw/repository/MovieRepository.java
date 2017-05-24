package upm.etsiinf.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upm.etsiinf.daw.model.Movie;

import java.util.List;

/**
 * Created by S on 24/05/2017.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
    Movie findByTitle(String title);
}
