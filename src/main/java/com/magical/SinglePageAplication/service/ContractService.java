package com.magical.SinglePageAplication.service;

import com.magical.SinglePageAplication.dao.*;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс уровня сервиса Договоров
 */
@Repository
public class ContractService {
    @Autowired
    private ContractDAO contractDAO;
    @Autowired
    private VehicleDAO vehicleDAO;
    @Autowired
    private ContractTypeDAO contractTypeDAO;

   /* public ContractService(ContractDAO contrDAO, VehicleDAO vehicleDAO, ContractTypeDAO contractTypeDAO){
        this.contractDAO = contrDAO;
        this.vehicleDAO = vehicleDAO;
        this.contractTypeDAO = contractTypeDAO;
    }*/

    /**
     * Функция получения списка всех договоров {@link ContractT1}
     */
    public List<ContractT1> getContracts() {
        return contractDAO.getContracts();
    }

    /**
     * Получение договора {@link ContractT1} по его идентификатору
     * @param contractId - идентификатор договора
     * @return - экземпляр договора
     */
    public ContractT1 getContract(int contractId) {
        /*ContractT1 contractTemp = contractDAO.getContract(contractId);
        double sumWithoutVAT = contractTemp.getSumWithoutVAT() - contractTemp.getSumVAT();
        contractTemp.setSumWithoutVAT(sumWithoutVAT);
        int rateVAT = Math.round((float)( contractTemp.getSumVAT()/ (contractTemp.getSumWithVAT() - contractTemp.getSumVAT()) / 100));
        contractTemp.setRateVAT(rateVAT);
        */
        //this.conformMinSum = (contrForm.getSumWithVAT() > 1000)? true : false;

        return contractDAO.getContract(contractId);


    }

    /**
     * Функция добавления нового договора в базу
     * @param newContract - экземпляр договора
     * @return
     */
    public boolean addContract(ContractT1Form newContract) {
        //ContractT1 newContract = new ContractT1();

        /*newContract.setSeries(contract.getSeries());
        newContract.setNumber(contract.getNumber());
        newContract.setDateSignature(contract.getDateSignature());
        newContract.setDateStart(contract.getDateStart());
        newContract.setDateEnd(contract.getDateEnd());
        newContract.setSumVAT(contract.getSumVAT());
        newContract.setSumWithVAT(contract.getSumWithVAT());
        newContract.setComment(contract.getComment());
        newContract.setVehicle(contract.getVehicleId());
        newContract.setTypeContract(contract.getTypeContractId());
        */

        // this.typeContract = contrForm.getTypeContract();

        //this.sumWithoutVAT = contrForm.getSumWithVAT() - contrForm.getSumVAT();
        //this.rateVAT = Math.round((float)( contrForm.getSumVAT()/ (contrForm.getSumWithVAT() - contrForm.getSumVAT()) / 100));

        //this.conformMinSum = (contrForm.getSumWithVAT() > 1000)? true : false;

        return contractDAO.addContract(newContract);
    }

    /**
     * Функция удаления договора {@link ContractT1} из базы
     * @param contractId - идентификатор договора
     * @return
     */
    public boolean deleteContract(int contractId) {
        return contractDAO.deleteContract(contractId);
    }

    /**
     * Функция обновления данных договора {@link ContractT1}
     * @param updateContract - экземпляр формы договора
     * @return
     */
    public boolean updateContract(ContractT1Form updateContract) {

        return contractDAO.updateContract(updateContract);
    }

    /**
     * Функция получения списка транспортных средств {@link Vehicle}
     * @return
     */
    public List<Vehicle> getVehicles() {
        return vehicleDAO.getVehicles();
    }

    /**
     * Функция возвращает транспортное средство по его идентификатору
     * @param vehicleId - идентификатор транспортного средства
     * @return
     */
    public Vehicle getVehicle(Integer vehicleId) {
        return vehicleDAO.getVehicle(vehicleId);
    }

    /**
     * Функция возвращает тип договора по его идентификатору
     * @param contrTypeId - идентификатор типа договора
     * @return
     */
    public ContractType getContractType(Integer contrTypeId) {
        return contractTypeDAO.getContractType(contrTypeId);
    }

    /**
     * Функция возвращает список всех типов договоров
     * @return
     */
    public List<ContractType> getContractTypes() {
        return contractTypeDAO.getContractTypes();
    }


}
