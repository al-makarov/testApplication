package com.magical.SinglePageAplication.model;
import java.util.Date;

/**
 * Сущность договора T1
 */
public class ContractT1 {
    private int id;
    private String series;
    private String number;
    private ContractType typeContract;
    private Vehicle vehicle;
    private Date dateSignature;
    private Date dateStart;
    private Date dateEnd;
    private double sumVAT;
    private double sumWithVAT;
    /* private double sumWithoutVAT;
     private int rateVAT;
     private boolean conformMinSum;*/
    private String comment;

    public ContractT1() {

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

    public ContractType getContractType() {
        return typeContract;
    }

    public void setContractType(ContractType typeContract) {
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
/*    public double getSumWithoutVAT() {
        return sumWithoutVAT;
    }*/
   /* public void setSumWithoutVAT(double sumWithoutVAT) {
        this.sumWithoutVAT = sumWithoutVAT;
    }*/
    /*public int getRateVAT() {
        return rateVAT;
    }*/
    /*public void setRateVAT(int rateVAT) {
        this.rateVAT = rateVAT;
    }*/
    /*public boolean isConformMinSum() {
        return conformMinSum;
    }*/
    /*public void setConformMinSum(boolean conformMinSum) {
        this.conformMinSum = conformMinSum;
    }*/


}
