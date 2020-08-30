package Controller;

import Model.CourierLocation;
import Model.CourierLocationDao;
import Model.Store;

public class LogCourierCommand {
    private final double courierLongitude;
    private final double courierLatitude;
    private final long entryDate;
    private final int courierId;
    private final double radius = 100.0;
    private final long interval = 60000;
    private String result;


    public LogCourierCommand(double courierLongitude, double courierLatitude, long timeInMs, int courierId) {
        this.courierLongitude = courierLongitude;
        this.courierLatitude = courierLatitude;
        this.entryDate = timeInMs;
        this.courierId = courierId;
    }

    public void processCommand() {
        try {
            Store selectedStore = CourierUtils.findStore(this.courierLatitude, this.courierLongitude, this.radius);
            if (selectedStore != null) {
                if (CourierLocation.isValidEntry(courierId, selectedStore, interval, entryDate)) {
                    CourierLocation cl = new CourierLocation();
                    cl.setCourierId(this.courierId);
                    cl.setStore(selectedStore);
                    cl.setLatitude(this.courierLatitude);
                    cl.setLongitude(this.courierLongitude);
                    cl.setCdate(this.entryDate);
                    CourierLocationDao.addCourierLocation(cl);
                    this.result = String.format(Results.SUCCESS.getMessage(),courierId,selectedStore.getStoreId());
                } else {
                    this.result = String.format(Results.TIME_ERROR.getMessage() , courierId, selectedStore.getName(),this.interval);
                }

            } else {
                this.result = Results.NO_STORE.getMessage();
            }
        } catch (Exception e) {
            this.result = Results.ERROR.getMessage();
            System.out.println(e.getMessage());
        }
    }

    public String getResult() {
        return result;
    }
}
