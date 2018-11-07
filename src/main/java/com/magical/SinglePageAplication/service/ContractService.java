package com.magical.SinglePageAplication.service;

import com.magical.SinglePageAplication.dao.*;
import com.magical.SinglePageAplication.dto.ContractDTO;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс уровня сервиса Договоров
 */
@Repository
public class ContractService {
    @Autowired
    private ContractDAO contractDAO;

    /**
     * Функция получения списка всех договоров {@link ContractT1}
     */
    public List<ContractDTO> getContracts() {
        List<ContractDTO> contractsDTO = new ArrayList<ContractDTO>();
        List<ContractT1> list = contractDAO.getContracts();
        list.stream().forEach(i -> contractsDTO.add(convertToDTO(i)));
        return contractsDTO;
    }

    /**
     * Получение договора {@link ContractT1} по его идентификатору
     * @param contractId - идентификатор договора
     * @return - экземпляр договора
     */
    public ContractDTO getContract(int contractId) {
        ContractT1 contract = contractDAO.getContract(contractId);
        return convertToDTO(contract);
    }

    /**
     * Функция добавления нового договора в базу
     * @param newContract - экземпляр договора
     * @return
     */
    public boolean addContract(ContractDTO newContract) {
        return contractDAO.addContract(convertFromDTO(newContract));
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
    public boolean updateContract(ContractDTO updateContract) {

        return contractDAO.updateContract(convertFromDTO(updateContract));
    }

    private ContractDTO convertToDTO(ContractT1 contract) {
        ContractDTO contrDTO = new ContractDTO();
        contrDTO.setId(contract.getId());
        contrDTO.setSeries(contract.getSeries());
        contrDTO.setNumber(contract.getNumber());
        contrDTO.setVehicleId(contract.getVehicle().getId());
        contrDTO.setTypeContractId(contract.getContractType().getId());
        contrDTO.setVehicleName(contract.getVehicle().getName());
        contrDTO.setContractTypeName(contract.getContractType().getName());
        contrDTO.setDateSignature(contract.getDateSignature());
        contrDTO.setDateStart(contract.getDateStart());
        contrDTO.setDateEnd(contract.getDateEnd());
        contrDTO.setSumVAT(contract.getSumVAT());
        contrDTO.setSumWithVAT(contract.getSumWithVAT());
        contrDTO.setComment(contract.getComment());
        calculateParams(contrDTO);
        return contrDTO;
    }

    private ContractT1 convertFromDTO(ContractDTO contractDTO) {
        ContractT1 contract = new ContractT1();
        contract.setId(contractDTO.getId());
        contract.setSeries(contractDTO.getSeries());
        contract.setNumber(contractDTO.getNumber());
        Vehicle veh = new Vehicle();
        veh.setId(contractDTO.getVehicleId());
        veh.setName(contractDTO.getVehicleName());
        contract.setVehicle(veh);
        ContractType contrType = new ContractType();
        contrType.setId(contractDTO.getTypeContractId());
        contrType.setName(contractDTO.getContractTypeName());
        contract.setContractType(contrType);
        contract.setDateSignature(contractDTO.getDateSignature());
        contract.setDateStart(contractDTO.getDateStart());
        contract.setDateEnd(contractDTO.getDateEnd());
        contract.setSumVAT(contractDTO.getSumVAT());
        contract.setSumWithVAT(contractDTO.getSumWithVAT());
        contract.setComment(contractDTO.getComment());
        return contract;
    }


    /**
     * Функция расчитывает вычисляемые параметры для договора
     * @param contractDTO - экземпляр договора
     */
    public void calculateParams(ContractDTO contractDTO) {
        contractDTO.setSumWithoutVAT(calcSumWithoutVAT(contractDTO.getSumVAT(), contractDTO.getSumWithVAT()));
        contractDTO.setRateVAT(calcRateVAT(contractDTO.getSumWithVAT(), contractDTO.getSumVAT()));
        contractDTO.setConformMinSum(confirmMinSum(contractDTO.getSumWithVAT()));
    }

    /**
     * Функция вычисляет соответствие договора минимальной сумме
     * @param sumWithVAT - сумма с НДС
     * @return
     */
    public boolean confirmMinSum(double sumWithVAT) {
        return sumWithVAT > 1000;
    }

    /**
     * Функция вычисляет сумму договора без налога
     * @param sumVAT - сумма НДС
     * @param sumWithVAT - сумма с НДС
     * @return
     */
    public double calcSumWithoutVAT(double sumVAT, double sumWithVAT) {
        return sumWithVAT - sumVAT;
    }

    /**
     * Функция вычисляет ставку НДС
     * @param sumWithVAT - сумма с НДС
     * @param sumVAT - сумма НДС
     * @return
     */
    public int calcRateVAT(double sumWithVAT, double sumVAT) {
        return (int)Math.round(sumVAT * 100 / sumWithVAT);
    }


}
