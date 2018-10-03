package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ContractT1JDBC implements ContractDAO{
    @Autowired
    DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private VehicleJDBC vehicleJDBC;
    @Autowired
    private ContractTypeJDBC contractTypeJDBC;
    @PostConstruct
    public void init() {
        System.out.println("JDBCExample postConstruct is called. datasource = " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public ContractT1 getContract(Integer contrId) {

        System.out.println("ContractT1JDBC: getContract  is called");
        final String QUERY_SQL = "SELECT * FROM contracts WHERE id = "+contrId;

        List<ContractT1> contractList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<ContractT1>() {
            public ContractT1 mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                ContractT1 contractTemp = new ContractT1();
                contractTemp.setId(resultSet.getInt("id"));
                contractTemp.setSeries(resultSet.getString("series"));
                contractTemp.setNumber(resultSet.getString("number"));
                contractTemp.setTypeContract(resultSet.getInt("typeContract"));
                contractTemp.setVehicle(resultSet.getInt("vehicle"));
                contractTemp.setDateStart(resultSet.getDate("dateStart"));
                contractTemp.setDateEnd(resultSet.getDate("dateEnd"));
                contractTemp.setDateSignature(resultSet.getDate("dateSignature"));
                contractTemp.setSumWithVAT(resultSet.getFloat("sumWithVAT"));
                contractTemp.setSumVAT(resultSet.getFloat("sumVAT"));
                contractTemp.setComment(resultSet.getString("comment"));
                return contractTemp;
            }
        });
        return contractList.get(0);
    }

    public boolean addContract(ContractT1Form contrForm) {

        final String INSERT_SQL = "INSERT INTO contracts(series, number, typeContract, dateSignature, "+
                                    "dateStart, dateEnd, sumVat,sumWithVat,vehicle,comment)"+
                                    " VALUES (?,?,?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(INSERT_SQL,
                                        new Object[]{contrForm.getSeries()},
                                        new Object[]{contrForm.getNumber()},
                                        new Object[]{contrForm.getTypeContractId()},
                                        new Object[]{contrForm.getDateSignature()},
                                        new Object[]{contrForm.getDateStart()},
                                        new Object[]{contrForm.getDateEnd()},
                                        new Object[]{contrForm.getSumVAT()},
                                        new Object[]{contrForm.getSumWithVAT()},
                                        new Object[]{contrForm.getVehicleId()},
                                        new Object[]{contrForm.getComment()});
        if (result > 0) {
            System.out.println("Contract is inserted: " + contrForm.getSeries()+contrForm.getNumber());
            return true;
        } else {
            return false;
        }
    }


    //JDBC TEMPLATE UPDATE EXAMPLE
    public boolean updateContract(ContractT1Form contractUpdate)  {
        System.out.println("contractT1JDBC: updateContract called");

        final String UPDATE_SQL = "UPDATE contracts SET series = ?, number = ?,"+
                                    " typeContract = ?, dateSignature = ?, "+
                                    "dateStart = ?, dateEnd = ?, sumVat = ?,"+
                                    "sumWithVat = ?, vehicle = ?, comment = ?"+
                                    "   WHERE id = ?";

        int result = jdbcTemplate.update(UPDATE_SQL,new Object[]{contractUpdate.getSeries()},
                                                    new Object[]{contractUpdate.getNumber()},
                                                    new Object[]{contractUpdate.getTypeContractId()},
                                                    new Object[]{contractUpdate.getDateSignature()},
                                                    new Object[]{contractUpdate.getDateStart()},
                                                    new Object[]{contractUpdate.getDateEnd()},
                                                    new Object[]{contractUpdate.getSumVAT()},
                                                    new Object[]{contractUpdate.getSumWithVAT()},
                                                    new Object[]{contractUpdate.getVehicleId()},
                                                    new Object[]{contractUpdate.getComment()},
                                                    new Object[]{contractUpdate.getId()}
                                                    );
        if (result > 0) {
            System.out.println("User is updated: " + contractUpdate.getId());
            return true;
        } else {
            return false;
        }
    }



    //JDBC TEMPLATE DELETE EXAMPLE
    public boolean deleteContract(Integer contrId) {
        System.out.println("ContractT1JDBC: deleteContracts called");
        final String DELETE_SQL = "DELETE FROM contracts WHERE id LIKE ?";
        int result = jdbcTemplate.update(DELETE_SQL,new Object[]{contrId});
        System.out.println("r" + result);
        if (result > 0) {
            System.out.println("Contract is deleted: " + contrId);
            return true;
        } else {
            return false;
        }
    }


    public List<ContractT1> getContracts() {
        System.out.println("ContractT1JDBC: getAllContracts  is called");
        final String QUERY_SQL = "SELECT * FROM contracts";
        List<ContractT1> contractList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<ContractT1>() {
            public ContractT1 mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                ContractT1 contractTemp = new ContractT1();
                    contractTemp.setId(resultSet.getInt("id"));
                    contractTemp.setSeries(resultSet.getString("series"));
                    contractTemp.setNumber(resultSet.getString("number"));
                    contractTemp.setTypeContract(resultSet.getInt("typeContract"));
                    contractTemp.setVehicle(resultSet.getInt("vehicle"));
                    contractTemp.setDateStart(resultSet.getDate("dateStart"));
                    contractTemp.setDateEnd(resultSet.getDate("dateEnd"));
                    contractTemp.setDateSignature(resultSet.getDate("dateSignature"));
                    contractTemp.setSumWithVAT(resultSet.getFloat("sumWithVAT"));
                    contractTemp.setSumVAT(resultSet.getFloat("sumVAT"));
                    contractTemp.setComment(resultSet.getString("comment"));

                return contractTemp;
            }
        });
        return contractList;

    }




}
