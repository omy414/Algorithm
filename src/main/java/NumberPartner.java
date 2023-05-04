package main.java;

import java.util.*;

public class NumberPartner {
	
	public static StringBuilder sortingNum = new StringBuilder();
	
	public static void main(String[] args) {
		System.out.println(solution("5525", "1255"));
	}
	
	public static String solution(String X, String Y) {
        String answer = "";
        StringBuilder result = new StringBuilder();
        
        StringBuilder convertY = new StringBuilder();
        convertY.append(Y);
        
        StringBuilder convertX = new StringBuilder();
        convertX.append(X);
        
        String temp = "";
        for (int i = 0; i < X.length(); i++) {
        	StringBuilder StringTemp = new StringBuilder();
			temp = String.valueOf(convertX.charAt(i));
			
			if(convertY.indexOf(temp) >= 0) {
				convertY.deleteCharAt(convertY.indexOf(temp));
				//result += temp;
				//result.append(temp);
				
				if(result.length() > 0) {
					int check = result.length();
					
					for (int j = 0; j < result.length(); j++) {
						if(Integer.parseInt(temp) > Character.getNumericValue(result.charAt(j))) {
							
							if(j == 0) {
								StringTemp = result;
								result = new StringBuilder();
								result.append(temp +StringTemp.toString());
								
								
								//result = temp + result;
							}else {
								StringTemp = result;
								result = new StringBuilder();
								result.append(StringTemp.substring(j) + StringTemp.append(temp) +StringTemp.substring(j+1));
//								result = result.substring(j) +temp + result.substring(j+1);
							}
							break;
						}
					}
					
					if(result.length() == check) {
						//result = result + temp;
						result.append(temp);
					}
				}else {
					result.append(temp);
				}
				
			}
        	
		}
        
        if(result.length() > 0) {
        	answer = result.toString();
        	
        	if(Integer.valueOf(answer) >0) {
        		
        	}else {
        		answer = "0";
        	}
        }else {
        	answer = "-1";
        }
        	
        return answer;
    }
	
	public static StringBuilder compare(StringBuilder result) {
		int min = 0;
		
	 	for (int i = 0; i < result.length(); i++) {
	    	//String tt = String.valueOf(result.charAt(i));
			min = Math.max(min, Character.getNumericValue(result.charAt(i)));
		}
	 	
	 	sortingNum.append(String.valueOf(min));
//		 result = result.replaceFirst(String.valueOf(min), "");
	 	int check = result.indexOf(String.valueOf(min));
	 	
	 	result.deleteCharAt(check);
	 	
	 	
		 if(result.length() > 0) {
			 compare(result);
		 }
		
		return sortingNum;
	}
}