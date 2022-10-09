package pe.Ep1.MovieService.Movie.application.services;

import pe.Ep1.MovieService.Movie.infrastructure.request.MovieRequest;
import pe.Ep1.MovieService.Movie.infrastructure.response.BasicResponse;
import pe.Ep1.MovieService.Movie.infrastructure.response.MovieResponse;

public interface MovieService {
    public MovieResponse getAll();
    public BasicResponse deleteMovie(Long id);
    public BasicResponse addMovie(MovieRequest request);
    public MovieResponse getByTitle(String title);
}
