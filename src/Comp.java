import java.util.Scanner;

public class Comp {

	public void compute(int n){
		double time, sec, hour, year;
		time = 500000 * Math.log(n)/Math.log(2);
		sec = time * Math.pow(10, 6);
		hour = time * 3.6 * Math.pow(10, 9);
		year = time * 365 * 24 * 3.6 * Math.pow(10, 9);
		
		System.out.println("f1" + "(" + n + ") : ");
		System.out.println("1 sec : " + sec + " 1 hour : " + hour + " 1 year : " + year);
		
		time = (n*n*n)/100 + (n*n);
		sec = time * Math.pow(10, 6);
		hour = time * 3.6 * Math.pow(10, 9);
		year = time * 365 * 24 * 3.6 * Math.pow(10, 9);
		
		System.out.println("f2" + "(" + n + ") : ");
		System.out.println("1 sec : " + sec + " 1 hour : " + hour + " 1 year : " + year);
		
		time = 50*(n * n) + n;
		sec = time * Math.pow(10, 6);
		hour = time * 3.6 * Math.pow(10, 9);
		year = time * 365 * 24 * 3.6 * Math.pow(10, 9);
		
		System.out.println("f3" + "(" + n + ") : ");
		System.out.println("1 sec : " + sec + " 1 hour : " + hour + " 1 year : " + year);
		
		time = Math.pow(2, n)/100000;
		sec = time * Math.pow(10, 6);
		hour = time * 3.6 * Math.pow(10, 9);
		year = time * 365 * 24 * 3.6 * Math.pow(10, 9);
		
		System.out.println("f4" + "(" + n + ") : ");
		System.out.println("1 sec : " + sec + " 1 hour : " + hour + " 1 year : " + year);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the value of n : ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Comp c = new Comp();
		c.compute(n);
	}

}
