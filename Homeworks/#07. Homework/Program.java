package Homework_7;
import java.util.Scanner;

public class Program {
	static boolean isPrime(int number) {
		boolean result = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) 
				result = false;
		}	
		return result;
	}
	
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("Number is Prime - " + (isPrime(number)));
		scanner.close();
	}		
}
