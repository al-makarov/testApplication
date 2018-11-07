package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.ContractT1;
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
import java.util.*;

/**
 * Реализация интерфейса DAO договора для JDBC
 */
@Repository
public class ContractT1JDBC implements ContractDAO{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        System.out.println("JDBCExample postConstruct is called. datasource = " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public ContractT1 getContract(Integer contrId) {

        System.out.println("ContractT1JDBC: getContract  is called");
        final String QUERY_SQL = "SELECT contracts.id as contId, contracts.series as contSeries," +
                "contracts.number as contNumber, contracts.typeContract as contTypeId, contracts.vehicle as contVehicleId," +
                "contracts.dateStart as contDateStart, contracts.dateEnd as contDateEnd," +
                "contracts.dateSignature as contDateSign, contracts.sumWithVAT as contSumWithVAT," +
                "contracts.sumVAT as contSumVAT, contracts.comment as contComment, vehicles.number as vehNum," +
                "contract_types.name as contTypeName FROM contracts, vehicles, contract_types " +
                "WHERE contracts.typeContract = contract_types.id and contracts.vehicle = vehicles.id and id = "+contrId;


        List<ContractT1> contractList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<ContractT1>() {
            public ContractT1 mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                ContractT1 contractTemp = new ContractT1();
                contractTemp.setId(resultSet.getInt("contId"));
                contractTemp.setSeries(resultSet.getString("contSeries"));
                contractTemp.setNumber(resultSet.getString("contNumber"));
                ContractType contTypeTemp = new ContractType(resultSet.getInt("contTypeId"),
                                                             resultSet.getString("contTypeName"));
                contractTemp.setContractType(contTypeTemp);
                Vehicle vehicleTemp = new Vehicle(resultSet.getInt("contVehicleId"),
                                                  resultSet.getString("vehNum"));
                contractTemp.setVehicle(vehicleTemp);
                contractTemp.setDateStart(resultSet.getDate("contDateStart"));
                contractTemp.setDateEnd(resultSet.getDate("contDateEnd"));
                contractTemp.setDateSignature(resultSet.getDate("contDateSign"));
                contractTemp.setSumWithVAT(resultSet.getFloat("contSumWithVAT"));
                contractTemp.setSumVAT(resultSet.getFloat("contSumVAT"));
                contractTemp.setComment(resultSet.getString("contComment"));
                return contractTemp;
            }
        });
        return contractList.get(0);
    }

    public boolean addContract(ContractT1 contract) {

        final String INSERT_SQL = "INSERT INTO contracts(series, number, typeContract, dateSignature, "+
                                    "dateStart, dateEnd, sumVat,sumWithVat,vehicle,comment)"+
                                    " VALUES (?,?,?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(INSERT_SQL,
                new Object[]{contract.getSeries(), contract.getNumber(),
                        contract.getContractType().getId(), contract.getDateSignature(),
                        contract.getDateStart(), contract.getDateEnd(),
                        contract.getSumVAT(), contract.getSumWithVAT(),
                        contract.getVehicle().getId(), contract.getComment()});
        if (result > 0) {
            System.out.println("Contract is inserted: " + contract.getSeries() + contract.getNumber());
            return true;
        } else {
            return false;
        }
    }


    //JDBC TEMPLATE UPDATE EXAMPLE
    public boolean updateContract(ContractT1 contractUpdate) {
        System.out.println("contractT1JDBC: updateContract called");

        final String UPDATE_SQL = "UPDATE contracts SET series = ?, number = ?,"+
                                    " typeContract = ?, dateSignature = ?, "+
                                    "dateStart = ?, dateEnd = ?, sumVat = ?,"+
                                    "sumWithVat = ?, vehicle = ?, comment = ?"+
                                    "   WHERE id = ?";

        int result = jdbcTemplate.update(UPDATE_SQL,
                new Object[]{contractUpdate.getSeries(), contractUpdate.getNumber(),
                        contractUpdate.getContractType().getId(), contractUpdate.getDateSignature(),
                            contractUpdate.getDateStart(), contractUpdate.getDateEnd(), contractUpdate.getSumVAT(),
                        contractUpdate.getSumWithVAT(), contractUpdate.getVehicle().getId(), contractUpdate.getComment(),
                            contractUpdate.getId()});

        if (result > 0) {
            System.out.println("User is updated: " + contractUpdate.getId());
            return true;
        } else {
            System.out.println("ERROR User is NONE updated: " + contractUpdate.getId());
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
        final String QUERY_SQL = "SELECT contracts.id as contId, contracts.series as contSeries," +
                "contracts.number as contNumber, contracts.typeContract as contTypeId, contracts.vehicle as contVehicleId," +
                "contracts.dateStart as contDateStart, contracts.dateEnd as contDateEnd," +
                "contracts.dateSignature as contDateSign, contracts.sumWithVAT as contSumWithVAT," +
                "contracts.sumVAT as contSumVAT, contracts.comment as contComment, vehicles.number as vehNum," +
                "contract_types.name as contTypeName FROM contracts, vehicles, contract_types " +
                "WHERE contracts.typeContract = contract_types.id and contracts.vehicle = vehicles.id";
        List<ContractT1> contractList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<ContractT1>() {
            public ContractT1 mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                ContractT1 contractTemp = new ContractT1();
                contractTemp.setId(resultSet.getInt("contId"));
                contractTemp.setSeries(resultSet.getString("contSeries"));
                contractTemp.setNumber(resultSet.getString("contNumber"));
                ContractType contTypeTemp = new ContractType(resultSet.getInt("contTypeId"),
                        resultSet.getString("contTypeName"));
                contractTemp.setContractType(contTypeTemp);
                Vehicle vehicleTemp = new Vehicle(resultSet.getInt("contVehicleId"),
                        resultSet.getString("vehNum"));
                contractTemp.setVehicle(vehicleTemp);
                contractTemp.setDateStart(resultSet.getDate("contDateStart"));
                contractTemp.setDateEnd(resultSet.getDate("contDateEnd"));
                contractTemp.setDateSignature(resultSet.getDate("contDateSign"));
                contractTemp.setSumWithVAT(resultSet.getFloat("contSumWithVAT"));
                contractTemp.setSumVAT(resultSet.getFloat("contSumVAT"));
                contractTemp.setComment(resultSet.getString("contComment"));
                return contractTemp;
            }
        });
        return contractList;

    }




}
