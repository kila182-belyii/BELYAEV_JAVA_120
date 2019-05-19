import java.util.Scanner;

class Program{
	
	public static int sum(int array[]) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i]; 
		}
		return result;
	}
	
	public static int[] getVectorOfFrequency(int array[]) {
		int[] result = new int[1001];
		for (int i = 0; i <array.length; i++) {
			result[array[i]]++;
		}
		return result;
	}
	
	public static double average(int array[]) {
		return (double) sum(array) / array.length;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input length of Array:");
		
		int lengthOfArray = scanner.nextInt();
		int[] array = new int[lengthOfArray];
	
		for(int i = 0; i < array.length; i++) {
			System.out.println("Input ArrayNumber of index" + "[" + i + "]");
			array[i] = scanner.nextInt();
		}
		
		System.out.println("Please input '1' for sum of array");
		System.out.println("Please input '2' for gystograma of array");
		System.out.println("Please input '3' for average of array");
		
		 
		int userNumber = scanner.nextInt();
		if (userNumber == 1) {
			System.out.println(sum(array));
		}
		if (userNumber == 2) {
			int[] result = getVectorOfFrequency(array);
			for (int i = 1; i < result.length; i++) {
				if(result[i] > 0) {
					System.out.println("Index " + i + ":" + result[i]);
				}
			}
		}
		if (userNumber == 3) {
			System.out.println(average(array));
		}
		scanner.close();
	}
}