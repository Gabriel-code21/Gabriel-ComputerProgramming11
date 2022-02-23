import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

public class CustomerTest {
    Customer c;
    Date d;

    @Before
    public void setup() {
        c = new Customer();
        d =  new Date();
    }

    @Test
    public void testDepositToString() {
        assertEquals("Deposit of: $100.0 Date: "+d+" into account: Saving", (new Deposit(100,d,c.SAVING)).toString());
    }

    @Test
    public void testWithdrawToString() {
        assertEquals("Withdraw of: $100.0 Date: "+d+" from account: Saving", (new Withdraw(100,d,c.SAVING)).toString());
    }

    @Test
    public void testDeposit() {
        double amount = 100;
        c.deposit(amount,new Date(),c.SAVING);
        assertEquals(amount, c.getSavingBalance(),0.1);
    }

    @Test
    public void testWithdraw() {
        double amount = 30;
        c.deposit(100, new Date(), c.SAVING);
        c.withdraw(amount, new Date(), c.SAVING);
        assertEquals(100-amount, c.getSavingBalance(),0.1);
    }
}
