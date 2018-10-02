package com.magical.SinglePageAplication.service;

import com.magical.SinglePageAplication.dao.*;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;

import java.util.List;

/**
 * Класс уровня сервиса Договоров
 */
public class ContractService {

    private ContractDAO contractDAO;
    private VehicleDAO vehicleDAO;
    private ContractTypeDAO contractTypeDAO;

    public ContractService(ContractDAO contrDAO, VehicleDAO vehicleDAO, ContractTypeDAO contractTypeDAO){
        this.contractDAO = contrDAO;
        this.vehicleDAO = vehicleDAO;
        this.contractTypeDAO = contractTypeDAO;
    }

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
        return contractDAO.getContract(contractId);
    }

    /**
     * Функция добавления нового договора в базу
     * @param contract - экземпляр договора
     * @return
     */
    public boolean addContract(ContractT1Form contract) {
        return contractDAO.addContract(contract);
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
     * @param contractForm - экземпляр формы договора
     * @return
     */
    public boolean updateContract(ContractT1Form contractForm) {
        return contractDAO.updateContract(contractForm);
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
