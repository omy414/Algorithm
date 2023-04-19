package main.java;

import java.util.*;


public class RunningRace {
	
	/* 2023-04-19
	 * 프로그래머스
	 * java 달리기경주
	 * Level 1
	 * lessons ( 178871 )
	 * 
	 */
	
	//시간 복잡도 관련 문제인데 solution1 처럼 풀이를 진행하면 시간초과가 발생함
	//전체의 선수를 돌면서 찾아서 서로 위치를 바꾸는 단순한 방식이 player 수가 많을 수록 점점 복잡도가 올라가버림
	//그래서 solution2 의 방법으로 차용함
	//player 의 현재 index 값을 Hashmap 에 keyValue 로 저장을하고
	//call 을 for 문돌리면서 Hashmap 에 저장한 value 를 가져와 해당 숫자로
	//배열에 저장되어있는 정보를 앞의 index와 서로 swap 진행
	//Hashmap 에도 해당 내용을 업데이트 쳐주기 마찬가지로 swap 진행
	//이와 같은 방법으로 player 같은 경우엔 쓸데없이 for 문을 계속 돌지 않아도 해결이 가능
	public static void main(String[] args) {
		System.out.println(solution2(new String[] {"mumu", "soe", "poe", "kai", "mine"}, new String[] {"kai", "kai", "mine", "mine"}));
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
				
				int num = map.get(call);
				
				String temp = players[num-1];
				players[num-1] = players[num];
				players[num] = temp;
				
				map.put(temp, num);
				map.put(call, num-1);
			}
	        
	        for (int i = 0; i <  players.length; i++) {
				System.out.println((i+1) + "위 : " + players[i]);
				answer[i] =  players[i];
			}
	        
	        return answer;
	    }
}	 
	 
