package com.magical.SinglePageAplication.controllers;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;
import com.magical.SinglePageAplication.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTController {
    @Autowired
    private ContractService service;

    @RequestMapping(value = "/vehicles", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Vehicle> getVehicles() {
        List<Vehicle> list = service.getVehicles();
        return list;
    }


    @RequestMapping(value = "/contract_types", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ContractType> getContractTypes() {
        List<ContractType> listContrTypes = service.getContractTypes();
        return listContrTypes;
    }

    @RequestMapping(value = "/contracts", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ContractT1> getContracts() {
        List<ContractT1> list = service.getContracts();
        return list;
    }

    @RequestMapping(value = "/contract/{contrId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ContractT1 getContract(@PathVariable("contrId") Integer contrId) {
        return service.getContract(contrId);
    }

    @RequestMapping(value = "/contract", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    boolean addContract(@RequestBody ContractT1Form contrForm) {
        System.out.println("(Service Side) Creating Contract with contrNo: " + contrForm.getSeries() + contrForm.getNumber());
        return service.addContract(contrForm);
    }


    @RequestMapping(value = "/contract", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    boolean  updateContract(@RequestBody ContractT1Form contrForm) {

        System.out.println("(Service Side) Editing contract with Id: " + contrForm.getId());
        return service.updateContract(contrForm);
    }

    @RequestMapping(value = "/contract/{contrId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteContract(@PathVariable("contrId") Integer contrId) {

        System.out.println("(Service Side) Deleting contract with Id: " + contrId);
        service.deleteContract(contrId);
    }


}
