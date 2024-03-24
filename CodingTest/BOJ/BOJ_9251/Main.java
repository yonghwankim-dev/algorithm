package BOJ.BOJ_9251;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static int lcs(int m, int n, String x, String y, int[][] c)
	{
		for(int i=0; i<=m; i++)
		{
			c[i][0] = 0;
		}
		for(int j=0; j<=n; j++)
		{
			c[0][j] = 0;
		}
		
		for(int i=0; i<=m; i++)
		{
			for(int j=0; j<=n; j++)
			{
				if(i==0 || j==0)
				{
					continue;
				}
				else
				{
					if(x.charAt(i)==y.charAt(j))
					{
						c[i][j] = c[i-1][j-1] + 1;
					}
					else
					{
						c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
					}
				}
			}
		}
		
		return c[m][n];
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String x = " " + br.readLine();
		String y = " " + br.readLine();
		int[][] c = new int[x.length()+1][y.length()+1];
		int m = x.length()-1;
		int n = y.length()-1;
		
		System.out.println(lcs(m, n, x, y, c));
	}
}
