package Model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourierLocationDao {

    static JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        CourierLocationDao.template = template;
    }

    public static int addCourierLocation(CourierLocation cl) {
        String sql = "INSERT INTO COURIER_LOCATION (store_id,courier_id,cdate,latitude,longitude)" +
                " VALUES(" + cl.getStore().getStoreId() + "," + cl.getCourierId() + "," + cl.getCdate() + "," + cl.getLatitude() + "," + cl.getLongitude()
                + ")";
        return template.update(sql);
    }

    public static CourierLocation getLatestCourierLocationRecordByCourierIdAndStoreId(int courierId, int storeId) {
        try {
            return template.queryForObject("select * from courier_location where courier_Id ="+courierId+" and store_id="+storeId+" order by cdate desc limit 1", new RowMapper<CourierLocation>() {
                @Override
                public CourierLocation mapRow(ResultSet resultSet, int i) throws SQLException {
                    CourierLocation cl = new CourierLocation();
                    cl.setCourierLocationId(resultSet.getInt("COURIER_LOCATION_ID"));
                    cl.setStore(StoreDao.getStoreById(resultSet.getInt("STORE_ID")));
                    cl.setCourierId(resultSet.getInt("COURIER_ID"));
                    cl.setCdate(resultSet.getLong("CDATE"));
                    cl.setLatitude(resultSet.getDouble("LATITUDE"));
                    cl.setLongitude(resultSet.getDouble("LONGITUDE"));
                    return cl;
                }
            });
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return null;
        }
    }

    public static List<CourierLocation> getCourierRecords(int courierId) {
        try {
            return template.query("select * from courier_location where courier_Id ="+courierId, new RowMapper<CourierLocation>() {
                @Override
                public CourierLocation mapRow(ResultSet resultSet, int i) throws SQLException {
                    CourierLocation cl = new CourierLocation();
                    cl.setCourierLocationId(resultSet.getInt("COURIER_LOCATION_ID"));
                    cl.setStore(StoreDao.getStoreById(resultSet.getInt("STORE_ID")));
                    cl.setCourierId(resultSet.getInt("COURIER_ID"));
                    cl.setCdate(resultSet.getLong("CDATE"));
                    cl.setLatitude(resultSet.getDouble("LATITUDE"));
                    cl.setLongitude(resultSet.getDouble("LONGITUDE"));
                    return cl;
                }
            });
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return null;
        }
    }
}
