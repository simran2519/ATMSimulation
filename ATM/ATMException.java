package Weekly_Assignment.ATM;

import day14.BankException;

public class ATMException extends Exception
{
    //To handle the insufficient funds
    public static class InsufficientFundsException1 extends ATMException
    {
       public InsufficientFundsException1()
       {
           System.out.println("The funds are not sufficient");
       }
    }
    //To handle if the user has entered invalid ATM Number
    public static class InvalidATMNumberException extends ATMException
    {
         public InvalidATMNumberException()
         {
             System.out.println("The Atm Number is not Valid");
         }
    }
    //To  handle Invalid ATM pin
    public static class InvalidATMPinException extends ATMException
    {
        public InvalidATMPinException()
        {
            System.out.println("The atm Pin is not valid");
        }
    }
}
