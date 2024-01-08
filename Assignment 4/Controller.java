/**
 * @author Lilia
 * @version jdk 11
 */
package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * public class that connects the GUI and the calculator
 */
public class Controller {

	//creates variables for the classes View and MortgageCalculator
	private View view;
	private MortgageCalculator model;

	/**
	  * This constructor is used to save instances of classes
	  * View and MortgageCalculator
	  * Also calls method addMultiplyListener
	  */
	public Controller(View view, MortgageCalculator model) {
		this.view = view;
		this.model = model;
		//calls method in View
		view.addCalculateListener(new CalculateListener());

	}// end constructor

	/**
	 * The class MultiplyListener implements ActionListener
	 * Is used to get input from user and use the input to calculate
	 * the different mortgage calculations and return the numbers
	 * to the view class
	 *
	 */
	class CalculateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Sends the number of paymens, principal and interest rate to MortgageCalculator class
			model.setNumPayments(view.getAmortizationTF());
			model.setPrincipal(view.getPrincipalTF());
			model.setInterestRate(view.getInterestTF());
			//Calculates the different numbers
			//Sends them to View class to be set as labels 
			view.setBlendedMonthlyPayment(model.getBlendedPayment());
			view.setTotalInterest(String.format("Total Interest Paid: %.2f", model.getTotalInterest()));
			view.setTotalInterestPrincipal(
					String.format("Total Interest & Principal: %.2f", model.getTotalPrincipalAndInterest()));
			view.setRatio(String.format("The interest/principal ratio: %.2f", model.getInterestToPrincipalRatio()));
			view.setAverageInterestYear(
					String.format("Average interest per Year: %.2f", model.getAverageInterestPerYear()));
			view.setAverageInterestMonth(
					String.format("Average interest per Month: %.2f", model.getAverageInterestPerMonth()));
			view.setAmortizationInYears(String.format("Amortization in Years: %.2f", model.getAmortizationYears()));

		}

	}

	/**
	 * The entry point for creating and executing client code 
	 */
	public static void main(String[] args) {
		//Creates instances of the MortgageCalculator class and View class
		MortgageCalculator model = new MortgageCalculator();
		View view = new View();
		//Creates instance of the Controller class
		Controller controller = new Controller(view, model);

	}

}
