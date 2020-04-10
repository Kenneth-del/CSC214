package group2;

import java.util.ArrayList;

public class Transaction {
	private String name;
	private int date;
	private double amount;
	private double balance;
	private String transactionSemester;
	
	Transaction()
	{
		
	}
	public boolean isAmountOwed()
	{
		return true;
	}
	public ArrayList<Transaction> getAllTransactionData()
	{
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getTransactionSemester() {
		return transactionSemester;
	}
	public void setTransactionSemester(String transactionSemester) {
		this.transactionSemester = transactionSemester;
	}
}
