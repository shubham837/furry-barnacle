package cityinfo.models;
import cityinfo.models.GeoPosition;

/**
 * Created by shubham.singhal on 31/07/16.
 */

public class City {

    private long _id;
    private String key;
    private String name;
    private String fullName;
    private String iata_airport_code;
    private String type;
    private String country;
    private long location_id;
    private boolean inEurope;
    private String countryCode;
    private boolean coreCountry;
    private long distance;
    private GeoPosition geo_position;

    public GeoPosition getGeo_position() {
        return geo_position;
    }

    public void setGeo_position(GeoPosition geo_position) {
        this.geo_position = geo_position;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIata_airport_code() {
        return iata_airport_code;
    }

    public void setIata_airport_code(String iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    @Override
    public String toString() {
        return "City{" +
                "_id=" + _id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iata_airport_code='" + iata_airport_code + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", location_id=" + location_id +
                ", inEurope=" + inEurope +
                ", countryCode='" + countryCode + '\'' +
                ", coreCountry=" + coreCountry +
                ", distance=" + distance +
                '}';
    }
}
