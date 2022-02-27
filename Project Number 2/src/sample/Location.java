package sample;

public class Location {
    private String address;
    private int latitude;
    private int longitude;
    private String zip;

    public Location() {
        this.address = "N/A";
        this.zip = "N/A";
    }

    public Location(String address, int latitude, int longitude, String zip) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address: " + address + " Latitude: " + latitude + " Longitude: " + longitude + " Zip: " + zip;
    }
}
