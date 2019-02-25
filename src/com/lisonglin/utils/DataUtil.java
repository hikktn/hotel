package com.lisonglin.utils;

import java.util.regex.Pattern;

public class DataUtil {
	//判断是否是整数
	 public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	  }
}
