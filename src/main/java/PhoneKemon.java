package main.java;

import java.util.*;

public class PhoneKemon {
	
	/* 2023-04-24
	 * 프로그래머스
	 * java 폰켓몬
	 * Level 1 
	 * lessons ( 1845 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,1,2,3}));
	}
	
	//연구실에 총 4마리의 폰켓몬이 있고, 각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면 이는 3번 폰켓몬 두 마리, 1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다.
	//최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다. N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
	public static int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	if(list.size() == (nums.length/2)) {
        		break;
        	}
        	
        	if(list.get(nums[i]) == null) {
        		list.put(nums[i], i);
        	}
		}
        
        System.out.println(list.size());
        answer = list.size();
        return answer;
    }
}