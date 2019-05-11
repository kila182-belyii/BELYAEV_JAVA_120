import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Input length of Array:");
		
		int UserNumber = scanner.nextInt();
		int ArrNumber = 0;
		int[] arr = new int[UserNumber];
	
		for(int i = 0; i < arr.length; i++) {
			
			System.out.println("Input ArrayNumber of index" + "[" + i + "]");
			
			ArrNumber = scanner.nextInt();
			arr[i] = ArrNumber;
		}
		
		int LocalMax = 0;
		int LocalMin = 0;
		
		for (int i = 1; i < arr.length-1; i++){
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                //System.out.println("LocalMax " + arr[i]);
                LocalMax++;
            } 
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]){
                //System.out.println("LocalMin " + arr[i]);
                LocalMin++;
            }
		}
		
		System.out.println("Count of Local Maximum = " + LocalMax);
		System.out.println("Count of Local Minimum = " + LocalMin);
        
		scanner.close();
	}
}
	
