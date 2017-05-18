package com.usermgr.until;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class DateUtil {
	
	public static String getString(String msg,String err){
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		boolean b = true;
		System.out.println(msg);
		while(b){
			try {
				s = bf.readLine();
				if(s!=null && s.trim().length()>0){
					b = false;
				}else{
					System.out.println(err);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	public static Date getDate(){
		Date d = null;
		return d;
	}
}
