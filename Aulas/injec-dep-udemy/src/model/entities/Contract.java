package model.entities;

import model.services.PaymentService;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

public class Contract {

    Integer number;
    Date date;
    Double totalValue;
    Integer numberOfInstallments;

    List<Installment> installments;

    PaymentService paymentService;

    public Contract(){
    }

    public Contract(Integer number, Date date, Double totalValue, Integer numberOfInstallments, PaymentService paymentService) throws InvalidParameterException {
        this.number = number;
        this.date = date;
        setTotalValue(totalValue);
        this.numberOfInstallments = numberOfInstallments;
        this.paymentService = paymentService;
    }

    public void calculateInstallments(){
        installments = paymentService.calculateInstallments(this);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) throws InvalidParameterException{
        if(totalValue > 0)
            this.totalValue = totalValue;
        else
            throw new InvalidParameterException("Valor Total do contrato precisa ser maior do que 0");
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public List<Installment> getInstallments() {
        return installments;
    }
}
