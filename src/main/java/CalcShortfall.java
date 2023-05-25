package main.java;

import java.util.*;

public class CalcShortfall {
	
	/* 2023-05-25
	 * 프로그래머스
	 * java 모자란금액 계산하기
	 * Level 1
	 * lessons ( 82612 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}
	
	
	/*
	 * 새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
	 * 놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
	 * 단, 금액이 부족하지 않으면 0을 return 하세요.
	 */
	public static long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for (int i = 1; i < count+1; i++) {
        	System.out.println("가격 ? : " + price*i);
			sum += price*i;
		}
        
        if(sum - money > 0) {
        	answer = sum - money;
        }else {
        	answer = 0;
        }

        return answer;
    }
	
	//아래의 등차수열의 합으로 간단하게 처리 가능...
	 public long solution2(long price, long money, long count) {
	        return Math.max(price * (count * (count + 1) / 2) - money, 0);
	}
}