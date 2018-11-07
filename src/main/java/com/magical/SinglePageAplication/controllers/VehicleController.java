package com.magical.SinglePageAplication.controllers;


import com.magical.SinglePageAplication.model.Vehicle;
import com.magical.SinglePageAplication.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService service;

    /**
     * Запрос на получение списка транспортных средств
     *
     * @return
     */
    @RequestMapping(value = "/vehicles",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Vehicle> getVehicles() {
        List<Vehicle> list = service.getVehicles();
        return list;
    }
}
