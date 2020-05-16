package model.services;

import model.entities.Contract;
import model.entities.Installment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PaypalService implements PaymentService {

    public List<Installment> calculateInstallments(Contract contract){
        List<Installment> installments = new ArrayList<>();
        Double installmentBaseValue = contract.getTotalValue() / contract.getNumberOfInstallments();
        for (int i = 0; i < contract.getNumberOfInstallments(); i++) {
            Integer installmentNumber = i+1;
            installments.add(calculateInstallment(installmentBaseValue, installmentNumber, contract.getDate()));
        }
        return installments;
    }

    private Installment calculateInstallment(Double installmentBaseValue, Integer installmentNumber, Date date){
        Double amount = 0.0;
        Date dueDate;

        Calendar calc = Calendar.getInstance();
        calc.setTime(date);
        calc.add(Calendar.MONTH, installmentNumber);
        dueDate = calc.getTime();

        Double fee = installmentBaseValue * 0.01;
        fee *= installmentNumber;
        fee += ((fee+installmentBaseValue) * 0.02);
        amount = installmentBaseValue + fee;

        return new Installment(dueDate, amount);
    }

}
