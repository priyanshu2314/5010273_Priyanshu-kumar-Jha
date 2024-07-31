public class Test {
    public static void main(String[] args) throws Exception {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("Priyanshu kumar Jha", "1111222233334444", "012", "07/29");
        context.setPaymentStrategy(creditCard);
        context.transaction(10000);

        PaymentStrategy payPal = new PayPalPayment("prj@TMSL", "complexHai123");
        context.setPaymentStrategy(payPal);
        context.transaction(300);
    }
}
