package cn.yd.oa.demo;

import java.util.Date;

// 1: Java中所有类默认都继承Object
public class ExtendDemo extends Object {
	

	public static void main(String[] args) {
		// 父类的引用可以存储子类对象
		Object demo = new Date();
		// 打印对象地址
		System.out.println(demo);
		System.out.println(demo.toString());
		int i=0;
		
		System.out.println(i+1);
		System.out.println(i);
		
		
		
		
		
		
		
	}
}
