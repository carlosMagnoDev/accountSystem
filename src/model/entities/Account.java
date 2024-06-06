package model.entities;

import model.exception.DomainException;

public abstract class Account {
	private Integer number;
	private String holder;
	protected Double balance;
	
	public Account () {
		
	}
	
	public Account (Integer number, String holder, Double balance) {
		this.number = number; 
		this.holder = holder;
		this.balance = balance;
	}
	
	public Integer getNumber () {
		return this.number;
	}
	
	public void setNumber (Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return this.balance;
	}


	public abstract void deposit (Double amount);
	
	public abstract void withdraw (Double amount) throws DomainException;
	
	public String toString () {
		return "Holder: " + getHolder() + "\nBalance: " + String.format("%.2f", balance);
	}
	
}
