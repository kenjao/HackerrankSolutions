import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


//Solved
public class LeftRotationSolution {
	 // Complete the rotLeft function below.
    static int[] rotateLeft(int[] array, int numberOfRotations) {
    	
//    	for(int i=0 ; i< numberOfRotations; i ++) {
//    		array = moveLeftOneAtATime(array);
//    	}
    	
    	array = jumpLeft(array, numberOfRotations);
    	
    	return array;
    }

    static int[] jumpLeft(int[] array, int numberOfRotations) {
    	int size = array.length;
    	int[] tempArray = new int[size];
    	int diff = 0;
    	int newIndex= 0;
    	for(int index=0; index< size ; index++) {
    		diff = index - numberOfRotations;
    		if(diff < 0) {
    			newIndex = size + diff;
    		}
    		else {
    			newIndex = diff;
    		}
    		
    		tempArray[newIndex] = array[index];
    	}
    	
    	return tempArray;
    }
    
    static int[] moveLeftOneAtATime(int[] array) {
    	int size = array.length;
    	int[] tempArray = new int[size];
    	for(int j=0; j< size; j++) {
			if(j == 0) {
    			tempArray[size -1 ] = array[0];
    			continue;
    		}
    		tempArray[j - 1] = array[j];
		}
    	array = null;
    	return tempArray;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotateLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
