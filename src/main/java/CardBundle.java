package main.java;

import java.util.*;

class CardBundle {
	
	
	/* 2023-03-24
	 * 프로그래머스
	 * java 카드 뭉치
	 * Level 1
	 * lessons ( 159994 )
	 * 
	 */
	public static void main(String[] args) {
		solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"} ,new String[]{"i", "want", "to", "drink", "water"});
	}
	
	
	//영어단어가 적힌 카드 뭉치 두개가 있음
	//1. 각 카드뭉치에서 카드를 순서대로 한장씩 사용
	//2. 한번사용한 카드는 다시 사용할수 없음
	//3. 카드를 사용하지 않고는 다음 카드로 못감
	//4. 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없음
	//5. goal 이 가능하면 Yes 불가능 하면 No
	public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        String[] result = new String[goal.length];
        int num1 = 0;
        int num2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
			String temp = goal[i];
			
			if(cards1.length == num1) {
				
			}else {
				if(temp.equals(cards1[num1])) {
					result[i] = temp;
					num1++;
					continue;
				}
			}
			
			
			if(cards2.length == num2) {
				
			}else {
				if(temp.equals(cards2[num2])) {
					result[i] = temp;
					num2++;
					continue;
				}
			}
		}
        
        
        if(Arrays.equals(result, goal)) {
        	answer = "Yes";
        }else {
        	answer = "No";
        }
        
        return answer;
    }
}