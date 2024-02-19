package Weekly_Assignment.ATM;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation
{
    Scanner sc = new Scanner(System.in);
    List<PNB> pnbList;
    List<SBI>sbiList;
    List<HDFC>hdfcList;
    Simulation()
    {
        pnbList=new ArrayList<>();
        sbiList=new ArrayList<>();
        hdfcList=new ArrayList<>();
    }
    //Add Users in Different Banks
    public void addHDFC()
    {
        HDFC hdfc1=new HDFC("234167892345","Simran","1234",3450.12);
        HDFC hdfc2=new HDFC("875206177734","Harman","7753",45000);
        HDFC hdfc3=new HDFC("678784536535","Meena","1914",30000);
        hdfcList.add(hdfc1);
        hdfcList.add(hdfc2);
        hdfcList.add(hdfc3);
    }
     public void addPNB()
     {
         PNB pnb1=new PNB("878677645378","Sakshi","2231",86875);
         PNB pnb2=new PNB("465456342425","Kajal","7656",5453);
         PNB pnb3=new PNB("132323908987","Jaskaran","3232",0);
         pnbList.add(pnb1);
         pnbList.add(pnb2);
         pnbList.add(pnb3);
     }
     public void addSBI()
     {
         SBI sbi1=new SBI("764523973462","Jora","3579",56479);
         SBI sbi2=new SBI("657636242906","Vidya","8767",878786);
         SBI sbi3=new SBI("689787687564","Tamana","1278",50000);
         sbiList.add(sbi1);
         sbiList.add(sbi2);
         sbiList.add(sbi3);
     }
     //To give input from user that in which bank the user has account
     static int x;
     public void setX(int x) {
        this.x = x;
         System.out.println(x);
    }
    //Deposit
    public void deposit(String atmNumber,String atmPin)  throws ATMException
    {
        if(x==1) {
            System.out.println("HIi");
            PNB accountwhereDeposit = null;
            for (PNB pnb : pnbList) {
                System.out.println(pnb.getBalance());
                if (atmNumber.equals(pnb.getAtmNumber()) && atmPin.equals(pnb.getAtmPin())) {
                    accountwhereDeposit = pnb;
                    break;
                }
                else if(!atmNumber.equals(pnb.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(pnb.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the amount you want to deposit in PNB");
            double amount=sc.nextDouble();
            System.out.println(accountwhereDeposit.getBalance());
            accountwhereDeposit.setBalance(accountwhereDeposit.getBalance()+amount);
            System.out.println("Amount is deposited");
            System.out.println("Your current Balance is :"+ accountwhereDeposit.getBalance());
        }
      else if(x==2) {
            SBI accountwhereDeposit = null;
            for (SBI sbi : sbiList) {
                if (atmNumber.equals(sbi.getAtmNumber()) && atmPin.equals(sbi.getAtmPin())) {
                    accountwhereDeposit = sbi;
                    break;
                }       else if(!atmNumber.equals(sbi.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(sbi.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the amount you want to deposit in SBI");
            double amount=sc.nextDouble();
            accountwhereDeposit.setBalance(accountwhereDeposit.getBalance()+amount);
            System.out.println("Amount is deposited");
            System.out.println("Your current Balance is :"+ accountwhereDeposit.getBalance());
        }
       else if(x==3) {
            HDFC accountwhereDeposit = null;
            for (HDFC hdfc : hdfcList) {
                if (atmNumber.equals(hdfc.getAtmNumber()) && atmPin.equals(hdfc.getAtmPin())) {
                    accountwhereDeposit = hdfc;
                    break;
                }
                else if(!atmNumber.equals(hdfc.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(hdfc.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the amount you want to deposit in HDFC account");
            double amount=sc.nextDouble();
            accountwhereDeposit.setBalance(accountwhereDeposit.getBalance()+amount);
            System.out.println("Amount is deposited");
            System.out.println("Your current Balance is :"+ accountwhereDeposit.getBalance());
        }
    }
    //Withdrawal
    public void withdrawal(String atmNumber,String atmPin) throws ATMException
    {

        if(x==1) {
            PNB accountwhereWithd = null;
            for (PNB pnb : pnbList) {
                if (atmNumber.equals(pnb.getAtmNumber()) && atmPin.equals(pnb.getAtmPin())) {
                    accountwhereWithd = pnb;
                    break;
                }
                else if(!atmNumber.equals(pnb.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(pnb.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the amount you want to withdrwal in PNB");
            double amount=sc.nextDouble();
            if(amount>accountwhereWithd.getBalance())
            {
                throw new ATMException.InsufficientFundsException1();
            }
            accountwhereWithd.setBalance(accountwhereWithd.getBalance()-amount);
            System.out.println("Amount is withdrwal");
            System.out.println("Your current Balance is :"+ accountwhereWithd.getBalance());
        }
        else if(x==2) {
            SBI accountwhereWithd = null;
            for (SBI sbi : sbiList) {
                if (atmNumber.equals(sbi.getAtmNumber()) && atmPin.equals(sbi.getAtmPin())) {
                    accountwhereWithd = sbi;
                    break;
                }
                else if(!atmNumber.equals(sbi.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(sbi.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the amount you want to withdrawal in SBI");
            double amount=sc.nextDouble();
            double newamount=accountwhereWithd.getBalance()-amount;
            if(newamount<0)
            {
                throw new ATMException.InsufficientFundsException1();
            }
            else
            {
                accountwhereWithd.setBalance(accountwhereWithd.getBalance()-amount);
                System.out.println("Amount is withdrawl");
                System.out.println("Your current Balance is :"+ accountwhereWithd.getBalance());
            }
        }
        else if(x==3) {
            HDFC accountwhereWithd = null;
            for (HDFC hdfc : hdfcList) {
                if (atmNumber.equals(hdfc.getAtmNumber()) && atmPin.equals(hdfc.getAtmPin())) {
                    accountwhereWithd = hdfc;
                    break;
                } else {
                    System.out.println("Account does not exists");
                }
            }
            System.out.println("Enter the amount you want to withdrawal in HDFC account");
            double amount=sc.nextDouble();
            accountwhereWithd.setBalance(accountwhereWithd.getBalance()-amount);
            System.out.println("Amount is withdrawl");
            System.out.println("Your current Balance is :"+ accountwhereWithd.getBalance());
        }
    }

    //Check Balance
    public void checkBalance(String atmNumber,String atmPin) throws ATMException
    {
        if(x==1)
        {
            PNB accounttoCheck = null;
            for (PNB pnb : pnbList) {
                if (atmNumber.equals(pnb.getAtmNumber()) && atmPin.equals(pnb.getAtmPin())) {
                    accounttoCheck = pnb;
                    break;
                }
                else if(!atmNumber.equals(pnb.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(pnb.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Total Balance is:"+ accounttoCheck.getBalance());
        }
        else if(x==2)
        {
            SBI accounttoCheck = null;
            for (SBI sbi : sbiList) {
                if (atmNumber.equals(sbi.getAtmNumber()) && atmPin.equals(sbi.getAtmPin())) {
                    accounttoCheck = sbi;
                    break;
                }
                else if(!atmNumber.equals(sbi.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(sbi.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Total Balance is:"+ accounttoCheck.getBalance());
        }
        else if(x==3)
        {
            HDFC accounttoCheck = null;
            for (HDFC hdfc : hdfcList) {
                if (atmNumber.equals(hdfc.getAtmNumber()) && atmPin.equals(hdfc.getAtmPin())) {
                    accounttoCheck = hdfc;
                    break;
                }   else if(!atmNumber.equals(hdfc.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(hdfc.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Total Balance is:"+ accounttoCheck.getBalance());
        }
    }

    // Transfer money
    public void transferMoney(String atmNumber,String atmPin) throws ATMException
    {
        if(x==1)
        {
            PNB accounttoCheck = null;
            for (PNB pnb : pnbList) {
                if (atmNumber.equals(pnb.getAtmNumber()) && atmPin.equals(pnb.getAtmPin())) {
                    accounttoCheck = pnb;
                    break;
                }
                else if(!atmNumber.equals(pnb.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(pnb.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the name of receicver's bank ");
            System.out.println("1. PNB");
            System.out.println("2. SBI");
            System.out.println("3. HDFC");
            int n=sc.nextInt();
            if(n==x)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                PNB accounttoReceive = null;
                for (PNB pnb : pnbList) {
                    if (atmNumber1.equals(pnb.getAtmNumber()) && atmPin1.equals(pnb.getAtmPin())) {
                        accounttoReceive = pnb;
                        break;
                    }
                    else if(!atmNumber.equals(pnb.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(pnb.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                accounttoCheck.setBalance(accounttoCheck.getBalance()-amount);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }
            else if(n==2)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                SBI accounttoReceive = null;
                for (SBI sbi: sbiList) {
                    if (atmNumber1.equals(sbi.getAtmNumber()) && atmPin1.equals(sbi.getAtmPin())) {
                        accounttoReceive = sbi;
                        break;
                    }
                    else if(!atmNumber.equals(sbi.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(sbi.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                double after=accounttoCheck.getBalance()*(0.10);
                accounttoCheck.setBalance(accounttoCheck.getBalance()-after);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }
            else if(n==3)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                HDFC accounttoReceive = null;
                for (HDFC hdfc : hdfcList) {
                    if (atmNumber1.equals(hdfc.getAtmNumber()) && atmPin1.equals(hdfc.getAtmPin())) {
                        accounttoReceive = hdfc;
                        break;
                    }
                    else if(!atmNumber.equals(hdfc.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(hdfc.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                double after=accounttoCheck.getBalance()*(0.10);
                accounttoCheck.setBalance(accounttoCheck.getBalance()-after);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }

        }
        else if(x==2)
        {
            SBI accounttoCheck = null;
            for (SBI sbi : sbiList) {
                if (atmNumber.equals(sbi.getAtmNumber()) && atmPin.equals(sbi.getAtmPin())) {
                    accounttoCheck = sbi;
                    break;
                }
                else if(!atmNumber.equals(sbi.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(sbi.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the name of receicver's bank ");
            System.out.println("1. PNB");
            System.out.println("2. SBI");
            System.out.println("3. HDFC");
            int n=sc.nextInt();
            if(n==x)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                SBI accounttoReceive = null;
                for (SBI sbi : sbiList) {
                    if (atmNumber1.equals(sbi.getAtmNumber()) && atmPin1.equals(sbi.getAtmPin())) {
                        accounttoReceive = sbi;
                        break;
                    }
                    else if(!atmNumber.equals(sbi.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(sbi.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                accounttoCheck.setBalance(accounttoCheck.getBalance()-amount);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }
            else if(n==1)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                PNB accounttoReceive = null;
                for (PNB pnb: pnbList) {
                    if (atmNumber1.equals(pnb.getAtmNumber()) && atmPin1.equals(pnb.getAtmPin())) {
                        accounttoReceive = pnb;
                        break;
                    }
                    else if(!atmNumber.equals(pnb.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(pnb.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                double after=accounttoCheck.getBalance()*(0.10);
                accounttoCheck.setBalance(accounttoCheck.getBalance()-after);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }
            else if(n==3)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                HDFC accounttoReceive = null;
                for (HDFC hdfc : hdfcList) {
                    if (atmNumber1.equals(hdfc.getAtmNumber()) && atmPin1.equals(hdfc.getAtmPin())) {
                        accounttoReceive = hdfc;
                        break;
                    }
                    else if(!atmNumber.equals(hdfc.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(hdfc.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                double after=accounttoCheck.getBalance()*(0.10);
                accounttoCheck.setBalance(accounttoCheck.getBalance()-after);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }

        }
        else if(x==3)
        {
            HDFC accounttoCheck = null;
            for (HDFC hdfc : hdfcList) {
                if (atmNumber.equals(hdfc.getAtmNumber()) && atmPin.equals(hdfc.getAtmPin())) {
                    accounttoCheck = hdfc;
                    break;
                }
                else if(!atmNumber.equals(hdfc.getAtmNumber()) )
                {
                    throw new ATMException.InvalidATMNumberException();
                }
                else if(!atmPin.equals(hdfc.getAtmPin()))
                {
                    throw new ATMException.InvalidATMPinException();
                }
            }
            System.out.println("Enter the name of receicver's bank ");
            System.out.println("1. PNB");
            System.out.println("2. SBI");
            System.out.println("3. HDFC");
            int n=sc.nextInt();
            if(n==x)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                HDFC accounttoReceive = null;
                for (HDFC hdfc : hdfcList) {
                    if (atmNumber1.equals(hdfc.getAtmNumber()) && atmPin1.equals(hdfc.getAtmPin())) {
                        accounttoReceive = hdfc;
                        break;
                    }
                    else if(!atmNumber.equals(hdfc.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(hdfc.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                accounttoCheck.setBalance(accounttoCheck.getBalance()-amount);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }
            else if(n==2)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                SBI accounttoReceive = null;
                for (SBI sbi: sbiList) {
                    if (atmNumber1.equals(sbi.getAtmNumber()) && atmPin1.equals(sbi.getAtmPin())) {
                        accounttoReceive = sbi;
                        break;
                    }
                    else if(!atmNumber.equals(sbi.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(sbi.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                double after=accounttoCheck.getBalance()*(0.10);
                accounttoCheck.setBalance(accounttoCheck.getBalance()-after);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }
            else if(n==1)
            {
                System.out.println("Enter the atm Number of account where to transfer money");
                String atmNumber1=sc.next();
                System.out.println("Enter the atm Pin of account where to transfer money");
                String atmPin1=sc.next();
                PNB accounttoReceive = null;
                for (PNB pnb : pnbList) {
                    if (atmNumber1.equals(pnb.getAtmNumber()) && atmPin1.equals(pnb.getAtmPin())) {
                        accounttoReceive = pnb;
                        break;
                    }
                    else if(!atmNumber.equals(pnb.getAtmNumber()) )
                    {
                        throw new ATMException.InvalidATMNumberException();
                    }
                    else if(!atmPin.equals(pnb.getAtmPin()))
                    {
                        throw new ATMException.InvalidATMPinException();
                    }
                }
                System.out.println("Enter how much amount to transfer");
                double amount =sc.nextDouble();
                double after=accounttoCheck.getBalance()*(0.10);
                accounttoCheck.setBalance(accounttoCheck.getBalance()-after);
                accounttoReceive.setBalance(accounttoReceive.getBalance()+amount);
                System.out.println("Amount has been transfered");
            }

        }

        }

    }
