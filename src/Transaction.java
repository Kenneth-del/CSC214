

import java.util.ArrayList;

public class Transaction {
	private String name;
	private String date;
	private String amount;
	private String balance;
	private String transactionSemester;

	Transaction()
	{

	}
	Transaction(String name, String date, String amount, String semester)
	{
		setName(name);
		setDate(date);
		setAmount(amount);
		setTransactionSemester(semester);
	}
	public boolean isAmountOwed()
	{
		return true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getTransactionSemester() {
		return transactionSemester;
	}
	public void setTransactionSemester(String transactionSemester) {
		this.transactionSemester = transactionSemester;
	}
	@Override
	public String toString()
	{
		return getName()+"\t\t\t"+getDate()+"\t\t\t"+getAmount()+"\t\t\t"+getTransactionSemester();

	}
}
