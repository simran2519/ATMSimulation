package Weekly_Assignment.ATM;

public class PNB extends Bank
{
    PNB(String atmNumber,String name,String atmPin,double balance)
    {
        super(atmNumber,name,atmPin,balance);
    }

    @Override
    public void displayDetails()
    {
        toString();
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }
    public String toString()
    {
        return "[ATM Number: "+getAtmNumber()+"ATM Name: "+getName()+" Total Balance: "+getBalance()+"]";
    }
}
