package main.java;

import java.util.HashMap;
import java.util.Map;

public class CleanUpDesktop {
	public static void main(String[] args) {
		solution(new String[] {"..", "#."});
	}
	
	
	public static int[] solution(String[] wallpaper) {
        int[] answer = {};
        System.out.println(wallpaper[1]);
        Map<Integer, Integer> firstArray = new HashMap<Integer,Integer>();
        Map<Integer, Integer> lastArray = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < wallpaper.length; i++) {
        	String temp  = wallpaper[i].toString();
        	firstArray.put(i, temp.indexOf("#"));
		}
        
        for (int i = 0; i < wallpaper.length; i++) {
        	String temp  = wallpaper[i].toString();
        	lastArray.put(i, temp.lastIndexOf("#"));
		}
        
        int first = 50;
        int check = 99;
        for (int i = 0; i < firstArray.size(); i++) {
        	int temp = firstArray.get(i);
        	if(temp != -1) {
        		if(first > temp) {
        			first = temp;
        		}
        		if(check == 99) {
        			check = i;
        		}
        	}
		}
        
        
        int last = 0;
        int check2 = 0;
        for (int i = 0; i < lastArray.size(); i++) {
        	int temp = lastArray.get(i);
        	if(temp != -1) {
        		if(last < temp) {
        			last = temp;
        		}
        		
        		check2 = i;
        	}
		}
        
        System.out.println("펄스트 : " + check);
        System.out.println("펄스트 : " + first);
        
        System.out.println("라스트 : " + (check2+1));
        System.out.println("라스트 : " + (last+1));
        
        System.out.println(firstArray);
        System.out.println(lastArray);
        return answer;
    }
}