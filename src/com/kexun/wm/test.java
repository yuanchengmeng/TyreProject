package com.kexun.wm;

import java.text.SimpleDateFormat;
import java.util.Date;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		String Barcode = "13004029999";  
//        String regex ="^\\d{4,}$";  
//		System.out.println(str.matches(regex));
		 System.out.println(Barcode.length());
		 System.out.println(Barcode.substring(2, 5)+"----"+Barcode.substring(5, 7));
	}

}
