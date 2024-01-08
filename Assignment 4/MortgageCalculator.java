/**
 * @author Lilia
 * @version jdk 11
 */
package lab4;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * MortgageCalculator class is used to calculate all the variables
 *
 */
public class MortgageCalculator {

	//variables
	private double principal; // the total amount loaned
	private double interestRate;
	private double numPayments;

	/**
	 * setNumPayments method is used to save the the number of monthly payments
	 * @param numPayments is the value inputed by user
	 */
	public void setNumPayments(double numPayments) {
		this.numPayments = numPayments;
	}

	/**
	 * setPrincipal method is used to save the principal inputed by suer
	 * @param principal is the value inputed by user
	 */
	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	/**
	 * setInterestRate saves the interest rate inputed by the user
	 * @param interestRate is the value inputed by user
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	/**
	 * getBlendedPayment method is used to get the amount of the blended monthly payment
	 * @return a double of the amount
	 */
	public double getBlendedPayment() {
		
		double interestFactor = getInterestFactor();
		double negN = 0.0-numPayments;
		//double blendedPayment = ((principal*interestFactor)/(1-(Math.pow(interestFactor + 1, negN))));
		double blendedPayment = (principal * interestFactor) / (1.0 - Math.pow(1.0 + interestFactor, - numPayments));
		return blendedPayment;
	}

	/**
	 * getTotalInterest method is used to get the total interest
	 * @return a double of the total interest
	 */
	public double getTotalInterest() {
		double totalInterest = (getBlendedPayment() * numPayments)- principal;
		return totalInterest;
	}

	/**
	 * getTotalPrincipalAndInterest method is used to get the total interest and principal
	 * @return a double of the total interest and principal
	 */
	public double getTotalPrincipalAndInterest() {
		double totalPrincipalAndInterest = getBlendedPayment() * numPayments;
		return totalPrincipalAndInterest;
	}

	/**
	 * getInterestToPrincipalRatio method is used to the interest/principal ratio
	 * @return a double of the interest/principal ratio
	 */
	public double getInterestToPrincipalRatio() {
		double totalInterest = getTotalInterest();
		double totalPrincipal = principal;
		return (totalInterest / totalPrincipal);
	}

	/**
	 * getAverageInterestPerYear method is used to get the average interest paid per year
	 * @return a double of the average interest paid per year
	 */
	public double getAverageInterestPerYear() {
		double totalInterest = getTotalInterest();
		return (totalInterest / (numPayments / 12));
	}

	/**
	 * getAverageInterestPerMonth method is used to get the average interest paid per month
	 * @return a double of the average interest paid per month
	 */
	public double getAverageInterestPerMonth() {
		double totalInterest = getTotalInterest();
		return (totalInterest / numPayments);
	}

	/**
	 * getAmortizationYears is used to get the amortization expressed in years
	 * @return a double of the amortization expressed in years
	 */
	public double getAmortizationYears() {
		return numPayments / 12;
	}

	/**
	 * 
	 * @return a double of the interest factor
	 */
	private double getInterestFactor() {
		double r = interestRate / 100;
		double factorBase = ((r/2.0)+1.0);
		double factorPower = 2.0/12.0;
		double interestFactor = Math.pow(factorBase, factorPower)-1.0;

		return interestFactor;
	}
}