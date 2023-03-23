package main.java;

class RoughKeyboard{
	
	
	/* 2023-03-23
	 * 프로그래머스
	 * java 대충 만든 자판
	 * Level 1 
	 * lessons ( 160586 )
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD","AABB"}));
	}
	
	//지정된 keymap 이 존재하고 
	//target을 지정된 keymap 으로 최소한의 입력횟수로 치는걸 체크
	
	//ex) target 의 A를 치려면 1번 키맵에서 한번
	// B를 치려면 2번 키맵에서 한번
	// C를 치려면 2번 키맵에서 두번
	
	//이런식으로해서 한 target마다 몇번을 눌러야하는지 체크해서 result
	public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        
        for (int i = 0; i < targets.length; i++) {
        	int sum = 0;
			String temp = targets[i];
			System.out.println(temp);
			for (int j = 0; j < temp.length(); j++) {
				int count = 100;
				String temp2 = String.valueOf(temp.charAt(j));
				System.out.println("템프? : " + temp2);
				for (int k = 0; k < keymap.length; k++) {
					String keymapData = keymap[k];
					int check = keymapData.indexOf(temp2);
					if(check < count && check != -1) {
						count = check +1; 
						System.out.println("카운트 ? : " +  count);
					}
				}
				if(count == 100) {
					sum = -1;
					break;
				}else {
					sum+=count;
				}
				
			}
			System.out.println("========   전체합 : " + sum);
			answer[i] = sum;
			
		}
        
        return answer;
    }
}