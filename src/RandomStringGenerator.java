import java.util.Random;

public class RandomStringGenerator {
	public String genRanStr(int len, String[] input_type){
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
	}
}
