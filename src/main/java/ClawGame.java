package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class ClawGame{
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 4, 4, 0}, {1, 2, 2, 1}}, new int[] {2, 3, 1, 4, 2, 3}));
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList result = new ArrayList();
        
        for (int i = 0; i < moves.length; i++) {
			int temp = moves[i];
			
			for (int j = 0; j < board.length; j++) {
	        	int[] line = board[j];
	        	
	        	if(line[temp -1] !=  0) {
	        		int preSize = result.size();
	        		
	        		if(preSize != 0) {
	        			int preNum = (int)result.get(preSize -1);
		        		if(preNum == line[temp -1]) {
		        			System.out.println("여기 ? "+ " 새로들어오는 " + line[temp -1]);
		        			line[temp -1] = 0;
		        			result.remove(preSize -1);
		        			System.out.println("남은거 : " + result);
		        			answer += 2;
		        		}else {
		        			result.add(line[temp -1]);
			        		line[temp -1] = 0;
			        		System.out.println("지금현재있는 : " + result);
		        		}
	        		}else {
	        			result.add(line[temp -1]);
		        		line[temp -1] = 0;
		        		System.out.println("지금현재있는 : " + result);
	        		}
	        		
	        		
	        		break;
	        	}
			}
		}
        
        System.out.println(result);
        
        
        
        return answer;
    }
}