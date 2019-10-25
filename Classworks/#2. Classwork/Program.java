package Classwork_2;

public class Program {
	public static void main (String[] args) {
		
		int arr[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		int minNumber, tempNumber;
	
		for (int index = 0; index < arr.length -1; index++) {
			minNumber = index;
			for (int find = index + 1; find < arr.length; find++) {
				if (arr[find] < arr[minNumber]) {
					minNumber = find;
				}
			}
			tempNumber = arr[minNumber];
			arr[minNumber] = arr[index];
			arr[index] = tempNumber;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "");
		}
	}
}
