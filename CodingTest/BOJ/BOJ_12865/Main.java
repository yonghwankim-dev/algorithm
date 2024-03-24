package BOJ.BOJ_12865;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int solution(int n, int k, int[] weight, int[] value)
	{
		int[][] V = new int[n+1][k+1];
		
		for(int i=1;i<=n;i++)
		{
			for(int w=1; w<=k; w++)
			{
				if(weight[i]<=w)
				{
					if(value[i]+V[i-1][w-weight[i]] >= V[i-1][w])
					{
						V[i][w] = value[i]+V[i-1][w-weight[i]];
					}
					else
					{
						V[i][w] = V[i-1][w];
					}
				}
				else
				{
					V[i][w] = V[i-1][w];
				}
			}
		}
		
		return V[n][k];
	}
		
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		
		for(int i=1;i<=n;i++)
		{
			str = br.readLine().split(" ");
			weight[i] = Integer.parseInt(str[0]);
			value[i] = Integer.parseInt(str[1]);
		}
		System.out.println(solution(n,k,weight,value));
		
	}
}
