package com.magical.SinglePageAplication.service;

import com.magical.SinglePageAplication.dao.VehicleDAO;
import com.magical.SinglePageAplication.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleService {
    @Autowired
    private VehicleDAO vehicleDAO;

    /**
     * Функция получения списка транспортных средств {@link Vehicle}
     *
     * @return
     */
    public List<Vehicle> getVehicles() {
        return vehicleDAO.getVehicles();
    }

}
