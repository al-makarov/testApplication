package com.magical.SinglePageAplication.controllers;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
import com.magical.SinglePageAplication.model.ContractType;
import com.magical.SinglePageAplication.model.Vehicle;
import com.magical.SinglePageAplication.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST-контроллер для взаимодействия с фронтом
 */
@RestController
public class RESTController {
    @Autowired
    private ContractService service;

    /**
     * Запрос на получение списка транспортных средств
     * @return
     */
    @RequestMapping(value = "/vehicles", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Vehicle> getVehicles() {
        List<Vehicle> list = service.getVehicles();
        return list;
    }

    /**
     * Запрос на получение списка типов договоров
     * @return
     */
    @RequestMapping(value = "/contract_types", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ContractType> getContractTypes() {
        List<ContractType> listContrTypes = service.getContractTypes();
        return listContrTypes;
    }

    /**
     * Запрос на получение списка договоров
     * @return
     */
    @RequestMapping(value = "/contracts", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ContractT1> getContracts() {
        List<ContractT1> list = service.getContracts();
        return list;
    }

    /**
     * Запрос на получение экземпляра договора
     * @param contrId - id договора
     * @return
     */
    @RequestMapping(value = "/contract/{contrId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ContractT1 getContract(@PathVariable("contrId") Integer contrId) {
        return service.getContract(contrId);
    }

    /**
     * Запрос на добавление нового договора
     * @param contrForm - заполненная форма данных договора
     * @return
     */
    @RequestMapping(value = "/contract", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    boolean addContract(@RequestBody @Valid ContractT1Form contrForm) {
        System.out.println("(Service Side) Creating Contract with contrNo: " + contrForm.getSeries() + contrForm.getNumber());
        return service.addContract(contrForm);
    }

    /**
     * Запрос на обновление данных договора
     * @param contrForm - заполненная форма измененных данных договора
     * @return
     */
    @RequestMapping(value = "/contract", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    boolean  updateContract(@RequestBody @Valid ContractT1Form contrForm) {

        System.out.println("(Service Side) Editing contract with Id: " + contrForm.getId());
        return service.updateContract(contrForm);
    }

    /**
     * Запрос на удаление договора
     * @param contrId - id договора
     */
    @RequestMapping(value = "/contract/{contrId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteContract(@PathVariable("contrId") Integer contrId) {

        System.out.println("(Service Side) Deleting contract with Id: " + contrId);
        service.deleteContract(contrId);
    }


}
