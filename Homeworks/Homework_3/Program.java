import java.util.Scanner;
public class Program{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number0 = scanner.nextInt();
		int sum0 = 0;
	        
        while(number0 != 0){
        	sum0 += number0 % 10;
            number0 /= 10;
			}
			System.out.println(sum0);
		
		int number1 = scanner.nextInt();
		int sum1 = 1;
        while(number1 != 0){
        	sum1 *= number1 % 10;
            number1 /= 10;
			}
			System.out.println(sum1);
			
		while (sum1 % 2 !=0){
			System.out.println("Please repeat");
			number1 = scanner.nextInt();
			int sum2 = 1;
		while(number1 != 0){
			sum2 *= number1 % 10;
			number1 /= 10;
			sum1 = sum2;
				}
			System.out.println(sum2);
			 }
		
		scanner.close();
}
		}

