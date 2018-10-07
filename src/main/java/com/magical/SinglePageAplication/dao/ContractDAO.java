package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;

import java.util.List;

/**
 * Интерфейс DAO договора
 */
public interface ContractDAO {
    /**
     * Получение данных договора по id
     * @param contrId id договора
     * @return
     */
    ContractT1 getContract(Integer contrId);

    /**
     * Добавление нового договора в базу
     * @param contrForm - форма с данными нового договора
     * @return
     */
    boolean addContract(ContractT1Form contrForm);

    /**
     * Обновление данных договора
     * @param contr - форма с обновленными данными договора
     * @return
     */
    boolean updateContract(ContractT1Form contr);

    /**
     * Удаление договора
     * @param contrId - id договора
     * @return
     */
    boolean deleteContract(Integer contrId);

    /**
     * Получение списка всех договоров
     * @return
     */
    List<ContractT1> getContracts();
}
