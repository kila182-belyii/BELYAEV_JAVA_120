package Classwork_3;

public class Program {
	public int[] Sort () {
		
		int arr[] = {-1, 5, -3, 20, 11, 0, 2, 6};
		int i = 0;
		int j = 0;
		
		while(true) {
			if(arr[i] > arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				j = 0;
			}	else {
					j++;
				}
			i++;
			if (i == arr.length - 1) {
				i = 0;
			}
			if (j == arr.length -1) {
				break;
			}
		}
		return arr;
	}
}
