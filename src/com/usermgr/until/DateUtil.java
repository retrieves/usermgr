package com.usermgr.until;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	
	public static String getString(String msg){
		//i/o input /output 输入：从外面输出到内存或者什么地方/输出：从内存或者什么地方输出到外面
		//Stream:有他的都是字节 reader流
		Reader rd = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(rd);
		String s = null;
		boolean b = true;
		System.out.println(msg);
		while(b){
			try {
				s = bf.readLine();//可能出现i/o异常
				if(s!=null && s.trim().length()>0){
					b = false;
				}else{
					System.out.println("数据不能为空 ");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	
	public static Date getDate(String msg){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//将date型数据 定型
		Date d = null;
		String s = null;
		boolean b =true;
		while(b){
			s =	getString(msg);//得到一个字符串
			if(s.matches("\\d{4}-\\d{2}-\\d{2}")){
				try {
					d = sdf.parse(s);
					b = false;
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("数据格式不对,请重新输入");
			}
		}
		
		return d;
	}
	
	public static int getInt(String msg){
		int i = -1;
		String s = null;
		boolean flag = true;
		while(flag){
			s = getString(msg);
			if(s.matches("\\d+")){
				i = Integer.parseInt(s);
				flag = false;
			}else{
				System.out.println("数据格式不对");
			}
		}
		return i;
	}
}
