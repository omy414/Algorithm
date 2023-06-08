package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class PickNumberAdd{
	public static void main(String[] args) {
		System.out.println(solution2(new int[] {2,1,3,4,1}));
	}
	
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