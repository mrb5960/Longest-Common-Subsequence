import java.util.ArrayList;

public class LCS_memo {

	String[] input_type1 = {"0","1"};
	String[] input_type2 = {"A","C","G","T"};
	String[] input_type3 = new String[26];
	
	// count to calculate recursion depth
	int rec_dep = 0;
	static int temp;
	static ArrayList<String> temp1;
	static double start_time, stop_time, time_taken;
	static String a, b, c, d, result;
	// array to store the memoized results
	static int[][] mat;

	public int LCSMemo(String x, String y, int len1, int len2)
	{
		// calculate the recursion depth
		rec_dep++;
		
		// variables to store the length
		int lcs1, lcs2;

		// base condition
		if (len1 == 0 || len2 == 0)
			return 0;

		// if the result has already been calculated then return it
		if ( mat[len1][len2] >= 0 )
			return mat[len1][len2];

		// if the characters are same 1 is added to the sequence and 
		// next character in the remaining strings is found
		if ( x.charAt(len1 - 1) == y.charAt(len2 - 1) )
		{
			mat[len1][len2] = LCSMemo(x, y, len1 - 1, len2 - 1) + 1;
			return mat[len1][len2];
		}
		else
		{
			// consider the remaining x and all y
			lcs1 = LCSMemo(x, y, len1 - 1, len2);
			
			// consider remaining y and all x
			lcs2 = LCSMemo(x, y, len1, len2 - 1);
			
			// store the value of the maximum of the above two
			if(lcs1 >= lcs2)
				mat[len1][len2] = lcs1;
			else
				mat[len1][len2] = lcs2;
			
			return mat[len1][len2];
		}
	}
	
	// this method calculates the subsequence from the obtained matrix mat
	// It returns the subsequence in an arraylist
	public ArrayList<String> getSS(String a, String b){
		int i = 0, j = 0, result_index = 0;
		// arraylist to store the result
		ArrayList<String> result = new ArrayList<String>();

		while ( i < a.length() && j < b.length()){
			// if characters are found same then add them to the subsequence
			if ( a.charAt(i) == b.charAt(j)){
				result.add(result_index, a.substring(i, i+1));
				// increments the index of the arraylist to store the next
				// character
				result_index++;
				// move diagonally in the matrix
				i++;
				j++;
			}
			// move to the next cell whose value is maximum
			else if( mat [ i+1][j]  >= mat[i][j+1])
				i++;
			else
				j++;
		}
		return result;
	}

	
	public static void main(String args[]){
		RandomStringGenerator rsg = new RandomStringGenerator();
		LCS_memo demo = new LCS_memo();
		
		// length of the string starting from 5
		for(int i = 5;; i++){
			// generating random string of length i which is incremented gradually
			// the strings will be of type 0 and 1 only
			a = rsg.genRanStr( i, demo.input_type1 );
			b = rsg.genRanStr( i, demo.input_type1 );
			mat = new int[i+1][i+1];
			
			// store the starting time
			start_time = System.nanoTime();
			temp = demo.LCSMemo( a, b, a.length(), b.length() );
			temp1 = demo.getSS(a, b);
			// store the end time
			stop_time = System.nanoTime();
			// calculate the time taken to find the sequence
			time_taken = stop_time - start_time;
			// if the time taken is greater than 10 seconds the program stops
			if(time_taken > 5000000000.00)break;
			// display content
			System.out.println("Length of input strings : " + i);
			System.out.println( "Input1 : " + a );
			System.out.println( "Input2 : " + b );
			System.out.println( /*result +*/ " len:" + temp1.size());
			System.out.println( "Time taken : " + time_taken);
			System.out.println( "Recursion depth : " + demo.rec_dep );
			System.out.println("");
		}

		for(int i = 5;; i ++){
			// same procedure as above is followed but for different input types
			c = rsg.genRanStr( i, demo.input_type2 );
			d = rsg.genRanStr( i, demo.input_type2 );
			start_time = System.nanoTime();
			temp = demo.LCSMemo( c, d, c.length(), d.length());
			temp1 = demo.getSS(a, b);
			stop_time = System.nanoTime();
			time_taken = stop_time - start_time;
			if(time_taken > 5000000000.00)break;
			System.out.println("Length of input strings : " + i);
			System.out.println( "Input1 : " + c );
			System.out.println( "Input2 : " + d );
			System.out.println( /*result +*/ " len:" + temp1.size());
			System.out.println( "Time taken : " + time_taken );
			System.out.println( "Recursion depth : " + demo.rec_dep );
			System.out.println("");
		}
		
		System.out.println("Done!!!");
	}
}
