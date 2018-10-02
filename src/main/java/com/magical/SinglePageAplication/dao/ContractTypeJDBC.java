package com.magical.SinglePageAplication.dao;

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
public class ContractTypeJDBC implements ContractTypeDAO {
    @Autowired
    DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        System.out.println("JDBCExample postConstruct is called. datasource = " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public ContractType getContractType(String contrTypeId) {
        return getContractType(Integer.parseInt(contrTypeId));
    }
    public ContractType getContractType(Integer contrTypeId) {

        System.out.println("ContractTypeJDBC: getContractType  is called");
        final String QUERY_SQL = "SELECT * FROM contract_types WHERE id = "+contrTypeId;

        List<ContractType> contrTypeList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<ContractType>() {
            public ContractType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                ContractType contrType = new ContractType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                return contrType;
            }
        });
        return contrTypeList.get(0);
    }


    public List<ContractType> getContractTypes() {

        System.out.println("VehicleJDBC: getAllVehicles  is called");
        final String QUERY_SQL = "SELECT * FROM contract_types";

        List<ContractType> contrTypeList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<ContractType>() {
            public ContractType mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                ContractType contrType = new ContractType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                    );
                return contrType;
            }
        });
        return contrTypeList;
    }
    
}
