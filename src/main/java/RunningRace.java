package main.java;

import java.util.*;


public class RunningRace {
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"mumu", "soe", "poe", "kai", "mine"}, new String[] {"kai", "kai", "mine", "mine"}));
	}
	
	 public static String[] solution(String[] players, String[] callings) {
	        String[] answer = new String[players.length];
	        
	        for (int i = 0; i < callings.length; i++) {
				String call = callings[i];
				
				for (int j = 0; j < players.length; j++) {
					if(call.equals(players[j].toString())) {
						String temp = players[j];
						players[j] = players[j-1];
						players[j-1] = temp;
						break;
					}
				}
			}
	        
	        for (int i = 0; i <  players.length; i++) {
				System.out.println((i+1) + "위 : " + players[i]);
				answer[i] =  players[i];
			}
	        
	        return answer;
	    }
	 
	 public static String[] solution2(String[] players, String[] callings) {
	        String[] answer = new String[players.length];
	        
	        HashMap<String,Integer> map = new HashMap<String ,Integer>();
	        
	        
	        for (int i = 0; i < players.length; i++) {
				map.put(players[i], i);
			}
	        
	        
	        
	        
	        for (int i = 0; i < callings.length; i++) {
				String call = callings[i];
				
				
				for (int j = 0; j < players.length; j++) {
					if(call.equals(players[j].toString())) {
						String temp = players[j];
						players[j] = players[j-1];
						players[j-1] = temp;
						break;
					}
				}
			}
	        
	        for (int i = 0; i <  players.length; i++) {
				System.out.println((i+1) + "위 : " + players[i]);
				answer[i] =  players[i];
			}
	        
	        return answer;
	    }
	 
	 
	 public static String[] solution3(String[] players, String[] callings) {
	        String[] answer = new String[players.length];
	        ArrayList list = new ArrayList();
	        
	        for (int i = 0; i < players.length; i++) {
				list.add(i, players[i]);
			}
	        
	        
	        for (int i = 0; i < callings.length; i++) {
				String call = callings[i];
				
				for (int j = 0; j < list.size(); j++) {
					if(call.equals(list.get(j).toString())) {
						String temp = list.get(j-1).toString();
						
						list.remove(j-1);
						
						list.add(j, temp);
						break;
					}
				}
			}
	        
	        for (int i = 0; i <  list.size(); i++) {
				System.out.println((i+1) + "위 : " + list.get(i));
				answer[i] = list.get(i).toString();
			}
	        
	        return answer;
	    }
}