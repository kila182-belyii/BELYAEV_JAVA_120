import java.util.Scanner;
public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberUser = 0;
		int number0 =0;
		int[]arr = new int[10];
		
		while (numberUser != -1) {
			numberUser = scanner.nextInt();
					
			for ( ;numberUser>0; numberUser /=10){
		        number0 = numberUser%10;
		        arr[number0]++;
		        while (numberUser <= 0) {
					numberUser = scanner.nextInt();
					
					for ( ;numberUser>0; numberUser /=10){
				        number0 = numberUser%10;
				        arr[number0]++;
				    	}
		        	}
		        }
		}
		System.out.println("1 - " + arr[1]);
		System.out.println("2 - " + arr[2]);
		System.out.println("3 - " + arr[3]);
		System.out.println("4 - " + arr[4]);
		System.out.println("5 - " + arr[5]);
		System.out.println("6 - " + arr[6]);
		System.out.println("7 - " + arr[7]);
		System.out.println("8 - " + arr[8]);
		System.out.println("9 - " + arr[9]);

		scanner.close();
	}
}
