//Bank Account of Users are added manually in the "Simulation" Class
package Weekly_Assignment.ATM;
import java.util.Scanner;

import static Weekly_Assignment.ATM.ATMException.*;

public class ATMSimulationSystem
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        //Bank Account of Users are added manually in the Simulation Class
        Simulation sim = new Simulation();
        sim.addPNB();
        sim.addSBI();
        sim.addHDFC();
        System.out.println("Welcome to the ATM");
        int a=getBank();
        System.out.println("Enter your ATM no.");
        String atmNumber=sc.next();
        System.out.println("Enter your Pin");
        String atmPin=sc.next();
        while(true)
                {
                    System.out.println("Select the operation what do you want to perform");
                    System.out.println("0. Exit ");
                    System.out.println("1. Cash Deposit");
                    System.out.println("2. Cash Withdrawal");
                    System.out.println("3. Balance Enquiry");
                    System.out.println("4. Money Transfer");
                    int n=sc.nextInt();
                    if(n==0)
                    {
                        break;
                    }
                    switch (n)
                    {
                        case 1:
                        {
                            //Bank Account of Users are added manually in the "Simulation" Class
                            try
                            {
                                sim.deposit(atmNumber,atmPin);
                            }
                            catch (InvalidATMNumberException | InsufficientFundsException1 e)
                            {
                                System.out.println(e);
                            }
                            catch (ATMException e)
                            {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 2:
                        {
                           try
                           {
                               sim.withdrawal(atmNumber,atmPin);
                           }
                           catch (InvalidATMNumberException | InsufficientFundsException1 | InvalidATMPinException e)
                           {
                               System.out.println(e);
                           }
                           catch (ATMException e)
                           {
                               e.printStackTrace();
                           }
                            break;
                        }
                        case 3:
                        {
                            try
                            {
                                sim.checkBalance(atmNumber,atmPin);
                            }
                            catch (ATMException.InvalidATMPinException|ATMException.InvalidATMNumberException | ATMException.InsufficientFundsException1 e)
                            {
                                System.out.println(e);
                            }
                            catch (ATMException e)
                            {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 4:
                        {
                            try {
                                sim.transferMoney(atmNumber,atmPin);
                            }
                            catch (ATMException.InvalidATMNumberException | ATMException.InsufficientFundsException1 | ATMException.InvalidATMPinException e)

                            {
                                System.out.println(e);
                            }
                            catch (ATMException e)
                            {
                                e.printStackTrace();
                            }
                            break;
                        }
                        default:
                            System.out.println("You have entered invalid option");
                    }
                }
    }
    public static int getBank()
    {
        Simulation obj = new Simulation();
        System.out.println("In which bank your Bank Account is created");
        System.out.println("1. PNB");
        System.out.println("2. SBI");
        System.out.println("3. HDFC");
        int a=sc.nextInt();
         obj.setX(a);
         return a;
    }

}
