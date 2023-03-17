package main.java;

import java.util.*;

public class OverPainting {
	
	/* 2023-03-16
	 * 프로그래머스
	 * java 덧칠하기
	 * Level 2 
	 * lessons ( 161989 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(100, 3, new int[] {1, 23, 24, 31, 39, 53, 54, 61}));
	}
	
	public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = 0;
        
        //section에서 item 값을 뽑아와서 max 값보다 크면 한번 칠한 것으로 간주
        //m(롤러의 길이) 만큼 한번 칠한 것이므로 위의 예대로라면 1,2,3 을 칠한것
        //그래서  1+3-1 로 3까지 칠했다고 기록 하면서 answer++
        //그다음 루프에서는 모두 스킵되다가 23을 만났을때 23, 24, 25를 한번에 칠한 것
        //그래서 23+3-1 로 25까지 칠했다고 기록 하면서 answer++
        //이런식으로 해서 총 6번 칠했다는 결과가 도출됨
        for (int item: section) {
			System.out.println(item);
			
			if(item > max) {
				answer++;
				max = item+m-1;
			}
		}
        System.out.println(n/m);
        
        return answer;
    }
}