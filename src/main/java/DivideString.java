package main.java;

import java.util.*;

public class DivideString {
	
	public static void main(String[] args) {
		System.out.println(solution("bananaaaaaaaaaaab"));
	}
	
	public static int solution(String s) {
        int answer = 0;
        
        String first = "";
        
        int count = 0;
        int oCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	String temp = String.valueOf(s.charAt(i));
        	
        	if(count == 0) {
        		first = temp;
        	}
        	
        	if(temp.equals(first)) {
        		count++;
        		
        		if(i+1 == s.length()) {
        			answer++;
        		}
        	}else {
        		oCount++;
        		
        		if(oCount == count) {
        			count = 0;
        			oCount = 0;
        			answer++;
        		}else {
        			if(i+1 == s.length()) {
            			answer++;
            		}
        		}
        	}
        	
		}
        
        return answer;
    }
}