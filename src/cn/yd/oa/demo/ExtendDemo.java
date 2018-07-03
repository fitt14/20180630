package cn.yd.oa.demo;

import java.util.ArrayList;
import java.util.Date;

// 1: Java中所有类默认都继承Object
public class ExtendDemo extends Object {
	

	public static void main(String[] args) {
		// 父类的引用可以存储子类对象
		Object demo = new Date();
		// 打印对象地址
		System.out.println(demo);
		System.out.println(demo.toString());
		// int i; // int[] num = new int[5]		
		ArrayList<String> list = new ArrayList<String>();
		list.add("sdfdsf");
		list.add("sdfsdf");
	}
}
