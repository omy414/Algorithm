package main.java;

import java.util.*;


public class MakeHambuger {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
	}
	
	public static int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder ingreList = new StringBuilder();
        
        for (int i = 0; i < ingredient.length; i++) {
        	ingreList.append(ingredient[i]);
        	
        	if(ingreList.length() > 3 && ingreList.subSequence(ingreList.length() -4, ingreList.length()).equals("1231")) {
        		ingreList.delete(ingreList.length() -4, ingreList.length());
        		answer++;
        	}
		}
        return answer;
    }
}