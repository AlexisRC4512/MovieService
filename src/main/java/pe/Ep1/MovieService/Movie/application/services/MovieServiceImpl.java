package pe.Ep1.MovieService.Movie.application.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.Ep1.MovieService.Movie.domain.entity.Movie;
import pe.Ep1.MovieService.Movie.infrastructure.repository.MovieRepository;
import pe.Ep1.MovieService.Movie.infrastructure.request.MovieRequest;
import pe.Ep1.MovieService.Movie.infrastructure.response.BasicResponse;
import pe.Ep1.MovieService.Movie.infrastructure.response.MovieResponse;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public MovieResponse getAll() {
        List<Movie> MovieList=movieRepository.findAll();
        if(MovieList.isEmpty()){
            return MovieResponse.builder().movieList(null).basicResponse(BasicResponse.whenNoDataFound("Movie")).build();
        }else {
            return MovieResponse.builder().movieList(MovieList).basicResponse(BasicResponse.whenSuccess()).build();
        }

    }

    @Override
    public BasicResponse deleteMovie(Long id) {
        try {
            movieRepository.deleteById(id);
            return BasicResponse.whenSuccess();
        }catch (Exception ex){
            return BasicResponse.whenError(ex.getMessage());
        }
    }

    @Override
    public BasicResponse addMovie(MovieRequest request) {
       try {
           if (request!=null){
               movieRepository.save(this.buildMovieFromRequest(request));
               return BasicResponse.whenSuccess();
           }else {
               return BasicResponse.whenError("No hay data");

           }
       }catch (Exception ex)
       {
           return BasicResponse.whenError(ex.getMessage());
       }
    }
    public Movie buildMovieFromRequest(MovieRequest request){
        return Movie.builder().title(request.getTitle()).Genre(request.getGenre()).Year(request.getYear()).Director(request.getDirector())
                .Rating(request.getRating()).build();
    }
    @Override
    public MovieResponse getByTitle(String title) {
        try{
            Movie movie=movieRepository.findByTitle(title);
            if(movie !=null){
                return MovieResponse.builder().movieList(List.of(movie)).basicResponse(BasicResponse.whenSuccess()).build();
            }else {
                return MovieResponse.builder().movieList(null).basicResponse(BasicResponse.whenNoDataFound("Movie")).build();
            }
        }catch (Exception ex){
                return MovieResponse.builder().basicResponse(BasicResponse.whenError(ex.getMessage())).build();

        }
    }
}
