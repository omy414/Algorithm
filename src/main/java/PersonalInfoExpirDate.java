package main.java;

import java.util.*;

public class PersonalInfoExpirDate {
	
	public static void main(String[] args) {
		System.out.println(solution("2022.05.19", new String[] {"A 6", "B 12", "C 3"}, new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
	}
	
	public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        HashMap<String, String> temp = new HashMap();
        
        for(int i=0; i<terms.length; i++){
            temp.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
          
        ArrayList<Integer> result = new ArrayList();
        int convertToday = getDay(today);
        
        for(int i=0; i < privacies.length; i++){
            int period = getDay(privacies[i].split(" ")[0]);
            String type = privacies[i].split(" ")[1];
            
            String expired = temp.get(type);
            
            int convertExired = (Integer.parseInt(expired)*28);
            
            period += convertExired;
            
            System.out.println("계약만료 : " + period + " 지금 : " + convertToday);
            
            if(period <= convertToday) {
                result.add(i+1);    
            }
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public static int getDay(String date){
        int year = Integer.parseInt(date.split("\\.")[0]);
        int month = Integer.parseInt(date.split("\\.")[1]);
        int day = Integer.parseInt(date.split("\\.")[2]);
        
        int convertDate = ((year - 2017) *12) *28 + month*28 + day;
        return convertDate;
    }
}