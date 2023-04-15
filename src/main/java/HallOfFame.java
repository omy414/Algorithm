package main.java;


import java.util.*;

public class HallOfFame {
	
	public static void main(String[] args) {
		System.out.println(solution(3, new int[] {10, 100, 20, 150, 1, 100, 200}));
	}
	
	public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList list = new ArrayList();
        
        ArrayList result = new ArrayList();
        for (int i = 0; i < score.length; i++) {
        	int temp = 0;
			list.add(score[i]);
			Collections.sort(list);
			System.out.println(list);
			
			if(i >= k) {
				System.out.println("최하위 : " + list.get((i-k)+1));
				temp = Integer.parseInt(list.get((i-k)+1).toString());
			}else {
				System.out.println("최하위 : " + list.get(0));
				temp = Integer.parseInt(list.get(0).toString());
			}
			
			result.add(temp);
		}
        
        for (int i = 0; i < result.size(); i++) {
			answer[i] = Integer.parseInt(result.get(i).toString());
		}
        
        return answer;
    }
	
}