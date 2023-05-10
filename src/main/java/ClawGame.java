package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class ClawGame{
	
	/* 2023-05-09
	 * 프로그래머스
	 * java 크레인 인형뽑기 게임 ( 카카오 개발자 겨울 인턴십 ) 
	 * Level 1
	 * lessons ( 64061 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 4, 4, 0}, {1, 2, 2, 1}}, new int[] {2, 3, 1, 4, 2, 3}));
	}
	
	/*
	 * 게임 화면은 1x1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인 오른쪽에는 바구니가 존재
	 * 각 격자에는 다양한 인형이 들어있고 인형이 없는 칸은 빈칸
	 * 1x1 크기에 한개의 인형이 들어있고 격자의 가장 아래 칸부터 차곡차곡 쌓여있음
	 * 하나의 인형을 잡아서 오른쪽 바구니에 옮겨 담음
	 * 만약 같은 모양의 인형 두개가 바구니에 연속해서 쌓이면 두 인형은 터트려지면서 바구니에서 사라짐
	 * 크레인 작동시 인형이 집어지지 않는 경우는 없으나 없는 곳에서 작동하면 아무런 일이 일어나지 않음
	 * 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정
	 * 
	 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
	 * 크레인을 모두 작송시킨 후 터트려져 사라진 인형의 개수를 return
	 */
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