package fr.ubordeaux.ao;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class TestTransaction {
    private final int _amount = 10;
    private final String _title = "Try";

    @Test(expected=IllegalArgumentException.class)
    public void testTransactionNullAmount() {
	assertNull (new Transaction("Fail", 0));
    }

    @Test
    public void testTransactionDate() {
	Date date = new Date();
	Transaction transaction = new Transaction(_title, _amount);
	assertEquals(date, transaction.getDate());
    }

    @Test
    public void testTransactionAmount() {
	Transaction transaction = new Transaction(_title, _amount);
	assertEquals(_amount, transaction.getAmount());
    }

    @Test
    public void testTransactionTitle() {
	Transaction transaction = new Transaction(_title, _amount);
	assertEquals(_title, transaction.getTitle());
    }
    
}
