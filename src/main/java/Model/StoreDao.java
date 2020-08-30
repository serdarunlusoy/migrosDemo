package Model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class StoreDao {

    static JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        StoreDao.template = template;
    }

    public static int addStore(Store s) {
        String sql = "insert into Store(name,latitude,longitude) values (" + s.getName() + "," + s.getLatitude() + "," + s.getLongitude() + ")";
        return template.update(sql);
    }

    public static int removeStore(int storeId){
        String sql = "delete from Store where store_id=" + storeId;
        return template.update(sql);
    }

    public static int updateStore(Store s){
        String sql ="UPDATE Store set name = '"+s.getName()+"' , latitude = "+s.getLatitude()+", longitude = "+s.getLongitude()+"WHERE store_id = "+s.getStoreId();
        return template.update(sql);
    }

    public static Store getStoreById(int storeId){
        return template.queryForObject("select * from Store where store_id = " + storeId +" limit 1",new RowMapper<Store>(){
            public Store mapRow(ResultSet rs, int row) throws SQLException {
                Store s=new Store();
                s.setStoreId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setLatitude(rs.getDouble(3));
                s.setLongitude(rs.getDouble(4));
                return s;
            }
        });
    }

    public static List<Store> getStores(){
        return template.query("select * from Store",new RowMapper<Store>(){
            public Store mapRow(ResultSet rs, int row) throws SQLException {
                Store s=new Store();
                s.setStoreId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setLatitude(rs.getDouble(3));
                s.setLongitude(rs.getDouble(4));
                return s;
            }
        });
    }
}
