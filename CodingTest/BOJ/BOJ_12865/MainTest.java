package BOJ.BOJ_12865;


import org.junit.Test;

class MainTest {

	@Test
	void test(){
		int n = 4;
		int k = 7;
		int[] weight = {0,6,4,3,5};
		int[] value = {0,13,8,6,12};
		
		Main2.dp = new int[n+1][k+1];
		Main2.weight = weight;
		Main2.value = value;
		
		System.out.println(Main2.solution2(n,k));
	}

}
