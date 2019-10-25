import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numberOfSum = scanner.nextInt();
		int sum = 0;
	        
        while(numberOfSum != 0){
        	sum += numberOfSum % 10;
        	numberOfSum /= 10;
		}
			
		System.out.println(sum);
		
		int numberOfMult = scanner.nextInt();
		int mult = 1;
        
		while (numberOfMult % 2 !=0){
			System.out.println("Please repeat");
			numberOfMult = scanner.nextInt();
		}
		
		while(numberOfMult != 0){
			mult *= numberOfMult % 10;
			numberOfMult /= 10;
		}
		System.out.println(mult);
		scanner.close();
	}
}
	

