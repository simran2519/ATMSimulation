package Weekly_Assignment.ATM;

abstract public class Bank
{
   private String atmNumber;
   private String name;
   private String atmPin;
   double balance;
   Bank(String atmNumber,String name,String atmPin,double balance)
   {
       this.atmNumber=atmNumber;
       this.name=name;
       this.atmPin=atmPin;
       this.balance=balance;
   }
   //Getters
    public String getName() {
        return name;
    }
    public String getAtmNumber() {
        return atmNumber;
    }
    public String getAtmPin() {
        return atmPin;
    }
    public double getBalance() {
        return balance;
    }
    abstract public void displayDetails();
}

