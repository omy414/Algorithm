package main.java;

import java.util.*;

public class SecretMap {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {0, 0, 0, 0, 0}, new int[] {30, 1, 21, 17, 28}));
	}
	
	public static String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        
        String[] arr1String = new String[arr1.length];
        String[] arr2String = new String[arr2.length];
        
        for (int i = 0; i < arr1.length; i++) {
        	Long temp = (long)arr1[i];
			String sb1 = conversion(temp, 2, n);
			System.out.println("변환1 : " + sb1);
			
			arr1String[i] = sb1;
			
			temp = (long)arr2[i];
			String sb2 = conversion(temp, 2, n);
			arr2String[i] = sb2;
			System.out.println("변환2 : " + sb2);
			
			Long addNumber = (long)(Integer.parseInt(sb1) + Integer.parseInt(sb2));
			
			String convertNumber = String.valueOf(addNumber);
			System.out.println(convertNumber);
			
			if(convertNumber.length() != n) {
				Long ll = (long)(n - convertNumber.length());
	        	
	        	for (int k = 0; k < ll; k++) {
	        		convertNumber = "0"+convertNumber;
				}
			}
			
			System.out.println("후 : " + convertNumber);
			
			answer[i] = convertNumber.replaceAll("2", "#").replaceAll("1", "#").replaceAll("0", " ");
		}
        
        return answer;
    }
	
	public static String conversion(Long number, int N, int length){
        StringBuilder sb = new StringBuilder();
        Long current = number;
	    
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
        	Long ll = (long)(length - sb.length());
        	
        	for (int i = 0; i < ll; i++) {
				temp = "0"+temp;
			}
        	
        }
        return temp;
    }
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];       
        for(int i = 0; i < n; i++) {
            String biString = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            String appendZero = biString;
            for (int j = 0; j < (n - biString.length()); j++) {
            	appendZero = "0" + appendZero;
			}
            System.out.println(appendZero);
            answer[i] = appendZero.replaceAll("1", "#").replaceAll("0", " ");
        }
        return answer;
    }
}