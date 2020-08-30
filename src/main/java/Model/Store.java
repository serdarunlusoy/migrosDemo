package Model;


import Controller.CourierUtils;

public class Store {
    private int storeId;
    private String name;
    private double latitude;
    private double longitude;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isInRadius(double latitude,double longitude,double radius){
        try {
            double calculatedDistance = CourierUtils.distanceCalculator(this.latitude, latitude, this.longitude, longitude);
            if (Double.compare(calculatedDistance, radius) < 0)
                return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
