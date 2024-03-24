package BOJ.BOJ_12865;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	public static int[][] dp;
	public static int n;
	public static int k;
	public static int[] weight;
	public static int[] value;
	
	public static int solution2(int i, int w)
	{
		if(i==0)
		{
			return 0;
		}
		
		if(weight[i]<=w)
		{
			if(dp[i-1][w-weight[i]]==0)
			{
				dp[i-1][w-weight[i]] = solution2(i-1,w-weight[i]);
			}
			if(dp[i-1][w]==0)
			{
				dp[i-1][w] = solution2(i-1,w);
			}
			
			return dp[i][w] = Math.max(value[i]+dp[i-1][w-weight[i]], 
							dp[i-1][w]);
		}
		else
		{
			if(dp[i-1][w]==0)
			{
				return dp[i][w] = solution2(i-1,w);
			}
			else
			{
				return dp[i][w] = dp[i-1][w];
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		dp = new int[n+1][k+1];
		weight = new int[n+1];
		value = new int[n+1];
		
		for(int i=1;i<=n;i++)
		{
			str = br.readLine().split(" ");
			weight[i] = Integer.parseInt(str[0]);
			value[i] = Integer.parseInt(str[1]);
		}
		System.out.println(solution2(n,k));
		
	}
}
