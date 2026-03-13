package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
 public static void main(String[] args) {
	 // thoi gian cua String
	Random r = new Random(123);
	long start = System.currentTimeMillis();
	String s = "";
	for(int i = 0 ; i < 65536 ; i++) {
		s += r.nextInt(2);
		
	}
	System.out.println("Thời gian chạy của String :" + (System.currentTimeMillis() - start));
	//thoi gian cua StringBuffer
	r = new Random();
	start = System.currentTimeMillis();
	StringBuffer sbf = new StringBuffer();
	for(int i = 0 ; i < 65536 ; i++) {
	    sbf.append(r.nextInt(2));
	}
	s = sbf.toString();
	System.out.println("Thời gian chạy của StringBuffer :" + (System.currentTimeMillis() - start));
	// Thoi gian cua StringBuilder
	r = new Random();
	start = System.currentTimeMillis();
    StringBuilder sb = new StringBuilder()	;
    for(int i = 0 ; i < 65536 ; i++) {
    	sb.append(r.nextInt(2));
    }
    s = sb.toString();
    System.out.println("Thời gian chạy của StringBuilder :" + (System.currentTimeMillis() - start));
 }
}
