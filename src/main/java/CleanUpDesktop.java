package main.java;

import java.util.HashMap;
import java.util.Map;

public class CleanUpDesktop {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"..", "#."}));
	}
	
	
	public static int[] solution(String[] wallpaper) {
        Map<Integer, Integer> firstArray = new HashMap<Integer,Integer>();
        Map<Integer, Integer> lastArray = new HashMap<Integer, Integer>();
        
        //각 행에서의 첫번째 아이콘 자리를 찾아서 Map에 담기
        for (int i = 0; i < wallpaper.length; i++) {
        	String temp  = wallpaper[i].toString();
        	firstArray.put(i, temp.indexOf("#"));
		}
        
        //각 행에서의 마지막 아이콘 자리를 찾아서 Map에 담기
        for (int i = 0; i < wallpaper.length; i++) {
        	String temp  = wallpaper[i].toString();
        	lastArray.put(i, temp.lastIndexOf("#"));
		}
        
        //해당 열에 아이콘이 없는 경우엔 -1 반환으로 드래그를 할필요가없음
        //드래그는 왼쪽에서 오른쪽으로 위에서 아래로 밖에 안됨
        //아이콘이 존재하는 경우에 어느 열에 있더라도 젤 왼쪽에 있는 값이 기준이 되기 때문에
        //행 상으로 가장 작은 수를 기준점으로 잡음 ex ) luy
        //또한 젤 첫 열에서부터 내려가야하니 아이콘이 존재하는 가장 첫 열을 저장함 ex) lux
        int luy = 50;
        int lux = 99;
        for (int i = 0; i < firstArray.size(); i++) {
        	int temp = firstArray.get(i);
        	if(temp != -1) {
        		if(luy > temp) {
        			luy = temp;
        		}
        		if(lux == 99) {
        			lux = i;
        		}
        	}
		}
        
        //아이콘이 존재하는 경우에 어느열에 있더라도 젤 오른쪽에 있는 값이 맨 마지막 값이 되기 때문에
        //행 상으로 가장 큰 수를 기준점으로 잡음 ex) rdy
        //또한 아이콘이 존재하는 경우 젤 마지막 열이 드래그의 끝점 ex) rdx
        //드래그는 아이콘을 감싸듯 해야하기 때문에 끝점은 존재하는 값보다 +1 해줘야함
        int rdy = 0;
        int rdx = 0;
        for (int i = 0; i < lastArray.size(); i++) {
        	int temp = lastArray.get(i);
        	if(temp != -1) {
        		if(rdy < temp) {
        			rdy = temp;
        		}
        		
        		rdx = i;
        	}
		}
        
        System.out.println("펄스트 : " + lux);
        System.out.println("펄스트 : " + luy);
        
        System.out.println("라스트 : " + (rdx+1));
        System.out.println("라스트 : " + (rdy+1));
        
        System.out.println(firstArray);
        System.out.println(lastArray);
        int[] answer = {lux, luy, (rdx+1), (rdy+1)};
        return answer;
    }
}