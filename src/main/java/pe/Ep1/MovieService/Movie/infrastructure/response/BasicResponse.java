package pe.Ep1.MovieService.Movie.infrastructure.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BasicResponse {
    private int code;
    private String message;


    public static BasicResponse whenSuccess(){
        return BasicResponse.builder()
                .code(200)
                .message("Success")
                .build();
    }
    public static BasicResponse whenError(String message){
        return BasicResponse.builder()
                .code(500)
                .message(message)
                .build();
    }

    public static BasicResponse whenNoDataFound(String resource){
        return BasicResponse.builder()
                .code(404)
                .message("No "+resource +" found")
                .build();
    }
}
