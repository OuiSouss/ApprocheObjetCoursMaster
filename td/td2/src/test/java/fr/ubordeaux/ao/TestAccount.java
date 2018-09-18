package fr.ubordeaux.ao;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.UUID;
import java.util.Date;
import java.util.Set;

public class TestAccount {
    private final UUID _uuid = UUID.randomUUID();
    private final int _numberTransaction = 4;

    @Test
    public void TestAccountBalanceAdd() {
	Account account = new Account(_uuid, "Account");
	Transaction transaction = new Transaction("Trans", 1000);
	assertNotNull(account);
	account.addTransaction(transaction);
	assertEquals(1000, account.getBalance());
    }

    @Test
    public void TestAccountBalanceDel() {
	Account account = new Account(_uuid, "Account");
	Transaction transaction = new Transaction("Trans", 1000);
	assertNotNull(account);
	account.addTransaction(transaction);
	account.delTransaction(transaction);
	assertEquals(0, account.getBalance());
    }

    @Test
    public void TestAccountGetTransaction() {
	Account account = new Account(_uuid, "Account");
	Transaction t = new Transaction("Trans", 1000);
	Transaction r = new Transaction("Trans", 5000);
	Transaction a = new Transaction("Trans", 10000);
	Transaction n = new Transaction("Trans", 15000);
	Date date = t.getDate();
	account.addTransaction(t);
	account.addTransaction(r);
	account.addTransaction(a);
	account.addTransaction(n);
	Set<Transaction> transactionSet = account.getTransactionSince(date);
	assertNotNull(transactionSet);
	assertEquals(_numberTransaction, transactionSet.size());
    }
}
