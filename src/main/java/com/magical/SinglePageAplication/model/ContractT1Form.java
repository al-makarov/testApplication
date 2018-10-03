package com.magical.SinglePageAplication.model;


import java.util.Date;

public class ContractT1Form {
    private int id;
    private String series;
    private String number;
    private int typeContractId;
    private Date dateSignature;
    private Date dateStart;
    private Date dateEnd;

    private float sumVAT;
    private float sumWithVAT;

    private int vehicleId;
    private String comment;


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


    public float getSumVAT() {
        return sumVAT;
    }

    public void setSumVAT(float sumVAT) {
        this.sumVAT = sumVAT;
    }

    public float getSumWithVAT() {
        return sumWithVAT;
    }

    public void setSumWithVAT(float sumWithVAT) {
        this.sumWithVAT = sumWithVAT;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicle(int vehicle) {
        this.vehicleId = vehicle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
