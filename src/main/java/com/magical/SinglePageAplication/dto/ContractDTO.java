package com.magical.SinglePageAplication.dto;

import javax.validation.constraints.*;
import java.util.Date;

public class ContractDTO {
    private int id;
    @NotNull
    @Size(min = 3, max = 3, message = "Длина поля 'Серия' должна составлять 3 символа")
    @Pattern(regexp = "^[А-Яа-я]+$", message = "Только русские буквы")
    private String series;
    @NotNull
    @Max(8)
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z0-9]+$", message = "Недопустимые символы")
    private String number;
    @NotNull
    private int typeContractId;
    private String contractTypeName;
    @NotNull
    @PastOrPresent
    private Date dateSignature;
    @NotNull
    private Date dateStart;
    private Date dateEnd;
    @NotNull
    private double sumVAT;
    @NotNull
    private double sumWithVAT;
    @NotNull
    private int vehicleId;
    private String vehicleName;
    private String comment;
    private double sumWithoutVAT;
    private int rateVAT;
    private boolean conformMinSum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getTypeContractId() {
        return typeContractId;
    }

    public void setTypeContractId(int typeContract) {
        this.typeContractId = typeContract;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }


    public double getSumVAT() {
        return sumVAT;
    }

    public void setSumVAT(double sumVAT) {
        this.sumVAT = sumVAT;
    }

    public double getSumWithVAT() {
        return sumWithVAT;
    }

    public void setSumWithVAT(double sumWithVAT) {
        this.sumWithVAT = sumWithVAT;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getSumWithoutVAT() {
        return sumWithoutVAT;
    }

    public void setSumWithoutVAT(double sumWithoutVAT) {
        this.sumWithoutVAT = sumWithoutVAT;
    }

    public int getRateVAT() {
        return rateVAT;
    }

    public void setRateVAT(int rateVAT) {
        this.rateVAT = rateVAT;
    }

    public boolean isConformMinSum() {
        return conformMinSum;
    }

    public void setConformMinSum(boolean conformMinSum) {
        this.conformMinSum = conformMinSum;
    }

    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }


}
