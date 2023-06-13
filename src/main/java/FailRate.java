package main.java;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FailRate {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        Map<Integer, Integer> clearCount = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < stages.length; i++) {
        	
        	if(clearCount.get(stages[i]) != null) {
        		clearCount.put(stages[i], clearCount.get(stages[i])+1);
        	}else {
        		clearCount.put(stages[i], 1);
        	}
		}
        double stageSize = stages.length;
        
        Map<Integer, Double> ret = new HashMap<Integer, Double>();
        ArrayList arr = new ArrayList();
        
        
        for (int i = 0; i < clearCount.size(); i++) {
        	double temp = 0;
        	if(clearCount.get(i+1) != null) {
        		double number = clearCount.get(i+1);
        		temp = number / stageSize;
        		stageSize = stageSize - number;
        		
        		ret.put(i+1, temp);
        		//System.out.println("실패율 : " + temp);
        	}else {
        		ret.put(i+1, 0.0);
        	}
        }
        
        List<Map.Entry<Integer, Double>> entries =
                (List<Entry<Integer, Double>>)ret.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue())
		        .collect(Collectors.toList());
        for (Map.Entry<Integer, Double> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", "
                    + "Value: " + entry.getValue());
        }
        
        System.out.println(arr);
       
        System.out.println(clearCount);
        
        
        return answer;
    }
}