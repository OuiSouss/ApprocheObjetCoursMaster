package fr.ubordeaux.ao;

import java.util.Date;

public class Transaction {
    private Date date;
    private String title;
    private int amount;

    public Transaction(String title, int amount) {
        //Affecter la date à aujourd'hui
	if (amount > 90000000 || amount <= 0){
	    throw new IllegalArgumentException("Amount too high or equal to zero");
	}
	this.title = title;
        this.amount = amount;
	this.date = new Date();
    }

    public Date getDate() {
        //TODO_2
	return date;
    }

    public String getTitle() {
        //TODO_2
	return title;
    }

    public int getAmount() {
        //TODO_2
	return amount;
    }

    @Override
    public boolean equals(Object other) {
	if (other instanceof Transaction) {
	    Transaction otherTransaction = (Transaction) other;
	    return (otherTransaction.getDate().equals(date) &&
		    otherTransaction.getTitle().equals(title) &&
		    amount == otherTransaction.getAmount());
	}
	return false;
    }
}
