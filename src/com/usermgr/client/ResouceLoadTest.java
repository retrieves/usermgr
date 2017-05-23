package com.usermgr.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResouceLoadTest {

	//导入文件 两种方式
	public static void main(String[] args) {
		try {
			//方法1.导入不进去 问题没有指定一个特定的classloader
			//只是将文件名传给了他如果我们将config.properties文件和class文件放在同一个目录下，
			//InputStream in = ResouceLoadTest.class.getClassLoader().getResourceAsStream("db.properties");
			//方法2
			InputStream in = new FileInputStream(new File("config.properties"));
			Properties pro = new Properties();
			pro.load(in);
			String dirver = (String) pro.get("driver");
			String url = (String) pro.get("url");
			System.out.println(url);
			System.out.println(dirver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
