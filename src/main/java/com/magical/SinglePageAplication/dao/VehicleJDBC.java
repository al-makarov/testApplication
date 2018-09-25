package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VehicleJDBC {
    @Autowired
    DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        System.out.println("JDBCExample postConstruct is called. datasource = " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Vehicle getVehicle(String vehId) {
        return getVehicle(Integer.parseInt(vehId));
    }

    public Vehicle getVehicle(Integer vehId) {

        System.out.println("VehicleT1JDBC: getVehicle  is called");
        final String QUERY_SQL = "SELECT * FROM vehicles WHERE id = "+vehId;

        List<Vehicle> vehicleList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Vehicle>() {
            public Vehicle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Vehicle veh = new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("number")
                );
                return veh;
            }
        });
        return vehicleList.get(0);
    }


    public List<Vehicle> getAllVehicles() {

        System.out.println("VehicleJDBC: getAllVehicles  is called");
        final String QUERY_SQL = "SELECT * FROM vehicles";

        List<Vehicle> vehicleList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Vehicle>() {
            public Vehicle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Vehicle veh = new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("number")
                    );
                return veh;
            }
        });
        return vehicleList;
    }

}
