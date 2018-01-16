package cp.fr.advancelayoutapp.model;

/**
 * Created by Formation on 16/01/2018.
 */

public class RandomUser {

    private String name;
    private String email;
    private Double latitude;
    private Double longitude;


    public RandomUser(){

    }

    public String getName() {
        return name;
    }

    public RandomUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RandomUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public RandomUser setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public RandomUser setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
