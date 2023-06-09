package main.java;

import java.util.*;

public class TernaryFlip {
	public static void main(String[] args) {
		System.out.println(solution(45));
	}
	
	public static int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
	    
	    while(n > 0){
            sb.append(n % 3);
            n /= 3;
	    }
	    System.out.println(sb);
	    
	    char[] nums = sb.toString().toCharArray(); // char의 배열로 만들어서 하나씩 숫자별로 대응
	    
	    for(int i=0; i < nums.length; i++){
	    	answer = answer * 3 + (nums[i] - '0');
        }
        
        return answer;
    }
	
	 public static void conversion(int number, int N){
	        StringBuilder sb = new StringBuilder();
		    int current = number;
		    
	        // 진법 변환할 숫자가 0보다 큰 경우 지속 진행
	        while(current > 0){
	            // 만약 N으로 나누었는데 10보다 작다면 해당 숫자를 바로 append
	            if(current % N < 10){
	            	System.out.println(N +  "  " + current);
	            	System.out.println(current % N);
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
	        // StringBuilder의 reverse를 사용해야 정상적으로 출력 가능. 안그러면 거꾸로 출력됨
	        System.out.println("숫자 : " + number + "를 " + N + "진법으로 변환한 수 : " + sb.reverse());
	    }
	 
	 public static void converse_ten(String number, int N){
	        char[] nums = number.toCharArray(); // char의 배열로 만들어서 하나씩 숫자별로 대응
	        int ans = 0; // 시작은 0으로 시작
	        
	        // 아래에서 ans를 0으로 시작하고 계속 N(기존 진법)을 곱하고 있다.
	        // 이는, 앞자리의 숫자는 전체 m자리라면 m-1승 까지 곱해야 하기 때문
	        // 1의 자리는 0승 곱하면 되기 때문에 0으로 시작하는 것임
	        for(int i=0; i < nums.length; i++){
	            // 'A'이상의 숫자, 즉 10이상의 경우에는 'A'를 빼고 10을 더하면 원래 숫자가 됨
	            if(nums[i] >= 'A'){
	                ans = ans * N + (nums[i] - 'A' + 10);
	            // 그 이하는 단순히 '0'만 빼면 된다.     
	            } else {
	                ans = ans * N + (nums[i] - '0');
	            }
	        }
	        System.out.println(ans);
	    }
}