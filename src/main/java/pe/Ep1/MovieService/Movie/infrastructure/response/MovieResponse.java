package pe.Ep1.MovieService.Movie.infrastructure.response;

import lombok.Builder;
import lombok.Data;
import pe.Ep1.MovieService.Movie.domain.entity.Movie;

import java.util.List;

@Builder
@Data
public class MovieResponse {
    private List<Movie> movieList;
    private BasicResponse basicResponse;
}
