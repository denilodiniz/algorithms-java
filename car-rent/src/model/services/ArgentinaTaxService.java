package model.services;

public class ArgentinaTaxService implements TaxService {

	@Override
	public double tax(double amount) {
		if (amount <= 100) {
			return amount * 0.4;
		}
		else {
			return amount * 0.3;
		}
	}

}
