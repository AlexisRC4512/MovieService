package pe.Ep1.MovieService.Movie.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@EntityScan
@Entity(name = "Movie")
@Table(
        name = "tbl_Movie"
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @SequenceGenerator(
            name="Movie_sequence",
            sequenceName = "Movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Movie_sequence"
    )
    private long Id;
    private String title;
    private String Year;
    private String Genre;
    private String Director;
    private String Rating;
}
