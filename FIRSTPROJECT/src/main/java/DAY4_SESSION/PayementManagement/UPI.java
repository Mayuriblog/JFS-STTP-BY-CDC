package DAY4_SESSION.PayementManagement;

public class UPI implements PaymentMethod{
    String upiId;
    public UPI(String upiId)
    {
        this.upiId=upiId;
    }
    public String getUpiId() {
        return upiId;
    }
    @Override
    public void pay()
    {
        System.out.println("Making Payment via UPI "+getUpiId());
    }
}
