package com.magical.SinglePageAplication.controllers;

import com.magical.SinglePageAplication.dto.ContractDTO;
import com.magical.SinglePageAplication.model.ContractT1;
import com.magical.SinglePageAplication.model.ContractT1Form;
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
public class ContractController {
    @Autowired
    private ContractService service;

    /**
     * Запрос на получение списка договоров
     * @return
     */
    @RequestMapping(value = "/contracts", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<ContractDTO> getContracts() {
        List<ContractDTO> list = service.getContracts();
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
    public ContractDTO getContract(@PathVariable("contrId") Integer contrId) {
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
    boolean addContract(@RequestBody @Valid ContractDTO contrForm) {
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
    boolean updateContract(@RequestBody @Valid ContractDTO contrForm) {

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
