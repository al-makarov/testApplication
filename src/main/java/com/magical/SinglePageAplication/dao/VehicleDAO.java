package com.magical.SinglePageAplication.dao;

import com.magical.SinglePageAplication.model.Vehicle;

import java.util.List;

public interface VehicleDAO {
    Vehicle getVehicle(Integer vehicleId);
    Vehicle getVehicle(String vehId);
    List<Vehicle> getVehicles();
}
