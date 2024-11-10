import java.io.*;
import java.util.*;

class Main{
    final static long p = 1000000007;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        
        long number = factorial(n);
        
        long denom = factorial(k) * factorial(n - k) % p;
        
        System.out.println(number * pow(denom, p - 2) % p);
    }
	
	static long pow(long base, long exponent) {
		if(exponent == 1) {
			return base % p;
		}
		
		long temp = pow(base, exponent / 2);
		
		if(exponent % 2 == 1) {
			return (temp * temp % p) * base % p;
		}
		return temp * temp % p;
	}
	
	static long factorial(long n) {
		long fac = 1L;
		
		while(n > 1) {
			fac = (fac * n) % p;
			n--;
		}
		return fac;
	}
}