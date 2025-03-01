package lab1;

import java.util.Scanner;

public class calculate {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("nhap vao so a:");
	double a = sc.nextDouble();
	System.out.println("nhap vao so b:");
	double b = sc.nextDouble();
	System.out.println("cac ket qua la :");
	System.out.println("tong cua a va b la :" + (a+b));
	System.out.println("hieu cua a va b la :" + (a-b));
	System.out.println("tich cua a va b la :" + (a*b));
	System.out.println("thuong a va b la :" + (a/b));
	sc.close();
	
}
}
