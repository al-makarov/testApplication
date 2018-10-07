package com.magical.SinglePageAplication.model;


import javax.validation.constraints.*;
import java.util.Date;

/**
 * Сущность формы данных договора Т1 (для взаимодействия с фронтэндом)
 */
public class ContractT1Form {
    private int id;
    @NotNull
    @Size(min=3, max=3, message="Длина поля 'Серия' должна составлять 3 символа")
    @Pattern(regexp = "^[А-Яа-я]+$", message = "Только русские буквы")
    private String series;
    @NotNull
    @Max(8)
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z0-9]+$", message = "Недопустимые символы")
    private String number;
    @NotNull
    private int typeContractId;

    @NotNull
    @PastOrPresent
    private Date dateSignature;
    @NotNull
    private Date dateStart;
    private Date dateEnd;
    @NotNull
    private float sumVAT;
    @NotNull
    private float sumWithVAT;
    @NotNull
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
