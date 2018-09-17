package fr.ubordeaux.ao;

import java.util.Date;

public class Transaction {
    private Date date;
    private String title;
    private int amount;

    public Transaction(String title, int amount) {
        //Affecter la date à aujourd'hui
        this.title = title;
	if (amount > 90000000 || amount == 0){
	    throw new IllegalArgumentException();
	}
        this.amount = amount;
	this.date = new Date();
    }

    public Date getDate() {
        //TODO_2
	return this.date;
    }

    public String getTitle() {
        //TODO_2
	return this.title;
    }

    public int getAmount() {
        //TODO_2
	return (this.amount);
    }
}
