package model.entities;

import model.exception.DomainException;

public class CheckingAccount extends Account {
	private Double withdraw;
	
	public CheckingAccount () {
		super();
	}
	
	public CheckingAccount (Integer number, String holder, Double balance, Double withdraw) {
		super(number, holder, balance);
		this.withdraw = withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}
	
	@Override
	public void deposit (Double amount) {
		balance += amount; 
	}
	
	@Override
	public void withdraw (Double amount) throws DomainException {
		if (amount > withdraw) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
		}
		
		if (amount > balance) {
			throw new DomainException("Withdraw error: Not enough balance");
		}
		
		balance -= amount;
	}
	
}
