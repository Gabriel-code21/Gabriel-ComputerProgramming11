import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate; // Not used in assignment
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor - done
        this.name = "Not Specified";
        this.accountNumber = 0;
        this.checkBalance = 0;
        this.savingBalance = 0;
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here - done
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance += checkDeposit;
        this.savingBalance += savingDeposit;
    }

    // Requires: amount >= 0, a valid date class, account == "Checking" or account == "Saving"
    // Modifies: this, deposits
    // Effects: adds a new Deposit to deposits and increases either checkBalance or savingBalance
    public double deposit(double amt, Date date, String account){
        //your code here - done
        if (!(amt <= 0)) {
            deposits.add((new Deposit(amt, date, account)));
            if (account.equals(CHECKING)) {
                checkBalance += amt;
            } else if (account.equals(SAVING)) {
                savingBalance += amt;
            }
        }
        return 0;
    }

    // Requires: amount >= 0, a valid date class, account == "Checking" or account == "Saving"
    // Modifies: this, withdraws
    // Effects: adds a new Withdraw to withdraws and decreases either checkBalance or savingBalance
    public double withdraw(double amt, Date date, String account){
        //your code here - done
        if (!(amt <= 0)) {
            if (checkOverdraft(amt, account)) {
                withdraws.add(new Withdraw(amt,date,account));
                if (account.equals(CHECKING)) {
                    checkBalance -= amt;
                } else if (account.equals(SAVING)) {
                    savingBalance -= amt;
                }
            } else {
                System.out.println("Withdrawing too much. Request Cancelled! No record added.");
            }
        }
        return 0;
    }
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)) {
            if ((checkBalance - amt) > OVERDRAFT) {
                return true;
            }
        } else if (account.equals(SAVING)) {
            if ((savingBalance - amt) > OVERDRAFT) {
                return true;
            }
        }
        return false;
    }

    //do not modify 
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
}
