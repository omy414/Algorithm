package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class PickNumberAdd{
	
	/* 2023-06-12
	 * 프로그래머스
	 * java 두개 뽑아서 더하기
	 * Level 1 
	 * lessons ( 68644 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution2(new int[] {2,1,3,4,1}));
	}
	
	/* 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요. */
	public static int[] solution(int[] numbers) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
			int base = numbers[i]; 
        	for (int j = i+1; j < numbers.length; j++) {
				int temp = base + numbers[j];
				arrList.add(temp);

			}
		}
        
        arrList = new ArrayList<Integer>(arrList.stream().distinct().collect(Collectors.toList()));
        
        Collections.sort(arrList);
        
        System.out.println(arrList);
        
        int[] answer = new int[arrList.size()];
        
        for (int i = 0; i < arrList.size(); i++) {
			answer[i] = arrList.get(i);
		}
        
        return answer;
    }
	
	public static int[] solution2(int[] numbers) {
		TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
			
        	for (int j = i+1; j < numbers.length; j++) {
				
				set.add(numbers[i] + numbers[j]);
			}
		}
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}