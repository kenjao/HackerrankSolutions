import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

//Solved
public class StackSolution {

    private static final Scanner scanner = new Scanner(System.in);
    private static Stack<Character> stack = new Stack<Character>();

    public static void main(String[] args) {
        int size = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int exp = 0; exp < size; exp++) {
            String expression = scanner.nextLine();
            System.out.println(expressionValid(expression) ? "YES" : "NO");
        }

        scanner.close();
    }
    
    private static boolean expressionValid(String expression) {
    	/*if((expression.length() % 2) == 1) {
    		System.out.println("Not even");
    		return false;
    	}*/
    	
    	char[] charactaArray = expression.toCharArray();
    	char braceInStack = '@';
    	char currentCharacta = '#';
    	boolean opening = false;
    	boolean closing = false;
    	
    	stack.clear();
    	for(int i = 0; i< charactaArray.length; i++ ) {
    		
    		currentCharacta = charactaArray[i];
    		opening = isOpeningBrace(currentCharacta);
    		closing = isClosingBrace(currentCharacta);
    		
    		if(opening) {
    			stack.push(currentCharacta);
    			continue;
    		}
    		
    		if(closing) {
    			try {
					braceInStack = stack.pop();
					if(!similarTypeBrace(braceInStack, currentCharacta)) {
						return false;
					}
				} catch (EmptyStackException e) {
					return false;
				}
    			continue;
    		}
    		
    		if(!closing && !opening) {
    			return false;
    		}
    	}
    	
    	if(!stack.isEmpty()) {
    		return false;
    	}
    	
    	return true;
    }
    
    private static boolean similarTypeBrace(char open, char close) {
    	switch (open) {
    	
    	case '(': return close == ')';
    	
    	case '{': return close == '}';
    	
    	case '[': return close == ']';
    	
    	default: return false;
    	}
    	
    }
    
    private static boolean isOpeningBrace(char characta) {
    	String openingExpressions = "({[";
    	if( openingExpressions.indexOf(characta) > -1) {
    		return true;
    	}
    	
    	return false;
    }
    
    private static boolean isClosingBrace(char characta) {
    	String closingExpressions = ")}]";
    	if( closingExpressions.indexOf(characta) > -1) {
    		return true;
    	}
    	
    	return false;
    }
}
