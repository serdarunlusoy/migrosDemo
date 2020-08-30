package Model;

import java.util.SortedMap;

public class CourierLocation {
    private int courierLocationId;
    private Store store;
    private int courierId;
    private long cdate;
    private double latitude;
    private double longitude;

    public int getCourierLocationId() {
        return courierLocationId;
    }

    public void setCourierLocationId(int courierLocationId) {
        this.courierLocationId = courierLocationId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public long getCdate() {
        return cdate;
    }

    public void setCdate(long cdate) {
        this.cdate = cdate;
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

    public static boolean isValidEntry(int courierId, Store s,long timeDifference,long entryDate){
      CourierLocation cl =  CourierLocationDao.getLatestCourierLocationRecordByCourierIdAndStoreId(courierId,s.getStoreId());
      return cl == null || entryDate-cl.getCdate() > timeDifference;
    }
}
