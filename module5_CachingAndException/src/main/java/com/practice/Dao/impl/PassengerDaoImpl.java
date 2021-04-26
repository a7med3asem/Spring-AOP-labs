package com.practice.Dao.impl;

import com.practice.Dao.PassengerDao;
import com.practice.annotation.Log;
import com.practice.model.Passenger;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Service("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengersMap = new HashMap<>();

    private DataSource dataSource;
//    private JdbcTemplate jdbcTemplate;

//    public RowMapper rowMapper = (resultSet, rowNum) -> {
//        Passenger passenger = new Passenger();
//        passenger.setName(resultSet.getString("name"));
//        passenger.setCountry(resultSet.getString("country"));
//
//        return passenger;
//    };

    /*
     * Used by Spring to inject the dataSource and initialize jdbc template
     * */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
//        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public Passenger getPassenger(int id) {
        return null;
    }

//    private Passenger getById(int id) {
//        String sql = "SELECT * FROM PASSENGERS WHERE ID = ?";
//        return (Passenger) jdbcTemplate.queryForObject(sql, rowMapper, id);
//    }


//    @Override
//    public Passenger getPassenger(int id) {
//        if (passengersMap.get(id) != null) {
//            return passengersMap.get(id);
//        }
//
//        Passenger passenger = getById(id);
//
//        return passenger;
//    }
}
