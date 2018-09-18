package fr.ubordeaux.ao;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.Date;
import java.util.UUID;

public class Account {
    private int balance;
    private UUID id;
    private String name;
    private Set<Transaction> transactions;

    public Account(UUID id, String name) {
        this.balance = 0;
        transactions = new HashSet<Transaction>();
	this.id = id;
	this.name = name;
    }

    public int getBalance() {
        return this.balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
	double amountTransaction = transaction.getAmount();
	this.balance += amountTransaction;
        //TODO_3
    }

    public void delTransaction(Transaction transaction) {
	int amount = transaction.getAmount();
	for (Transaction t : transactions) {
	    if (t.equals(transaction)) {
		transactions.remove(t);
		balance -= amount;
	    }
	}
    }

    public Set<Transaction> getTransactionSince(Date date) {
	Set<Transaction> transactionSet = new HashSet<Transaction>();
	for (Transaction transaction : transactions) {
	    if (transaction.getDate().compareTo(date) >= 0) {
		transactionSet.add(transaction);
	    }
	}

	return transactionSet;
        //TODO_1
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Account) {
            Account otherAccount = (Account) other;
            return this.id.compareTo(otherAccount.id) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Account "+this.name+" (id="+this.id+"), balance = "+this.balance;
    }

}
