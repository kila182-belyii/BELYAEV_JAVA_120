import java.util.Scanner;
public class Program {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Input length of Array:");
		
		int UserNumber = scanner.nextInt();
		int ArrNumber = 0;
		
		int[] arr = new int[UserNumber];
		
		int MaxValue = 0;
		int MinValue = 1000;
		int MaxIndex = 0;
		int MinIndex = 0;
					
		for(int i = 0; i < arr.length; i++) {
		System.out.println("Input ArrayNumber of index" + "[" + i + "]");
		ArrNumber = scanner.nextInt();
		arr[i] = ArrNumber;
			while(ArrNumber > MaxValue) {
				MaxValue = ArrNumber;
				MaxIndex = i;
			}
			while(ArrNumber < MinValue) {
				MinValue = ArrNumber;
				MinIndex = i;
		}
		}
		
		System.out.println("--------------------");
		System.out.println("Max and Min of Array");
		System.out.println("Max_Value " + MaxValue + " of index " + "[" + MaxIndex + "]");
		System.out.println("Min_Value " + MinValue + " of index " + "[" + MinIndex + "]");
		System.out.println("-------------------");
		
		MaxValue = arr[MinIndex];
		MinValue = arr[MaxIndex];
		
		System.out.println("");
		System.out.println("-------------------");
		System.out.println("Max=Min and Min=Max");
		System.out.println("Max_Value " + MaxValue + " of index " + "[" + MaxIndex + "]");
		System.out.println("Min_Value " + MinValue + " of index " + "[" + MinIndex + "]");
		System.out.println("-------------------");
		
		scanner.close();
	}
}
	

        

	

