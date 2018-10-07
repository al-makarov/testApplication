package com.magical.SinglePageAplication.service;

import com.magical.SinglePageAplication.dao.*;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

    /**
     * Функция получения списка всех договоров {@link ContractT1}
     */
    public List<ContractT1> getContracts() {
        List<ContractT1> list = contractDAO.getContracts();

        for(ContractT1 contract: list){
            calculateParams(contract);
        }
        return list;
    }

    /**
     * Получение договора {@link ContractT1} по его идентификатору
     * @param contractId - идентификатор договора
     * @return - экземпляр договора
     */
    public ContractT1 getContract(int contractId) {
        ContractT1 contract = contractDAO.getContract(contractId);
        calculateParams(contract);
        return contract;
    }

    /**
     * Функция добавления нового договора в базу
     * @param newContract - экземпляр договора
     * @return
     */
    public boolean addContract(ContractT1Form newContract) {
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

    /**
     * Функция расчитывает вычисляемые параметры для договора
     * @param contract - экземпляр договора
     */
    private void calculateParams(ContractT1 contract) {
        contract.setSumWithoutVAT(calcSumWithoutVAT(contract.getSumVAT(),contract.getSumWithVAT()));
        contract.setRateVAT(calcRateVAT(contract.getSumWithVAT(),contract.getSumVAT()));
        contract.setConformMinSum(confirmMinSum(contract.getSumWithVAT()));
    }

    /**
     * Функция вычисляет соответствие договора минимальной сумме
     * @param sumWithVAT - сумма с НДС
     * @return
     */
    private boolean confirmMinSum(double sumWithVAT) {
        return sumWithVAT > 1000;
    }

    /**
     * Функция вычисляет сумму договора без налога
     * @param sumVAT - сумма НДС
     * @param sumWithVAT - сумма с НДС
     * @return
     */
    private double calcSumWithoutVAT(double sumVAT, double sumWithVAT) {
        return sumWithVAT - sumVAT;
    }

    /**
     * Функция вычисляет ставку НДС
     * @param sumWithVAT - сумма с НДС
     * @param sumVAT - сумма НДС
     * @return
     */
    private int calcRateVAT(double sumWithVAT, double sumVAT) {
        return (int)Math.round(sumVAT * 100 / sumWithVAT);
    }


}
