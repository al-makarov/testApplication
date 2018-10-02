package com.magical.SinglePageAplication.service;

import com.magical.SinglePageAplication.dao.ContractDAO;
import com.magical.SinglePageAplication.dao.ContractTypeJDBC;
import com.magical.SinglePageAplication.dao.VehicleJDBC;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Класс уровня сервиса Договоров
 */
public class ContractService {

    private ContractDAO contractDAO;
    private VehicleJDBC vehicleJDBC;
    private ContractTypeJDBC contractTypeJDBC;

    public ContractService(ContractDAO contrDAO){
        this.contractDAO = contrDAO;
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

}
