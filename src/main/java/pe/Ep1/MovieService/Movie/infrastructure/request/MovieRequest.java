package pe.Ep1.MovieService.Movie.infrastructure.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieRequest {
    private String title;
    private String Year;
    private String Genre;
    private String Director;
    private String Rating;
}
