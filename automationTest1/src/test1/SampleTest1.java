package test1;

import java.util.Iterator;

public class SampleTest1 {
	static int val1;
	static byte val2;
	static short val3;
	static long val4;
	static float val5;
	static double val6;
	static boolean val7;
	static char val8;
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Default values of the following: ");
	    System.out.println("int = " + val1);
	    System.out.println("byte = " + val2);
	    System.out.println("short = " + val3);
	    System.out.println("long = " + val4);
	    System.out.println("float = " + val5);
	    System.out.println("double = " + val6);
	    System.out.println("boolean = " + val7);
	    System.out.println("char = " + val8);
	    
	    int num = 5;
		for (int i = 1; i <= num; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	

}
