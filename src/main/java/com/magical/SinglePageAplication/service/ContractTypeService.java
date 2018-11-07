package com.magical.SinglePageAplication.service;

import com.magical.SinglePageAplication.dao.ContractTypeDAO;
import com.magical.SinglePageAplication.model.ContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractTypeService {
    @Autowired
    private ContractTypeDAO contractTypeDAO;

    /**
     * Функция возвращает тип договора по его идентификатору
     *
     * @param contrTypeId - идентификатор типа договора
     * @return
     */
    public ContractType getContractType(Integer contrTypeId) {
        return contractTypeDAO.getContractType(contrTypeId);
    }

    /**
     * Функция возвращает список всех типов договоров
     *
     * @return
     */
    public List<ContractType> getContractTypes() {
        return contractTypeDAO.getContractTypes();
    }


}
