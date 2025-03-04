package lab1;

import java.util.Scanner;

public class NumberOfDayInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;
        
        // Kiểm tra năm hợp lệ
        while (true) {
            System.out.print("Nhập năm (số nguyên dương, 4 chữ số): ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 1000) break;
                System.out.println("Năm không hợp lệ. Vui lòng nhập lại.");
            } else {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập lại.");
                sc.next(); // Xóa bộ nhớ đệm
            }
        }
        sc.nextLine(); // Xóa bộ nhớ đệm

        String monthInput;
        int month;
        
        // Kiểm tra tháng hợp lệ
        while (true) {
            System.out.print("Nhập tháng (tên đầy đủ, viết tắt, 3 chữ cái hoặc số): ");
            monthInput = sc.nextLine().trim().toLowerCase();
            month = getMonthNumber(monthInput);
            if (month != -1) break;
            System.out.println("Tháng không hợp lệ. Vui lòng nhập lại.");
        }
        
        int daysInMonth = getDaysInMonth(year, month);
        System.out.println("Tháng " + getFullMonthName(month) + " năm " + year + " có " + daysInMonth + " ngày.");
    }

    public static int getMonthNumber(String input) {
        String[] months = {"tháng một", "tháng hai", "tháng ba", "tháng tư", "tháng năm", "tháng sáu", 
                           "tháng bảy", "tháng tám", "tháng chín", "tháng mười", "tháng mười một", "tháng mười hai"};
        String[] shortMonths = {"thg 1", "thg 2", "thg 3", "thg 4", "thg 5", "thg 6", 
                                "thg 7", "thg 8", "thg 9", "thg 10", "thg 11", "thg 12"};
        String[] threeLetterMonths = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        
        for (int i = 0; i < 12; i++) {
            if (input.equals(months[i]) || input.equals(shortMonths[i]) || input.equals(threeLetterMonths[i]) || input.equals(String.valueOf(i + 1))) {
                return i + 1;
            }
        }
        return -1;
    }

    public static String getFullMonthName(int month) {
        String[] months = {"Tháng Một", "Tháng Hai", "Tháng Ba", "Tháng Tư", "Tháng Năm", "Tháng Sáu", 
                           "Tháng Bảy", "Tháng Tám", "Tháng Chín", "Tháng Mười", "Tháng Mười Một", "Tháng Mười Hai"};
        return months[month - 1];
    }

    public static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
            default:
                return 31;
        }
    }
}
             