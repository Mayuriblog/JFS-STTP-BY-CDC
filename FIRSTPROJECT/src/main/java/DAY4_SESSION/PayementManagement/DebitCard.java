package DAY4_SESSION.PayementManagement;

public class DebitCard extends Card{
    public DebitCard(String cardNo,String userName)
    {
        super(cardNo,userName);
    }
    @Override
    public void pay()
    {
        System.out.println("Making Payment via Debit card  "+getUserName());
    }
}
