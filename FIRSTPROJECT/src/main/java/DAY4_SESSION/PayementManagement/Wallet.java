package DAY4_SESSION.PayementManagement;

public class Wallet implements  PaymentMethod{
    String walletId;

    public Wallet(String walletId) {
        this.walletId = walletId;
    }

    public String getWalletId() {
        return walletId;
    }

    @Override
    public void pay()
    {
        System.out.println("Making Payment via Wallet  "+getWalletId());
    }
}
