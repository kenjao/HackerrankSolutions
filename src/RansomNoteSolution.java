import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class RansomNoteSolution {
	
	
	// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Hashtable<String, Integer> hashTable = new Hashtable<>();
    	if(magazine.length < note.length) {
    		System.out.println("No");
    		return;
    	}
    	
    	Integer val = null;
    	for(String key : magazine) {
    		val = hashTable.get(key);
    		if(val == null) {
    			hashTable.put(key, 1);
    		}else {
    			hashTable.put(key, val +1);
    		}
    		val = null;
    	}
    	
    	Integer found = null;
    	for(String word: note ) {
    		found = hashTable.get(word);
    		if(found == null) {
    			System.out.println("No");
    			return;
    		}
    		
    		if(found > 1) {
    			hashTable.put(word, found - 1);
    		}
    		
    		if(found == 1) {
    			hashTable.remove(word);
    		}
    		found = null;
    	}
    	
    	System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
