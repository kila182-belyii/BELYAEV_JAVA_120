import java.util.Arrays;

public class Program {
    
	public static void main(String[] args) {
        int[] arraySort = { 4, 8, -32, 15, 16, -87, 23, -1, 42 };
        int[] result = mergesort(arraySort);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergesort(int[] array) {
        int[] tempArray0 = Arrays.copyOf(array, array.length);
        int[] tempArray1 = new int[array.length];
        int[] result = mergesortInner(tempArray0, tempArray1, 0, array.length);
        return result;
    }

    public static int[] mergesortInner(int[] tempArray0, int[] tempArray1,
            int left, int rigth) {
        if (left >= rigth - 1) {
            return tempArray0;
        }
        
        int middle = left + (rigth - left) / 2;
        int[] sorted0 = mergesortInner(tempArray0, tempArray1, left, middle);
        int[] sorted1 = mergesortInner(tempArray0, tempArray1, middle, rigth);
        
        int index0 = left;
        int index1 = middle;
        int destIndex = left;
        int[] result;
       
        if(sorted0 == tempArray0) {
        	result = tempArray1;
        } else {
        	result = tempArray0;
        }
        while (index0 < middle && index1 < rigth) {
            if(sorted0[index0] < sorted1[index1]) {
            	result[destIndex++] = sorted0[index0++];
            } else {
            	result[destIndex++] = sorted1[index1++];
            }
        }
        while (index0 < middle) {
            result[destIndex++] = sorted0[index0++];
        }
        while (index1 < rigth) {
            result[destIndex++] = sorted1[index1++];
        }
        return result;
    }
}