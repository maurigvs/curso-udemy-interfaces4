import application.entities.Contract;
import application.entities.Installment;
import application.services.ContractService;
import application.services.VisaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();

        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.nextLine());

        System.out.print("Contract value: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue, new ArrayList<Installment>());

        System.out.println();

        System.out.print("Enter number of installments: ");
        Integer months = sc.nextInt();

        ContractService service = new ContractService(new VisaService());
        service.processContract(contract, months);

        for(Installment inst : contract.getInstallments()){
            System.out.println(inst);
        }

        sc.close();
    }
}