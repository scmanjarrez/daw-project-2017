package upm.etsiinf.daw.rest;

/**
 * Created by S on 24/05/2017.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieTMDB {
    private String poster_path;
    private String overview;
    @JsonProperty("release_date")
    private String year;
    private String title;
    private float vote_average;

    @Override
    public String toString() {
        return "MovieTMDB{" +
                "poster_path='" + poster_path + '\'' +
                ", overview='" + overview + '\'' +
                ", release_year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", vote_average=" + vote_average +
                '}';
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if (year != null && !year.isEmpty()){
            year = year.substring(0, year.indexOf("-"));
        }
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }
}
