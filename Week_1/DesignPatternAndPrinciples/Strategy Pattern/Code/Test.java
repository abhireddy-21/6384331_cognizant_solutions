public class Test {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        PaymentStrategy ccPayment = new CreditCardPayment("1234-5678-9012-3456", "Cognizant");
        context.setPaymentStrategy(ccPayment);
        context.executePayment(500.00);
        System.out.println();
        PaymentStrategy ppPayment = new PayPalPayment("cognizant@example.com");
        context.setPaymentStrategy(ppPayment);
        context.executePayment(750.00);
        System.out.println();
    }
}
