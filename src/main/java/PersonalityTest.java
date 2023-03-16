package main.java;

import java.util.*;

public class PersonalityTest {
	
	
	/* 2023-03-16
	 * 프로그래머스
	 * java 성격 유형 검사하기
	 * Level 1
	 * lessons ( 118666 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
	}
	
	public static String solution(String[] survey, int[] choices) {
        String answer = "";
        String temp ="RCJA";
        
        int check1 = 4;
        int check2 = 4;
        int check3 = 4;
        int check4 = 4;
        
        for (int i = 0; i < survey.length; i++) {
			int num = choices[i];
			int count = 4;
			if(num == 4) {
				
			}else {
				String tt = survey[i];
				System.out.println(tt.charAt(1));
				String checkChoice = String.valueOf(tt.charAt(1));
				
				if(checkChoice.equals("A") || checkChoice.equals("N")) {
					if(checkChoice.equals("A")) {
						num = convert(num);
					}
					count = 4 - num;
					
					check4 += (-count);
				}else if(checkChoice.equals("R") || checkChoice.equals("T")) {
					if(checkChoice.equals("R")) {
						num = convert(num);
					}
					count = 4 - num;
					
					check1 += (-count);
				}else if(checkChoice.equals("J") || checkChoice.equals("M")) {
					if(checkChoice.equals("J")) {
						num = convert(num);
					}
					count = 4 - num;
					
					check3 += (-count);
				}else if(checkChoice.equals("C") || checkChoice.equals("F")) {
					if(checkChoice.equals("C")) {
						num = convert(num);
					}
					count = 4 - num;
					
					check2 += (-count);
				}
				
			}
        }
			
		if(check1 > 4) {
			temp = temp.replace("R", "T");
		}
		if(check2 > 4) {
			temp = temp.replace("C", "F");
		}
		if(check3 > 4) {
			temp = temp.replace("J", "M");
		}
		if(check4 > 4) {
			temp =temp.replace("A", "N");
		}
		
        answer = temp;
        
        return answer;
    }
	
	public static int convert(int num) {
		int result = 0;
		
		if(num == 1) {
			result = 7;
		}else if(num == 2) {
			result = 6;
		}else if(num == 3) {
			result = 5;
		}else if(num == 4) {
			result = 4;
		}else if(num == 5) {
			result = 3;
		}else if(num == 6) {
			result = 2;
		}else if(num == 7) {
			result = 1;
		}
		
		return result;
	}
}