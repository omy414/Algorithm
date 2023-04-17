package main.java;


import java.util.*;

public class HallOfFame {
	
	
	/* 2023-04-17
	 * 프로그래머스
	 * java 명예의 전당
	 * Level 1
	 * lessons ( 138477 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(3, new int[] {10, 100, 20, 150, 1, 100, 200}));
	}
	
	
	/*
	 * "명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다. 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다. 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다. k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.
	 * 이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
	 * 
	 */
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