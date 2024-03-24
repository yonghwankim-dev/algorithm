package PROM.PROM_76501;


class Solution{
	
    public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			answer += absolutes[i] * (signs[i] ? 1 : -1);
		}
		return answer;
	}
}