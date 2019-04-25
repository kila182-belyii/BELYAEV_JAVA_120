import java.util.Scanner;
public class Program{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number0 = scanner.nextInt();
		int sum0 = 0;
		int x0 = number0 % 10;
        int x1 = number0 / 10;
        
        
        while(number0 != 0){
			sum0 = x0 + x1;
			break;
        }
			System.out.println(sum0);
		
		int number1 = scanner.nextInt();
		int sum1 = 0;
		int x2 = number1 % 10;
        int x3 = number1 / 10;
        while(number1 != 0){
			sum1 = x2 * x3;
			break;
		}
			System.out.println(sum1);
			
		while (sum1 %2 !=0){
			 System.out.println("Please repeat");
			 number1 = scanner.nextInt();
			 x2 = number1 % 10;
			 x3 = number1 / 10;
			 sum1 = x2 * x3;
			 }
		System.out.println(sum1);
		scanner.close();
}
		}

