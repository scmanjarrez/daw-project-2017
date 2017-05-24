package upm.etsiinf.daw.rest;

/**
 * Created by S on 24/05/2017.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchTMDB {
    private List<MovieTMDB> results;

    @Override
    public String toString() {
        return "SearchTMDB{" +
                "results=" + results +
                '}';
    }

    public List<MovieTMDB> getResults() {
        return results;
    }

    public void setResults(List<MovieTMDB> results) {
        this.results = results;
    }
}
