package Radhe;
import java.util.Scanner;

class BankAccount 
{
    private double balance;  
    private String lastTransaction;
    private String Pin;
    
    public BankAccount(double initialBalance, String initialPin)
    {
        this.balance = initialBalance;
        this.Pin = initialPin;
        this.lastTransaction = "None ";
    }
    public String getPin()
    {
        return this.Pin;
    }

    public void setPin(String newPin)
    {
        this.Pin = newPin;
        return;
    }

    public String getLastTransaction()
    {
        return this.lastTransaction;
    }

public void runAtm()
{
    Scanner s = new Scanner(System.in);
    int choice;
    boolean authenticated=false;
    System.out.println("Enter your Pin:");
    String enteredPin=s.nextLine();
    
    if(enteredPin.equals(Pin)) 
    {
       authenticated=true; 
    }
    else 
    {
      System.out.println("Incorrect Pin.Exiting....");
      return;
    }
}

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount>0)
        {
            balance += amount;
            System.out.println("Deposit successful. New balance: rupees" + balance);
        } 
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount)
    {
        if (amount>0)
        {
            if (amount <= balance) 
            {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: rupees" + balance);
                return true;
            }
            else 
            {
                System.out.println("Insufficient funds for withdrawal. Current balance: rupees" + balance);
            }
        }
        else
        {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }
        return false;
    }
}

class Atm
{
    private BankAccount bankAccount;

    public Atm(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

    public void displayMenu()
    {
        System.out.println(" Atm optionmenu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin ");
        System.out.println("5. viewLastTransaction ");
        System.out.println("6. Exit");
    }

    public void run() 
    {
        Scanner s = new Scanner(System.in);

        while (true)
        {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Current balance: rupees" + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: rupees");
                    double depositAmount = s.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: rupees");
                    double withdrawalAmount = s.nextDouble();
                    boolean withdrawSuccess = bankAccount.withdraw(withdrawalAmount);
                    if (withdrawSuccess) 
                    {
                        System.out.println("Withdrawal successful.");
                    }
                    break;
                    case 4:
                    System.out.print("Enter the New Pin: ");
                    String pin=s.next();
                    String oldPin=bankAccount.getPin();
                    bankAccount.setPin(pin);
                    System.out.println("Pin set from:"+oldPin+"To"+bankAccount.getPin());
                    break;
                    case 5:
                    System.out.print(" LastTransaction:");
                    System.out.print(bankAccount.getLastTransaction());

                    break;
                case 6:
                    System.out.println("Thank you for using the ATM.Good luck for next experience!" );
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class ATMInterface
{
    public static void main(String[] args)
    {
        BankAccount userAccount = new BankAccount(80000.0,"425405"); // Initial balance is rupees80000.0
        Atm atm = new Atm(userAccount);
        atm.run();
    }
}




