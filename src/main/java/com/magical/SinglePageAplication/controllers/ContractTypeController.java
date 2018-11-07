package com.magical.SinglePageAplication.controllers;

import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractTypeController {
    @Autowired
    private ContractTypeService service;

    /**
     * Запрос на получение списка типов договоров
     *
     * @return
     */
    @RequestMapping(value = "/contract_types", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<ContractType> getContractTypes() {
        List<ContractType> listContrTypes = service.getContractTypes();
        return listContrTypes;
    }

}
