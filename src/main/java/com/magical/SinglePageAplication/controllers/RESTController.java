package com.magical.SinglePageAplication.controllers;

import com.magical.SinglePageAplication.dao.ContractT1JDBC;
import com.magical.SinglePageAplication.dao.ContractTypeJDBC;
import com.magical.SinglePageAplication.dao.VehicleJDBC;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTController {
    @Autowired
    private ContractT1JDBC contractT1JDBC;
    @Autowired
    private VehicleJDBC vehicleJDBC;
    @Autowired
    private ContractTypeJDBC contractTypeJDBC;


    @RequestMapping(value = "/vehicles", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Vehicle> getVehicles() {
        List<Vehicle> list = vehicleJDBC.getAllVehicles();
        return list;
    }


    @RequestMapping(value = "/contract_types", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ContractType> getContractTypes() {
        List<ContractType> listContrTypes = contractTypeJDBC.getAllContractTypes();
        return listContrTypes;
    }

    @RequestMapping(value = "/contracts", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ContractT1> getContracts() {
        List<ContractT1> list = contractT1JDBC.getAllContracts(); //contractT1DAO.getAllContracts();
        return list;
    }

    @RequestMapping(value = "/contract/{contrId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ContractT1 getContract(@PathVariable("contrId") Integer contrId) {
        return contractT1JDBC.getContract(contrId);
    }

    @RequestMapping(value = "/contract", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    boolean addContract(@RequestBody ContractT1Form contrForm) {
        System.out.println("(Service Side) Creating Contract with contrNo: " + contrForm.getSeries() + contrForm.getNumber());
        return contractT1JDBC.addContract(contrForm);
    }


    @RequestMapping(value = "/contract", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    boolean  updateContract(@RequestBody ContractT1Form contrForm) {

        System.out.println("(Service Side) Editing contract with Id: " + contrForm.getId());
        return contractT1JDBC.updateContract(contrForm);
    }

    @RequestMapping(value = "/contract/{contrId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteContract(@PathVariable("contrId") Long contrId) {

        System.out.println("(Service Side) Deleting contract with Id: " + contrId);
        contractT1JDBC.deleteContract(contrId);
    }


}
