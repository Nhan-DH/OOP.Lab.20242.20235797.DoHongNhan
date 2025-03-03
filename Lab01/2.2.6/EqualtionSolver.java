package lab1;
import javax.swing.JOptionPane;
public class EqualtionSolver {
    public static void main(String[] args) {
        while (true) {
            String[] options = {
                "Giải phương trình bậc nhất (1 ẩn)",
                "Giải hệ phương trình bậc nhất (2 ẩn)",
                "Giải phương trình bậc hai (1 ẩn)",
                "Thoát"
            };

            String choice = (String) JOptionPane.showInputDialog(
                null,
                "CHỌN CÔNG CỤ:",
                "Equation Solver",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice == null || choice.equals("Thoát")) {
                System.exit(0);
            } else if (choice.equals("Giải phương trình bậc nhất (1 ẩn)")) {
                solveLinearEquation();
            } else if (choice.equals("Giải hệ phương trình bậc nhất (2 ẩn)")) {
                solveLinearSystem();
            } else if (choice.equals("Giải phương trình bậc hai (1 ẩn)")) {
                solveQuadraticEquation();
            }
        }
    }

    // Giải phương trình bậc nhất ax + b = 0
    private static void solveLinearEquation() {
        double a = getDoubleInput("Nhập hệ số a:");
        double b = getDoubleInput("Nhập hệ số b:");

        if (a == 0) {
            if (b == 0) {
                showMessage("Phương trình có vô số nghiệm.");
            } else {
                showMessage("Phương trình vô nghiệm.");
            }
        } else {
            double x = -b / a;
            showMessage("Nghiệm của phương trình là x = " + x);
        }
    }

    // Giải hệ phương trình bậc nhất: a1x + b1y = c1 và a2x + b2y = c2
    private static void solveLinearSystem() {
        double a1 = getDoubleInput("Nhập a1:");
        double b1 = getDoubleInput("Nhập b1:");
        double c1 = getDoubleInput("Nhập c1:");
        double a2 = getDoubleInput("Nhập a2:");
        double b2 = getDoubleInput("Nhập b2:");
        double c2 = getDoubleInput("Nhập c2:");

        double D = a1 * b2 - a2 * b1;
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;

        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                showMessage("Hệ phương trình có vô số nghiệm.");
            } else {
                showMessage("Hệ phương trình vô nghiệm.");
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            showMessage("Nghiệm của hệ là: x = " + x + ", y = " + y);
        }
    }

    // Giải phương trình bậc hai ax^2 + bx + c = 0
    private static void solveQuadraticEquation() {
        double a = getDoubleInput("Nhập hệ số a:");
        double b = getDoubleInput("Nhập hệ số b:");
        double c = getDoubleInput("Nhập hệ số c:");

        if (a == 0) {
            showMessage("Đây không phải là phương trình bậc hai, chuyển sang giải phương trình bậc nhất...");
            solveLinearEquation();
            return;
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            showMessage("Phương trình có hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            showMessage("Phương trình có nghiệm kép: x = " + x);
        } else {
            showMessage("Phương trình vô nghiệm.");
        }
    }

    // Hàm nhập số thực từ hộp thoại
    private static double getDoubleInput(String message) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, message, "Nhập số", JOptionPane.INFORMATION_MESSAGE);
                if (input == null) {
                    System.exit(0);
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập một số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Hiển thị thông báo
    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }
}
