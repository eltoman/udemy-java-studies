package application;

import com.sun.javaws.exceptions.InvalidArgumentException;
import model.entities.Contract;
import model.entities.Installment;
import model.services.PaypalService;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.println("Enter contract data");
            System.out.print("Number: ");
            Integer contractNumber = sc.nextInt();
            System.out.println("vamo nos vamo nos");
            System.out.print("Date (dd/MM/yyyy): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("contract value: ");
            Double contractValue = sc.nextDouble();
            System.out.print("Enter number of installments: ");
            Integer numberOfInstallments = sc.nextInt();

            Contract contract = new Contract(contractNumber, contractDate, contractValue, numberOfInstallments, new PaypalService());

            System.out.println("Installments: ");
            contract.calculateInstallments();
            for (Installment installment : contract.getInstallments()) {
                System.out.println(sdf.format(installment.getDueDate())  + " - " + installment.getAmount());
            }

        }catch (InvalidParameterException e){
            System.out.println(e);
        }finally {
            if (sc != null)
                sc.close();
        }

    }
}
