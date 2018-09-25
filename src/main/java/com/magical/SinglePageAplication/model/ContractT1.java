package com.magical.SinglePageAplication.model;


import java.util.Date;
public class ContractT1 {

    private int id;
    private String series;
    private String number;
    private ContractType typeContract;
    private Date dateSignature;
    private Date dateStart;
    private Date dateEnd;
    private double sumWithoutVAT;
    private int rateVAT;
    private double sumVAT;
    private double sumWithVAT;
    private boolean conformMinSum;
    private Vehicle vehicle;
    private String comment;

    public ContractT1(int id, String series, String number, ContractType typeContract, Date dateSignature, Date dateStart, Date dateEnd, double sumWithVAT, double sumVAT,  Vehicle vehicle, String comment) {
        this.id = id;
        this.series = series;
        this.number = number;
        this.typeContract = typeContract;
        this.dateSignature = dateSignature;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.sumWithoutVAT = sumWithVAT - sumVAT;
        this.rateVAT = Math.round((float)(sumVAT / ((sumWithVAT - sumVAT) / 100.0)));
        this.sumVAT = sumVAT;
        this.sumWithVAT = sumWithVAT;
        this.conformMinSum = (sumWithVAT > 1000)? true : false;
        this.vehicle = vehicle;
        this.comment = comment;
    }

    public ContractT1(ContractT1Form contrForm) {
        this.id = contrForm.getId();
        this.series = contrForm.getSeries();
        this.number = contrForm.getNumber();
       // this.typeContract = contrForm.getTypeContract();
        this.dateSignature = contrForm.getDateSignature();
        this.dateStart = contrForm.getDateStart();
        this.dateEnd = contrForm.getDateEnd();
        this.sumWithoutVAT = contrForm.getSumWithVAT() - contrForm.getSumVAT();
        this.rateVAT = Math.round((float)( contrForm.getSumVAT()/ (contrForm.getSumWithVAT() - contrForm.getSumVAT()) / 100));
        this.sumVAT = contrForm.getSumVAT();
        this.sumWithVAT = contrForm.getSumWithVAT();
        this.conformMinSum = (contrForm.getSumWithVAT() > 1000)? true : false;
        //this.vehicle = contrForm.getVehicle();
        this.comment = contrForm.getComment();
    }
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

    public ContractType getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(ContractType typeContract) {
        this.typeContract = typeContract;
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

    public double getSumWithoutVAT() {
        return sumWithoutVAT;
    }

    public void setSumWithoutVAT(float sumWithoutVAT) {
        this.sumWithoutVAT = sumWithoutVAT;
    }

    public int getRateVAT() {
        return rateVAT;
    }

    public void setRateVAT(int rateVAT) {
        this.rateVAT = rateVAT;
    }

    public double getSumVAT() {
        return sumVAT;
    }

    public void setSumVAT(float sumVAT) {
        this.sumVAT = sumVAT;
    }

    public double getSumWithVAT() {
        return sumWithVAT;
    }

    public void setSumWithVAT(float sumWithVAT) {
        this.sumWithVAT = sumWithVAT;
    }

    public boolean isConformMinSum() {
        return conformMinSum;
    }

    public void setConformMinSum(boolean conformMinSum) {
        this.conformMinSum = conformMinSum;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
