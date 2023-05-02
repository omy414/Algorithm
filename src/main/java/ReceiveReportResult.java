package main.java;


import java.util.*;
import java.util.stream.Collectors;


public class ReceiveReportResult {
	//2023-05-01
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"muzi", "frodo", "apeach", "neo"}, new String[] {"muzi frodo", "apeach frodo", "apeach neo", "muzi neo"}, 1));
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList list = new ArrayList();
        
        for (int i = 0; i < report.length; i++) {
        	list.add(report[i]);
		}
        
        list = (ArrayList)list.stream().distinct().collect(Collectors.toList());
        
        
        Map idList = new HashMap();
        
        for (int i = 0; i < id_list.length; i++) {
			idList.put(id_list[i], 0);
		}
        
        
        Map check = new HashMap();
        ArrayList rtn = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i).toString();
			String[] temp2 = temp.split(" ");
			
			
			if(check.get(temp2[1]) == null) {
				check.put(temp2[1], 1);
				
				if(k == 1) {
					rtn.add(temp2[1]);
				}
			}else {
				check.put(temp2[1], Integer.parseInt(check.get(temp2[1]).toString()) +1);
				
				if(k == Integer.parseInt(check.get(temp2[1]).toString())) {
					rtn.add(temp2[1]);
				}
			}
		}
        
        System.out.println("rtn " + rtn);
        
		for (int j = 0; j < list.size(); j++) {
			String list_temp = list.get(j).toString();
			String[] list_temp2 = list_temp.split(" ");
			
			for (int i = 0; i < rtn.size(); i++) {
				String temp = rtn.get(i).toString();
				System.out.println("temp : " + temp);
			
				if(temp.equals(list_temp2[1])) {
					System.out.println("list : " + list_temp2[0]);
					idList.put(list_temp2[0], Integer.parseInt(idList.get(list_temp2[0]).toString()) +1); 
				}
			}
		}
		
        
        System.out.println(idList);
        
        for (int i = 0; i < idList.size(); i++) {
        	int temp = Integer.parseInt(idList.get(id_list[i]).toString());
        	
        	answer[i] = temp;
        	 System.out.println("answer[" +i +"] : " + answer[i]);
		}
      
        return answer;
    }
	
}