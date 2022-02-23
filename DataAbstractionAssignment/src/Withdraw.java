import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    // Requires: does not require anything
    // Modifies: does not modify anything
    // Effects: returns a formatted String with amount, date and account
    public String toString(){
        //your code here - done
        return "Withdraw of: $"+this.amount+" Date: "+this.date+" from account: "+this.account;

    }
}
