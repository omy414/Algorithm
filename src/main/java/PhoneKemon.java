package main.java;

import java.util.*;

public class PhoneKemon {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,1,2,3}));
	}
	
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