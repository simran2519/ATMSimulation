package Weekly_Assignment.ATM;

public class SBI extends Bank
{
    SBI(String atmNumber,String name,String atmPin,double balance)
    {
        super(atmNumber,name,atmPin,balance);
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }

    @Override
   public void displayDetails()
    {
        toString();
    }
    public String toString()
    {
        return "[ATM Number: "+getAtmNumber()+"ATM Name: "+getName()+" Total Balance: "+getBalance()+"]";
    }
}
