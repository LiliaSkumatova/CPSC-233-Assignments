/**
 * @author Lilia
 * @version jdk 11
 */
package lab4;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
/**
 * 
 * View class extends JFrame
 * View class displays objects within application
 * Displays the questions to user and the results once calculated
 *
 */
public class View extends JFrame {
	// Display object variables
	private JTextField amortizationTF;
	private JTextField principalTF;
	private JTextField interestTF;

	private JButton calculate;
	private JLabel outputLabel1;
	private JLabel outputLabel2;
	private JLabel outputLabel3;
	private JLabel outputLabel4;
	private JLabel outputLabel5;
	private JLabel outputLabel6;
	private JLabel outputLabel7;
	private JPanel outputPanel;

	private ImageIcon icon;

	/**
	 * View constructor that has all the display objects
	 * With there specifications and contexts 
	 */
	public View() {
		super();

		//Create the window and make it close on exit
		setTitle("Mortage Calculator");
		setSize(1300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//create main panel
		JPanel mainPanel = new JPanel();
		amortizationTF = new JTextField(6);
		principalTF = new JTextField(6);
		interestTF = new JTextField(6);
		//Have at the top of main panel the title and the question to ask user
		JLabel iconLabel = new JLabel("Mortgage Calculator", SwingConstants.CENTER);
		iconLabel.setFont(new Font("SansSerif", Font.BOLD, 50));
		//Add everything to main panel
		mainPanel.add(iconLabel);
		mainPanel.add(new JLabel("The number of monthly payments: "));
		mainPanel.add(amortizationTF);
		mainPanel.add(new JLabel("The principle: "));
		mainPanel.add(principalTF);
		mainPanel.add(new JLabel("The annual interest rate: "));
		mainPanel.add(interestTF);

		//Create a button to start calculating when clicked
		calculate = new JButton("Calculate!");
		mainPanel.add(calculate);
		//Create an output panel with all the result calculations
		outputPanel = new JPanel();
		outputPanel.setBackground(Color.lightGray);
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
		icon = new ImageIcon(getClass().getResource("house.png"));
		JLabel iconLabel2 = new JLabel("Results", icon, SwingConstants.CENTER);
		iconLabel2.setFont(new Font("SansSerif", Font.BOLD, 45));
		outputPanel.add(iconLabel2);
		//create labels for all the different calculations and add them to output panel
		outputLabel1 = new JLabel("\n");
		outputLabel1.setFont(new Font("SansSerif", Font.BOLD, 25));
		outputPanel.add(outputLabel1);
		outputLabel2 = new JLabel("\n");
		outputLabel2.setFont(new Font("SansSerif", Font.BOLD, 25));
		outputPanel.add(outputLabel2);
		outputLabel3 = new JLabel("\n");
		outputLabel3.setFont(new Font("SansSerif", Font.BOLD, 25));
		outputPanel.add(outputLabel3);
		outputLabel7 = new JLabel("");
		outputLabel7.setFont(new Font("SansSerif", Font.BOLD, 25));
		outputPanel.add(outputLabel7);
		outputLabel4 = new JLabel("\n");
		outputLabel4.setFont(new Font("SansSerif", Font.BOLD, 25));
		outputPanel.add(outputLabel4);
		outputLabel5 = new JLabel("\n");
		outputLabel5.setFont(new Font("SansSerif", Font.BOLD, 25));
		outputPanel.add(outputLabel5);
		outputLabel6 = new JLabel("\n");
		outputLabel6.setFont(new Font("SansSerif", Font.BOLD, 25));
		outputPanel.add(outputLabel6);

		//add the mainPanel and ouptuPanel to window
		add(mainPanel, BorderLayout.PAGE_START);
		add(outputPanel, BorderLayout.CENTER);

		//make sur eit is visible
		setVisible(true);
	}

	/**
	 * addCalculateListener is used save the user's input
	 * @param listenr is used when java receives a notification whenever
	 * any action is performed in the application
	 */
	public void addCalculateListener(ActionListener listener) {
		calculate.addActionListener(listener);
	}

	/**
	 * getPrincipalTF is used to get the principal
	 * @return a double of the principal
	 */
	public double getPrincipalTF() {
		return Double.parseDouble(principalTF.getText());
	}

	/**
	 * getAmortizationTF method is used to get the amortization
	 * @return a double of the amortization
	 */
	public double getAmortizationTF() {
		return Double.parseDouble(amortizationTF.getText());
	}

	/**
	 * getInterestTF method is used to get interest
	 * @return a double of the interest
	 */
	public double getInterestTF() {
		return Double.parseDouble(interestTF.getText());
	}

	/**
	 * setBlendedMOnthlyPayment method is used to save the blended monthly payment in a label
	 * @param d when is the blended monthly payment
	 */
	public void setBlendedMonthlyPayment(double d) {
		outputLabel1.setText(String.format("Blended Monthly Payment: %.2f", d, "\n"));

	}

	/**
	 * setTotalInterest method is used to create a label for the total interest
	 * @param format contain the total interest
	 */
	public void setTotalInterest(String format) {
		outputLabel2.setText(format);

	}

	/**
	 * setTotalInterestPrincipal method is used to create a label for the total interest plus principal
	 * @param format contains the interest plus principal
	 */
	public void setTotalInterestPrincipal(String format) {
		outputLabel3.setText(format);

	}
	/**
	 * setRatio is used to create label for the interest/principal ratio
	 * @param format contains the interest/principal ratio
	 */
	public void setRatio(String format) {
		outputLabel7.setText(format);
	}

	/**
	 * setaverageInterestYear method is used to create label for the average interest per year
	 * @param format contains the average interest per year
	 */
	public void setAverageInterestYear(String format) {
		outputLabel4.setText(format);

	}

	/**
	 * setaverageInterestYear method is used to create label for the average interest per month
	 * @param format contains the average interest per month
	 */
	public void setAverageInterestMonth(String format) {
		outputLabel5.setText(format);

	}

	/**
	 * setAmortizationInYears method is used to create label for the amortization in years
	 * @param format contains the amortization in years
	 */
	public void setAmortizationInYears(String format) {
		outputLabel6.setText(format);

	}

}
