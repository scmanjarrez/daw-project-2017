package upm.etsiinf.daw.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by S on 23/05/2017.
 */

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 1000)
    private String title;
    @Column(length = 2000)
    private String url;
    @Column(length = 2000)
    private String description;
    private int year;
//    private String director;

//    @ManyToMany
//    @JoinTable(name = "film_actor",
//            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
//    private List<Actor> cast;
    private String cover;
    private float rating;

    protected Movie() {
    }

    public Movie(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Movie(String title, String url, String description, int year, /*String director, List<Actor> cast,*/
                 String cover, float rating) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.year = year;
//        this.director = director;
//        this.cast = cast;
        this.cover = cover;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public List<Actor> getCast() {
//        return cast;
//    }
//
//    public void setCast(List<Actor> cast) {
//        this.cast = cast;
//    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
//                ", director='" + director + '\'' +
//                ", cast=" + cast +
                ", cover='" + cover + '\'' +
                ", rating=" + rating +
                '}';
    }
}
