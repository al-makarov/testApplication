package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.Vehicle;

import java.util.List;

/**
 * Интерфейс DAO транспортного средства
 */
public interface VehicleDAO {
    /**
     * Получение объекта транспортного средства по id
     * @param vehicleId - id транспортного средства
     * @return
     */
    Vehicle getVehicle(Integer vehicleId);

    /**
     * Получение списка объектов транспортных средств
     * @return
     */
    List<Vehicle> getVehicles();
}
