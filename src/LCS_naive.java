import java.util.Random;

public class LCS_naive {
	
	String[] input_type1 = {"0","1"};
	String[] input_type2 = {"A","C","G","T"};
	// count to calculate recursion depth
	int rec_dep = 0;
	static double start_time, stop_time, time_taken;
	static String a, b, c, d, result;
	
	// length of the required random substring as input and input type
	/*public String genRanStr(int len, String[] input_type){
		int num;
		StringBuilder random = new StringBuilder();
		Random rand = new Random();
		// loop to get a string of the required length
		for(int i = 0; i < len; i++){
			// selects a random index based on the size of the array
			num = rand.nextInt(input_type.length);
			random = new StringBuilder(random + input_type[num]);
		}
		return random.toString();
	}*/
	
	public String LCSNaive(String input1, String input2){
		// increments recursion depth
		this.rec_dep++;
		// length of first input string
	    int len1 = input1.length();
	    // length of second input string
	    int len2 = input2.length();
	    // if any one string is empty return empty
	    if( len1 == 0 || len2 == 0 ){
	        return "";
	    }
	    // if the last character is same then calculate the remaining subsequence recursively
	    else if( input1.charAt ( len1 - 1 ) == input2.charAt ( len2 - 1 ) ){
	    	// recursive call to longestCommonSubsequence with the last character appended to the resultant string
	        return LCSNaive ( input1.substring ( 0, len1 - 1 ), input2.substring ( 0, len2 - 1 ) )
	            + input1.charAt ( len1 - 1 );
	    }
	    // if the last characters of the strings do not match, divide the problem into two subproblems
	    // and return the common sequence whose length is greater among the two problems
	    else{
	        String substr1 = LCSNaive ( input1, input2.substring ( 0, len2 - 1 ) );
	        String substr2 = LCSNaive ( input1.substring ( 0, len1 - 1 ), input2 );
	        if (substr1.length() > substr2.length())
	        	return substr1;
	        else
	        	return substr2;
	    }
	}
	
	
	
	public static void main(String args[]){
		RandomStringGenerator rsg = new RandomStringGenerator();
		LCS_naive demo = new LCS_naive();
		// length of the string starting from 5
		for(int i = 5; i < 100; i++){
			// generating random string of length i which is incremented gradually
			// the strings will be of type 0 and 1 only
			a = rsg.genRanStr( i, demo.input_type1 );
			b = rsg.genRanStr( i, demo.input_type1 );
			// store the starting time
			start_time = System.nanoTime();
			result = demo.LCSNaive( a, b );
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
			System.out.println( result + " len:" + result.length());
			System.out.println( "Time taken : " + time_taken);
			System.out.println( "Recursion depth : " + demo.rec_dep );
			System.out.println("");
		}
		
		for(int i = 5; i < 100; i++){
			// same procedure as above is followed but for different input types
			c = rsg.genRanStr( i, demo.input_type2 );
			d = rsg.genRanStr( i, demo.input_type2 );
			start_time = System.nanoTime();
			result = demo.LCSNaive( c, d );
			stop_time = System.nanoTime();
			time_taken = stop_time - start_time;
			if(time_taken > 5000000000.00)break;
			System.out.println("Length of input strings : " + i);
			System.out.println( "Input1 : " + c );
			System.out.println( "Input2 : " + d );
			System.out.println( result + " len:" + result.length());
			System.out.println( "Time taken : " + time_taken );
			System.out.println( "Recursion depth : " + demo.rec_dep );
			System.out.println("");
		}
		System.out.println("Done!!!");
	}
}
