package sample;

public class Location {
    private String address;
    private String city;
    private String province;
    private String zipCode;

    // Constructor with no parameters
    public Location() {
        this.address = "N/A";
        this.city = "N/A";
        this.province = "N/A";
        this.zipCode = "N/A";
    }

    // Constructor with 4 parameters
    public Location(String address, String city, String province, String zip) {
        this.address = address;
        this.city = city;
        this.province = province;
        this.zipCode = zip;
    }

    // Getters and Setters for all fields
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // toString has been overridden to be able to print the Location Object
    @Override
    public String toString() {
        return "Address: " + address + " City: " + city + " Province: " + province + " Zip Code: " + zipCode;
    }
}
