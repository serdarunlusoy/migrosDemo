package Controller;

import Model.CourierLocation;
import Model.CourierLocationDao;
import Model.Store;
import Model.StoreDao;


import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class CourierUtils {

    public static Store findStore(double courierLatitude, double courierLongitude, double radius) {
        Store store = null;
        try {
            List<Store> stores = StoreDao.getStores();
            store = stores.stream().filter(s -> s.isInRadius(courierLatitude, courierLongitude, radius)).findFirst().orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return store;
    }

    public static double distanceCalculator(double latitude1, double latitude2, double longitude1, double longitude2) {
        try {
            //reference https://stackoverflow.com/questions/639695/how-to-convert-latitude-or-longitude-to-meters
            double R = 6378.137; // Radius of earth in KM
            double latitudeDifference = latitude2 * Math.PI / 180 - latitude1 * Math.PI / 180;
            double longitudeDifference = longitude2 * Math.PI / 180 - longitude1 * Math.PI / 180;
            double a = Math.sin(latitudeDifference/2) * Math.sin(latitudeDifference/2) +
                    Math.cos(latitude1 * Math.PI / 180) * Math.cos(latitude2 * Math.PI / 180) *
                            Math.sin(longitudeDifference/2) * Math.sin(longitudeDifference/2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
            double d = R * c;
            return d * 1000; // meters
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0.0;
    }

    public static double getTotalTravelDistance(int courierId) {
        AtomicReference<Double> totalDistance = new AtomicReference<>(0.0);
        List<CourierLocation> locationRecords = CourierLocationDao.getCourierRecords(courierId);
        if (locationRecords != null && !locationRecords.isEmpty()) {
            IntStream.rangeClosed(0, locationRecords.size() - 2).forEach(
                    o -> {
                        CourierLocation location1 = locationRecords.get(o);
                        CourierLocation location2 = locationRecords.get(o + 1);
                        totalDistance.updateAndGet(v -> v + distanceCalculator(location1.getLatitude(), location2.getLatitude(), location1.getLongitude(), location2.getLongitude()));
                    }
            );
        }
        return totalDistance.get();
    }
}
