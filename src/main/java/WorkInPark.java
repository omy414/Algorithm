package main.java;

import java.util.*;

public class WorkInPark {
	
	
	/* 2023-03-29
	 * 프로그래머스
	 * java 공원 산책
	 * Level 1
	 * lessons ( 172928 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"SOO","OXX","OOO"}, new String[] {"E 2","S 2","W 1"}));
		
	}
	
	
	//park 는 공원의 시작점과 장애물등의 경로
	//routes 는 가고자 하는 방향과 이동횟수
	//S에서 시작하고 X가 있으면 못감
	//해당 장소로 이동하기 전에 공원을 벗어나는지 체크 or 장애물 만나는지 체크하고 이동함
	//정상 이동했을때 최종적으로 내가 있는 위치는?
	public static int[] solution(String[] park, String[] routes) {
		
		//공원의 크기 결정 park 배열의 갯수가 세로 길이
		//한 배열 내의 있는 글자 수가 가로 길이
        String[][] array = new String[park.length][park[0].length()];
        
        
        //가로와 세로 초기화
        int w = 0;
    	int h = 0;
    	
        //공원을 2차원 배열에 담기
    	for (int i = 0; i < park.length; i++) {
    		String temp = park[i];
    		for (int j = 0; j < temp.length(); j++) {
    			array[i][j] = String.valueOf(temp.charAt(j));
    			
    			//공원의 시작점 S 를 기록
    			if(String.valueOf(temp.charAt(j)).equals("S")) {
    				w = i;
    				h = j;
    			}
    		}
    	}
    	
    	//현재 공원 위치는?
    	System.out.println("W : "+ w + " H : " + h);

    	//공원의 산책 루트 반복문
    	for (int i = 0; i < routes.length; i++) {
			String temp = routes[i];
			
			//루트 배열이 빈칸으로 방향과 이동횟수를 나타내고있으니까 split
			String[] splitTemp = temp.split(" ");
			
			if(splitTemp[0].equals("E")) {
				//동쪽인 경우
				String check = "false";
				
				//동쪽 방향으로 한칸씩 전진하면서 장애물 (X) 가 있으면 이 행동은 아예 취소
				//동쪽 방향으로 한칸씩 전진하면서 공원 밖(catch) 으로 나가게 되면 이 행동은 아예 취소
				for (int j = 1; j <= Integer.parseInt(splitTemp[1]); j++) {
					try {
						if(array[w][h+j].equals("X")){
							check = "false";
							break;
						}else {
							check = "true";
						}
					} catch (Exception e) {
							System.out.println("동쪽 공원 밖으로 나감");
							check = "false";
							break;
					}
				}
				
				if("true".equals(check)) {
					System.out.println("동쪽으로 정상 진입 성공 " + splitTemp[1] + " 칸 전진");
					h = h + (Integer.parseInt(splitTemp[1]));
				}
			}else if(splitTemp[0].equals("W")) {
				//서쪽인 경우
				String check = "false";

				//서쪽 방향으로 한칸씩 전진하면서 장애물 (X) 가 있으면 이 행동은 아예 취소
				//서쪽 방향으로 한칸씩 전진하면서 공원 밖(catch) 으로 나가게 되면 이 행동은 아예 취소
				for (int j = Integer.parseInt(splitTemp[1]); j >0; j--) {
					
					try {
						if(array[w][h-j].equals("X")){
							check = "false";
							break;
						}else {
							check = "true";
						}
					} catch (Exception e) {
						System.out.println("서쪽 공원 밖으로 나감");
						check = "false";
						break;
					}
				}
				
				if("true".equals(check)) {
					System.out.println("서쪽으로 정상 진입 성공 " + splitTemp[1] + " 칸 전진");
					h = h - (Integer.parseInt(splitTemp[1]));
				}
			}else if(splitTemp[0].equals("S")) {
				//남쪽인 경우
				String check = "false";
				
				//남쪽 방향으로 한칸씩 전진하면서 장애물 (X) 가 있으면 이 행동은 아예 취소
				//남쪽 방향으로 한칸씩 전진하면서 공원 밖(catch) 으로 나가게 되면 이 행동은 아예 취소
				for (int j = 1; j <= Integer.parseInt(splitTemp[1]); j++) {
					
					try {
						if(array[w+j][h].equals("X")){
							check = "false";
							break;
						}else {
							check = "true";
						}
					} catch (Exception e) {
						System.out.println("남쪽 공원 밖으로 나감");
						check = "false";
						break;
					}
					
				}
				
				if("true".equals(check)) {
					System.out.println("남쪽으로 정상 진입 성공 " + splitTemp[1] + " 칸 전진");
					w = w + (Integer.parseInt(splitTemp[1]));
				}
			}else if(splitTemp[0].equals("N")) {
				//북쪽인 경우
				String check = "false";

				//북쪽 방향으로 한칸씩 전진하면서 장애물 (X) 가 있으면 이 행동은 아예 취소
				//북쪽 방향으로 한칸씩 전진하면서 공원 밖(catch) 으로 나가게 되면 이 행동은 아예 취소
				for (int j = Integer.parseInt(splitTemp[1]); j >0; j--) {
					
					try {
						if(array[w-j][h].equals("X")){
							check = "false";
							break;
						}else {
							check = "true";
						}
					} catch (Exception e) {
						System.out.println("북쪽 공원 밖으로 나감");
						check = "false";
						break;
					}
					
				}
				
				if("true".equals(check)) {
					System.out.println("북쪽으로 정상 진입 성공 " + splitTemp[1] + " 칸 전진");
					w = w - (Integer.parseInt(splitTemp[1]));
				}
			}
		}
    	System.out.println("최종 좌표는? : " + w  + "  " + h);
    	
    	int[] answer = {w , h};
        
        return answer;
    }
}