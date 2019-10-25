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
		        System.out.println(number0);
		        arr[number0]++;
		    }
		    
			for (int i = 0; i <10; i++) {
				System.out.println(i + "-" + arr[i]);
			}
		}
		scanner.close();
	}
}
