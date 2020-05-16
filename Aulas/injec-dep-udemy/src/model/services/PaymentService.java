package model.services;

import model.entities.Contract;
import model.entities.Installment;
import java.util.List;

public interface PaymentService {

    public List<Installment> calculateInstallments(Contract contract);
}
