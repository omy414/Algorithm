package main.java;

import java.util.*;

public class TicTacToe {
	
	/* 2023-03-17
	 * 프로그래머스
	 * java 혼자서 하는 틱택토
	 * Level 2
	 * lessons ( 160585 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"OOO", "XX.", "O.X"}));
	}
	
	public static int solution(String[] board) {
		//0은 불가능 1은 가능
        int answer = 0;
        //o의 갯수
        int o = 0;
        //x의 갯수
        int x = 0;
        
        //3x3 배열의 틱택토
        String[][] array = new String[3][3];
        
        //틱택토판에 현재게임상황(board) 저장
    	for (int i = 0; i < board.length; i++) {
    		String temp = board[i];
    		for (int j = 0; j < temp.length(); j++) {
    			array[i][j] = String.valueOf(temp.charAt(j));
    		}
    	}
        
    	//o와 x 가 이긴경우 확인
    	int winResult_O = winCheck(array, "O");
    	int winResult_X = winCheck(array, "X");
        
    	//전체 게임판에서 o와 x의 갯수 체크
        for (int i = 0; i < board.length; i++) {
			String temp = board[i];
			for (int j = 0; j < temp.length(); j++) {
				if("O".equals(String.valueOf(temp.charAt(j)))) {
					o++;
				}else if("X".equals(String.valueOf(temp.charAt(j)))) {
					x++;
				}else {
					
				}
			}
		}
        
        int countResult = 0;
        
        if(winResult_X == 1 && winResult_O == 0) {
            //x로 이기고 o로는 승리조건이 없는 경우
            //x가 후공이므로 o와 x의 갯수가 같아야 조건 성립
        	if(o == x) {
            	countResult = 1;
            }else {
            	countResult = 0;
            }
    	}else if(winResult_X == 0 && winResult_O == 1){
        	//o로 이기고 x로는 승리조건이 없는 경우
            //o가 선공이므로 o가 x의 갯수보다 많아야 조건 성립
    		if(o > x){
            	countResult = 1;
            }else {
            	countResult = 0;
            }
    	}else if(winResult_X == 1 && winResult_O == 1){
    		//o와 x모두가 승리조건이 있는 경우
        	//한 쪽이 승리하는 즉시 게임이 종료되는 것이기때문에 아예 조건 제외
    		countResult = 0;
    	}else {
    		//o와 x모두가 승리조건이 없는 경우
        	//o와 x의 갯수가 같거나 o가 x보다 갯수가 많아야 조건 성립
    		if(o == x) {
            	countResult = 1;
            }else if(o > x){
            	countResult = 1;
            }else {
            	countResult = 0;
            }
    	}
        
        System.out.println("오 갯수 : " + o);
        System.out.println("엑스 갯수 : " + x);
        
        //결과 정리
        if((winResult_O == 1 || winResult_X == 1 )&& countResult == 1) {
            //o 또는 x가 이기고 위의 조건에도 성립된 경우 1 반환
        	answer = 1;
        }else if(countResult == 1) {
        	//아무도 승리한기록이 없는 상태에서 위의 조건이 성립된 경우 1반환
        	answer = 1;
        }else {
        	//위의 기본 전제조건이 성립되지 않는 경우 0반환
        	answer = 0;
        }
        
        //위의 모든 조건을 달성하더라도
        //o 가 x보다 2의 숫자가 클수가없고
        //x가 o보다 클수가 없음
        //해당 조건 까지 클리어가 되어야 인정
        if( (o > (x+1)) || x > o ) {
        	answer = 0;
        }
        return answer;
    }
	
	public static int winCheck(String[][] array, String check) {
		int result = 0;
		
		//승리할 수 있는 모든 케이스
		int[][][] victoryCases = { {{0,0},{0,1},{0,2}}, {{1,0},{1,1},{1,2}}, {{2,0},{2,1},{2,2}}
			,{{0,0},{1,0},{2,0}} ,{{0,1},{1,1},{2,1}} ,{{0,2},{1,2},{2,2}}
			,{{0,0},{1,1},{2,2}} ,{{2,0},{1,1},{0,2}} 
		}; 
		 
		//승리 케이스 전체 for문 
		for (int i = 0; i < victoryCases.length; i++) {
		
			for (int j = 0; j < victoryCases[i].length; j++) {
				//x 와 y 좌표 구하기
				int x = 0;
				int y = 0;		
				for (int j2 = 0; j2 < 2; j2++) {
					x = victoryCases[i][j][0];
					y = victoryCases[i][j][1];
				}
				
				//각 배열의 값을 꺼내서 현재 체크하는 문자열과 비교 
				if(!check.equals(array[x][y])) {
					result = 0;
					break;
				}else {
					//각 케이스에 해당하는 라인을 정상적으로 for문을 풀로 완료해야만 1반환 ( 중간에 끊어지면 실패 )
					result = 1;
				}
			}
			
			//단 하나의 케이스라도 존재하는 경우 그 즉시 braek
			if(result == 1) {
				break;
			}
		}
		System.out.println(check + " 결과 : " + (result == 1 ? "빙고" : "아님"));
		
		return result;
	}
}