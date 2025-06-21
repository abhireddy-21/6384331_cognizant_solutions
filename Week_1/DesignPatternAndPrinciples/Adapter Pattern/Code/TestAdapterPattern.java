public class TestAdapterPattern {
    public static void main(String[] args) {
        
        PayPalGateway pg = new PayPalGateway();
        PaymentProcessor pp = new PayPalAdapter(pg);
        pp.processPayment(100);

        StripeGateway sg = new StripeGateway();
        PaymentProcessor sp = new StripeAdapter(sg);
        sp.processPayment(250);
    }
}
