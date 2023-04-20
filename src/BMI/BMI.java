// Importing necessary libraries
package BMI;
import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

//BMI class extends JFrame and implements ActionListener interface
public class BMI extends JFrame implements ActionListener {
	
	// Instance variables declaration
	private JLabel jOutput, lHeight, lWeight;
	private JTextField tHeight, tWeight;
	private JButton jCalculate;
	private JPanel panel;
	
	public BMI() {
		super("BMI Calculator");
		setSize(300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Creating a JPanel with GridBagLayout
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		
		// Adding "Enter Height (meters)" label and text field to JPanel
		lHeight = new JLabel("Enter Height (meters):");
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(lHeight, constraints);
		
		tHeight = new JTextField(20);
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(tHeight, constraints);
		
		// Adding "Enter Weight (kg)" label and text field to JPanel
		lWeight = new JLabel("Enter Weight (kg):");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(10,0,0,0);
		panel.add(lWeight, constraints);
		
		tWeight = new JTextField(20);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.insets = new Insets(0,0,0,0);
		panel.add(tWeight, constraints);
		
		// Adding "Calculate" button to JPanel
		jCalculate = new JButton("Calculate");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(10,0,0,0);
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(jCalculate,constraints);
		
		// Attach JCalculate to event
		jCalculate.addActionListener(this);
		
		// Adding output label to JPanel
		jOutput = new JLabel("OUT");
		Font font = jOutput.getFont();
		jOutput.setFont(new Font(font.getName(), Font.BOLD, 24));
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.insets = new Insets(10,0,0,0);
		panel.add(jOutput, constraints);
		
		// Setting border of JPanel
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Calculate"));
		
		// Adding JPanel to JFrame
		add(panel);
		// pack();
		setLocationRelativeTo(null);
	}

	// Main method to create object of BMI class and make it visible
	public static void main(String[] args) {
		BMI bmi = new BMI();
		bmi.setVisible(true);

	}
	// ActionPerformed method to handle events when user interacts with components
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jCalculate) {
			int weight = Integer.parseInt(tWeight.getText());
			float height = Float.parseFloat(tHeight.getText());
			
			float BMI = weight / (height * height);
			
			

			DecimalFormat decimalFormat = new DecimalFormat("#.##"); // create a decimal format with two decimal places
			decimalFormat.setRoundingMode(RoundingMode.UP); // set the rounding mode to down

			jOutput.setText("Your BMI is: " + decimalFormat.format(BMI));

			
		}
		
	}

}
