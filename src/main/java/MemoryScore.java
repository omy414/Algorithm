package main.java;

import java.util.*;

public class MemoryScore {
	
	/* 2023-04-25
	 * 프로그래머스
	 * java 추억 점수
	 * Level 1
	 * lessons ( 176963 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"may", "kein", "kain", "radi"}, new int[] {5, 10, 1, 3}, new String[][] {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}));
	}
	
	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> friend = new HashMap<String, Integer>();
        
        for (int i = 0; i < name.length; i++) {
			friend.put(name[i],yearning[i]);
		}
        
        for (int i = 0; i < photo.length; i++) {
        	int sum = 0;
			String[] temp = photo[i];
			
			for (int j = 0; j < temp.length; j++) {
				String call = temp[j];
				if(friend.get(call) != null) {
					sum += friend.get(call);
				}
			}
			
			System.out.println("값은? : " + sum);
			answer[i] = sum;
		}
        
        
        return answer;
    }
}