package upm.etsiinf.daw.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    private final String sub;
    private final String name;
    private final String picture;
    private final String profile;
    private final String given_name;
    private final String family_name;

    @JsonCreator
    public UserInfo(@JsonProperty("sub") String sub, //id
                    @JsonProperty("name") String name,
                    @JsonProperty("picture") String picture,
                    @JsonProperty("profile") String profile,
                    @JsonProperty("given_name") String given_name,
                    @JsonProperty("family_name") String family_name) {

        this.sub = sub;
        this.name = name;
        this.picture = picture;
        this.profile = profile;
        this.given_name = given_name;
        this.family_name = family_name;
    }

    public String getSub() {
        return sub;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getProfile() {
        return profile;
    }

    public String getGiven_name() {
        return given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sub='" + sub + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", profile='" + profile + '\'' +
                ", given_name='" + given_name + '\'' +
                ", family_name='" + family_name + '\'' +
                '}';
    }
}