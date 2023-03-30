package main.java;

import java.util.*;

public class WordConvert {
	
	public static void main(String[] args) {
		System.out.println(solution("hit" , "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		
		//System.out.println("hit".indexOf("t"));
	}
	
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        String check = "false";
        
        for (int i = 0; i < words.length; i++) {
			String word = words[i];
			
			//System.out.println(begin.compareTo(target));
			int count = 0;
			
			for (int j = 0; j < word.length(); j++) {
				String temp = String.valueOf(word.charAt(j));
				
				if(begin.indexOf(temp) >= 0) {
					System.out.println(temp);
					count++;
				}
			}
			
			if(count < (word.length() -1)) {
				
			}else {
				System.out.println("현재 단어? :" + begin + " "+ word + " " + target);
				begin = word;
				answer++;
			}
			
			if(target.equals(word)) {
				check = "true";
			}
			
			if(begin.equals(target)) {
				answer = answer - 1;
				break;
			}
		}
        
        if("false".equals(check)) {
        	answer = 0;
        }
        
        
        return answer;
    }
}