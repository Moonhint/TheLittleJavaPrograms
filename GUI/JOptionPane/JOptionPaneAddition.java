import javax.swing.JOptionPane;

public class JOptionPaneAddition {
	public static void main (String[] args){
		String num1, num2, resultString;
		float result;
		//Input the number
		num1 = JOptionPane.showInputDialog("Input number 1:");
		num2 = JOptionPane.showInputDialog("Input number 2:");
		
		result = Float.parseFloat(num1) + Float.parseFloat(num2);
		
		resultString = String.format("%s + %s = %.2f", num1, num2, result);
		
		//output the result
		JOptionPane.showMessageDialog(null, resultString);
		
	}
}
