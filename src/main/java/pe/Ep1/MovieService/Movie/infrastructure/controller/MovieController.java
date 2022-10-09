package pe.Ep1.MovieService.Movie.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.Ep1.MovieService.Movie.application.services.MovieService;
import pe.Ep1.MovieService.Movie.domain.entity.Movie;
import pe.Ep1.MovieService.Movie.infrastructure.request.MovieRequest;
import pe.Ep1.MovieService.Movie.infrastructure.response.BasicResponse;
import pe.Ep1.MovieService.Movie.infrastructure.response.MovieResponse;

@RestController
@RequestMapping("/Movie")
public class MovieController {

     @Autowired
    private MovieService movieService;
    @GetMapping
    @RequestMapping("/getAll")
    public MovieResponse getAll()
    {
        return movieService.getAll();
    }
    @GetMapping
    @RequestMapping("/getByTitle")
    public MovieResponse getByTitle(@RequestParam String title){
        return movieService.getByTitle(title);
    }
    @DeleteMapping
    @RequestMapping("/deleteMovie")
    public BasicResponse deleteUser(@RequestParam Long id){
        BasicResponse response=movieService.deleteMovie(id);
        return BasicResponse.whenSuccess();
    }
    @PostMapping
    @RequestMapping("/addMovie")
    public  BasicResponse addMovie (@RequestBody MovieRequest request)
    {
        BasicResponse response=movieService.addMovie(request);
        return BasicResponse.whenSuccess();
    }
}
