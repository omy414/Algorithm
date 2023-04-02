package main.java;

import java.util.*;

public class KnightWeapon {
	public static void main(String[] args) {
		System.out.println(solution(5, 3, 2));
	}
	
	
	public static int solution(int number, int limit, int power) {
        int answer = 0;
        for(int j =1; j<=number; j++){
            int count =0;
            //시간복잡도의 의해 제곱근 까지만 for 문 돌리기
            for(int i=1; i*i<=j; i++){
                if(j == i*i){
                    count++;
                }else if((j%i) == 0){
                    count+=2;
                }
            }
            if(count > limit){
            	answer += power;
            }else {
            	answer += count;	
            }
        }
        //System.out.println("합 : " + answer);
        return answer;
    }
}