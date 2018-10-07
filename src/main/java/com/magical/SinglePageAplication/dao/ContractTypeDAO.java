package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.ContractType;

import java.util.List;

/**
 * Интерфейс DAO Типа договора
 */
public interface ContractTypeDAO {
    /**
     * Получение типа договора по его id
     * @param contrTypeId - id Типа договора
     * @return
     */
    ContractType getContractType(Integer contrTypeId);

    /**
     * Получение списка типов договоров
     * @return
     */
    List<ContractType> getContractTypes();

}
