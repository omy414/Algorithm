package main.java;

import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {37, 2, 5, 16, 7, 1}, new int[] {38, 19, 20, 40, 15, 25}));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int wildCard = 0;
        
        Map winMap = new HashMap();
        for (int i = 0; i < win_nums.length; i++) {
			winMap.put(win_nums[i], 1);
		}
        
        for (int i = 0; i < lottos.length; i++) {
			int temp = lottos[i];
			
			if(temp == 0) {
				wildCard++;
			}else if(winMap.get(temp) != null) {
				count += Integer.parseInt(winMap.get(temp).toString());
			}
		}
        
        int high = (count+wildCard) == 0 ? 6 : 7 - (count+wildCard);
        int low = count == 0  ? 6 : 7 - count;
        
        int[] answer = {high, low};
        System.out.println("최고점 :" + high  + " 최저점 : " +  low);
        return answer;
    }
}