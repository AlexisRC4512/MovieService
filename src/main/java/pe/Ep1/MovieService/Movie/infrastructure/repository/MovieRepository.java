package pe.Ep1.MovieService.Movie.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.Ep1.MovieService.Movie.domain.entity.Movie;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    public Movie findByTitle(String title);

}
