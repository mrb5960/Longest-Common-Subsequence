
public class LCS_dynamic {
	String[] input_type1 = {"0","1"};
	String[] input_type2 = {"A","C","G","T"};
	// count to calculate recursion depth
	int rec_dep = 0;
	static double start_time, stop_time, time_taken;
	static String a, b, c, d, result;
	
	public String LCSDynamic(String input1, String input2){
		int x = 0, y = 0;
		StringBuilder out = new StringBuilder();
		int len1 = input1.length();
		int len2 = input2.length();
		
		// create a matrix to calculate LCS dynamically
		int[][] mat = new int[len1+1][len2+1];
		
		// find the values for the matrix
		// start from the end of the string to avoid string reversal
		for(int i = len1 - 1; i >= 0; i--){
			for(int j = len2 - 1; j >= 0; j--){
				if(input1.charAt(i) == input2.charAt(j))
					mat[i][j] = mat[i+1][j+1] + 1;
				else
					mat[i][j] = Math.max(mat[i+1][j], mat[i][j+1]);
			}
		}
		
		// finding the LCS using backtracking
		while(x < len1 && y < len2){
			// add character to the StringBuilder if same
			if(input1.charAt(x) == input2.charAt(y)){
				out.append(String.valueOf(input1.charAt(x)));
				x++;
				y++;
			}
			else if(mat[x+1][y] >= mat[x][y+1])
				x++;
			else 
				y++;			
		}
		return out.toString();
	}
	
	public static void main(String args[]){
		RandomStringGenerator rsg = new RandomStringGenerator();
		LCS_dynamic demo = new LCS_dynamic();
		// length of the string starting from 5
		/*for(int i = 10000; ; ){
			// generating random string of length i which is incremented gradually
			// the strings will be of type 0 and 1 only
			a = rsg.genRanStr( i, demo.input_type1 );
			b = rsg.genRanStr( i, demo.input_type1 );
			
			// store the starting time
			start_time = System.nanoTime();
			result = demo.LCSDynamic( a, b );
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
			System.out.println( result + " len:" + result.length());
			System.out.println( "Time taken : " + time_taken);
			System.out.println("");
			i = i + 10000;
		}
		*/
		for(int i = 10000; ; ){
			// same procedure as above is followed but for different input types
			c = rsg.genRanStr( i, demo.input_type2 );
			d = rsg.genRanStr( i, demo.input_type2 );
			start_time = System.nanoTime();
			result = demo.LCSDynamic( c, d );
			stop_time = System.nanoTime();
			time_taken = stop_time - start_time;
			if(time_taken > 10000000000.00)break;
			System.out.println("Length of input strings : " + i);
			/*System.out.println( "Input1 : " + c );
			System.out.println( "Input2 : " + d );*/
			System.out.println( result + " len:" + result.length());
			System.out.println( "Time taken : " + time_taken );
			System.out.println("");
			i = i + 10000;
		}
		System.out.println("Done!!!");
	}
}
