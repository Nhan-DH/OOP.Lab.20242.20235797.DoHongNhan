package lab1;	
import javax.swing.JOptionPane;


public class calculate {
	public static void main(String[] args) {

		String strNum1 = JOptionPane.showInputDialog(null, "Nhập số thứ nhất:", "Nhập số",
				JOptionPane.INFORMATION_MESSAGE);
		String strNum2 = JOptionPane.showInputDialog(null, "Nhập số thứ hai:", "Nhập số",
				JOptionPane.INFORMATION_MESSAGE);

		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
        double difference = num1 - num2 ;
		double sum = num1 + num2;
		double product = num1 * num2;
		String divisionResult = (num2 != 0) ? String.valueOf(num1 / num2) : "Không thể chia cho 0";

		String message = "Tổng: " + sum + "\n"+"Hieu: " + difference + "\n"+ "Tích: " + product + "\n" + "Thương: " + divisionResult;

		JOptionPane.showMessageDialog(null, message, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
	}
}
