package application.services;

import application.services.interfaces.OnlinePaymentService;

public class VisaService implements OnlinePaymentService {

    private static final double FEE_PERCENTAGE = 0.05;
    private static final double MONTHLY_INTEREST = 0.00;

    @Override
    public double paymentFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * MONTHLY_INTEREST * months;
    }
}
