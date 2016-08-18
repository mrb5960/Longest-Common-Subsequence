
public class LCS_Hirschberg {
	
	String[] input_type1 = {"0","1"};
	String[] input_type2 = {"A","C","G","T"};
	// count to calculate recursion depth
	int rec_dep = 0;
	static double start_time, stop_time, time_taken;
	static String a, b, c, d, result;
	
	//method to reverse a string 
	public String revStr(String s) {	
		StringBuilder str = new StringBuilder();
		str.append(s);
		str = str.reverse();

		return str.toString();
	}

	// method to perform algorithm B of hirschberg 
	// accepts two strings and their lengths as the input
	public int[] algoB(String input1, String input2, int strlen1, int strlen2) {

		// initializing rows to zero
		int[][] k = new int[2][strlen2 + 1];
		for( int j = 0; j <= strlen2; j++) {
			k[1][j] = 0;
		}

		// copying values of row k[1][-] to k[0][-]
		for(int i = 1; i <= strlen1; i++) {
			for(int j = 0; j <= strlen2; j++) {
				k[0][j] = k[1][j];
			}

			for(int j = 1; j <= strlen2; j++) {
				// if characters are equal add one to the diagonal value
				if(input1.charAt(i-1) == input2.charAt(j-1))
					k[1][j] = k[0][j-1] + 1;
				// else take the maximum of k[1][..], k[0][..]
				else
					k[1][j] = Math.max(k[1][j-1], k[0][j]);
			}
		}
		return k[1];
	}

	// method to perform algorithm C of hirschberg 
	// accepts two strings and their lengths as the input
	public String algoC(String input1, String input2, int strlen1, int strlen2) {
		String lcs = "";
		int i=0, j=0, x=0, k=0;
		
		// if length of second string is zero
		if(strlen2 == 0)
			lcs = "";
		
		// if length of first string is 1
		else if(strlen1 == 1) {
			lcs = "";
			for( j = 0; j < strlen2; j++ ) {
				// if the character is equal to any of 
				// the character in string two
				if( input1.charAt(0) == input2.charAt(j) ) {
					lcs = "" + input1.charAt(0);
					break;
				}
			}

		} 
		
		// divide into sub problems
		else {
			// dividing the length of first string by 2
			i = (int) Math.floor(((double)strlen1)/2);

			// solve the subproblems
			int[] k1 = algoB(input1.substring(0,i), input2, i, strlen2);
			int[] k2 = algoB(revStr(input1.substring(i)), revStr(input2), strlen1 - i, strlen2);

			// calculate the value of k
			for(j=0; j<=strlen2; j++) {	
				if(x < (k1[j] + k2[strlen2-j])) {
					x = k1[j] + k2[strlen2-j];
					k = j;
				}
			}

			// recursive calls to algoC
			String part1 = algoC(input1.substring(0, i), input2.substring(0, k), i, k);
			String part2 = algoC(input1.substring(i), input2.substring(k), strlen1 - i, strlen2 - k);

			// concatenating the above strings
			lcs = part1 + part2;
		}
		// return the lcs
		return lcs;
	}

	public static void main(String args[]){
		LCS_Hirschberg demo = new LCS_Hirschberg();
		RandomStringGenerator rsg = new RandomStringGenerator();
		// length of the string starting from 5
		for(int i = 0;; i++){
			// generating random string of length i which is incremented gradually
			// the strings will be of type 0 and 1 only
			a = rsg.genRanStr( i, demo.input_type1 );
			b = rsg.genRanStr( i, demo.input_type1 );
			
			// store the starting time
			start_time = System.nanoTime();
			result = demo.algoC( a, b, a.length(), b.length() );
			// store the end time
			stop_time = System.nanoTime();
			// calculate the time taken to find the sequence
			time_taken = stop_time - start_time;
			// if the time taken is greater than 10 seconds the program stops
			if(time_taken > 10000000000.00)break;
			// display content
			System.out.println("Length of input strings : " + i);
			System.out.println( "Input1 : " + a );
			System.out.println( "Input2 : " + b );
			System.out.println( /*result + */" len:" + result.length());
			System.out.println( "Time taken : " + time_taken);
			System.out.println("");

		}
		
		for(int i = 0; ; i++){
			// same procedure as above is followed but for different input types
			c = rsg.genRanStr( i, demo.input_type2 );
			d = rsg.genRanStr( i, demo.input_type2 );
			start_time = System.nanoTime();
			result = demo.algoC( c, d, c.length(), d.length() );
			stop_time = System.nanoTime();
			time_taken = stop_time - start_time;
			if(time_taken > 10000000000.00)break;
			System.out.println("Length of input strings : " + i);
			System.out.println( "Input1 : " + c );
			System.out.println( "Input2 : " + d );
			System.out.println( result + " len:" + result.length());
			System.out.println( "Time taken : " + time_taken );
			System.out.println("");
		}
		System.out.println("Done!!!");
	}
}


