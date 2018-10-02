package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.ContractType;

import java.util.List;

public interface ContractTypeDAO {

    ContractType getContractType(Integer contrTypeId);

    List<ContractType> getContractTypes();

}
