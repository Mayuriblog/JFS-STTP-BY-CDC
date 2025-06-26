package DAY4_SESSION.PayementManagement;

public class Client {
    public static void main(String args[])
    {
        PaymentService ps=new PaymentService();
        ps.addPaymentMethod("MAYURI_DEBIT_CARD",
                new DebitCard("1234","MAYURI_DEBIT_CARD"));
        ps.addPaymentMethod("MAYURI_CREDIT_CARD",
                new CreditCard("5678","MAYURI_CREDIT_CARD"));
        ps.addPaymentMethod("Mayuri@xyz",new UPI("Mayuri@xyz"));
        ps.addPaymentMethod("Mayuri@abc",new Wallet("Mayuri@abc"));
        ps.makePayment("MAYURI_DEBIT_CARD");
        ps.makePayment("MAYURI_CREDIT_CARD");
        ps.makePayment("Mayuri@xyz");
        ps.makePayment("Mayuri@abc");
    }
}
