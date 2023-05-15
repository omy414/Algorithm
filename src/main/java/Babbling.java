package main.java;

import java.util.*;


public class Babbling {
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"wooayaye", "uuu", "yeye", "yemawoo", "ayamaaya"}));
	}
	
	public static int solution(String[] babbling) {
        int answer = 0;
        //String check = "ayayewooma";
        
        String[] checkList = {"aya", "ye", "woo", "ma"};
        
        
        
        for (int i = 0; i < babbling.length; i++) {
        	String temp = babbling[i];
        	System.out.println("현재 ? " + temp);
        	while(true) {
        		String res = "";
        		for (int j = 0; j < checkList.length; j++) {
        			String check = checkList[j];
        			System.out.println("체크 : " + check);
        			
        			if(temp.indexOf(check) > -1) {
        				temp = temp.replaceFirst(check, " ");
        				babbling[i] = temp;
        			}else {
        				System.out.println("안됨~ " +  temp);
        				res = "false";
        				break;
        			}
				}
        		if("false".equals(res)) {
        			break;
        		}
        	}
		}
        
        
        
        
        
//        for (int i = 0; i < checkList.length; i++) {
//        	String check = checkList[i]; 
//        	for (int j = 0; j < babbling.length; j++) {
//        		System.out.println("바블링 " + check);
//    			String temp = babbling[j];
//    			
//    			System.out.println(" 현재 ? " + temp);
//    			System.out.println(temp.indexOf(check));
//    			
//    			if(temp.indexOf(check) > -1) {
//    				temp = temp.replaceFirst(check, " ");
//    				babbling[j] = temp;
//    			}
//    		}
//		}
        System.out.println("======================");
        for (int i = 0; i < babbling.length; i++) {
			String temp = babbling[i];
			System.out.println(temp);
			if("".equals(temp.trim())) {
				answer++;
			}
		}
        
        
        return answer;
    }
}