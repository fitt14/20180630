package cn.yd.oa.demo;

import java.util.ArrayList;
import java.util.Date;

// 1: Java��������Ĭ�϶��̳�Object
public class ExtendDemo extends Object {
	

	public static void main(String[] args) {
		// ��������ÿ��Դ洢�������
		Object demo = new Date();
		// ��ӡ�����ַ
		System.out.println(demo);
		System.out.println(demo.toString());
		// int i; // int[] num = new int[5]		
		ArrayList<String> list = new ArrayList<String>();
		list.add("sdfdsf");
		list.add("sdfsdf");
	}
}
