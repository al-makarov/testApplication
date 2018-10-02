package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;

import java.util.List;

public interface ContractDAO {

    ContractT1 getContract(Integer contrId);

    boolean addContract(ContractT1Form contrForm);

    boolean updateContract(ContractT1Form contr);

    boolean deleteContract(Integer contrId);

    List<ContractT1> getContracts();
}
