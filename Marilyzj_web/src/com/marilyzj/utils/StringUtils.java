package com.marilyzj.utils;

public class StringUtils {
	public static boolean isNotEmpty(String str) {
		return str!=null&&str.length()>0;
	}
	public static boolean isNotEmpty(String...args) {
		for(int i =0;i<args.length;i++){
			if(!isNotEmpty(args[i]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isNotEmpty("","2","21"));
	}
}
