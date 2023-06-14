package main.java;

import java.util.*;

public class SecretMap {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] {46, 33, 33 ,22, 31, 50}, new int[] {27 ,56, 19, 14, 14, 10}));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        
        String[] arr1String = new String[arr1.length];
        String[] arr2String = new String[arr2.length];
        
        for (int i = 0; i < arr1.length; i++) {
			int temp = arr1[i];
			String sb1 = conversion(temp, 2, n);
			System.out.println("변환1 : " + sb1);
			
			arr1String[i] = sb1;
			
			temp = arr2[i];
			String sb2 = conversion(temp, 2, n);
			arr2String[i] = sb2;
			System.out.println("변환2 : " + sb2);
			
			int addNumber = Integer.parseInt(sb1) + Integer.parseInt(sb2);
			
			String convertNumber = String.valueOf(addNumber);
			System.out.println(convertNumber);
			
			if(convertNumber.length() != n) {
				int ll = n - convertNumber.length();
	        	
	        	for (int k = 0; k < ll; k++) {
	        		convertNumber = "0"+convertNumber;
				}
			}
			
			System.out.println("후 : " + convertNumber);
			
			String returnString = "";
			for (int j = 0; j < convertNumber.length(); j++) {
				int charTemp = Integer.parseInt(String.valueOf(convertNumber.charAt(j)));
				
				if(charTemp > 0) {
					returnString+="#";
				}else {
					returnString+=" ";
				}
			}
			System.out.println("배열형태 : " + returnString);
			
			answer[i] = returnString;
		}
        
        return answer;
    }
	
	public static String conversion(int number, int N, int length){
        StringBuilder sb = new StringBuilder();
	    int current = number;
	    
        // 진법 변환할 숫자가 0보다 큰 경우 지속 진행
        while(current > 0){
            // 만약 N으로 나누었는데 10보다 작다면 해당 숫자를 바로 append
            if(current % N < 10){
            	//System.out.println(N +  "  " + current);
//            	System.out.println(current % N);
                sb.append(current % N);
                
            // 만약 N이 10보다 큰 경우, N으로 나누었는데 10 이상이면 A, B등으로 표현하므로 기존 숫자는 10진법이므로 10만큼 빼고 'A'를 더한다. 
            // 왜냐면 1~9까지는 숫자로 표기하지만, 10 부터는 'A', 'B' 순서로 나타내기 때문이다.
            // 나머지가 10이라면 'A' + 10이 아니라 'A'로 나타내야 하기 때문
            } else {
            	System.out.println(current % N);
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }
//        StringBuilder의 reverse를 사용해야 정상적으로 출력 가능. 안그러면 거꾸로 출력됨
//        System.out.println("숫자 : " + number + "를 " + N + "진법으로 변환한 수 : " + sb.reverse().toString());
        String temp = sb.reverse().toString();
        if(sb.length() != length) {
        	int ll = length - sb.length();
        	
        	for (int i = 0; i < ll; i++) {
				temp = "0"+temp;
			}
        	
        }
        return temp;
    }
}