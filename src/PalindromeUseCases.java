
import java.util.*;

public class PalindromeUseCases {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("PALINDROME CHECKER APPLICATION");
        System.out.println("1 Hardcoded");
        System.out.println("2 String Reverse");
        System.out.println("3 Character Array");
        System.out.println("4 Stack");
        System.out.println("5 Queue + Stack");
        System.out.println("6 Deque");
        System.out.println("7 LinkedList");
        System.out.println("8 Recursive");
        System.out.println("9 Ignore Case & Spaces");
        System.out.println("10 OOP Service");
        System.out.println("11 Strategy Pattern");
        System.out.println("12 Performance");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice){

            case 1 -> hardcodedPalindrome();
            case 2 -> stringReverse(sc);
            case 3 -> charArrayCheck(sc);
            case 4 -> stackCheck(sc);
            case 5 -> queueStackCheck(sc);
            case 6 -> dequeCheck(sc);
            case 7 -> linkedListCheck(sc);
            case 8 -> recursiveCheck(sc);
            case 9 -> ignoreCaseSpace(sc);
            case 10 -> oopService(sc);
            case 11 -> strategyPattern(sc);
            case 12 -> performanceComparison();

            default -> System.out.println("Invalid choice");
        }
    }

    static void hardcodedPalindrome(){
        System.out.println("MADAM is a palindrome");
    }

    static void stringReverse(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println(input.equalsIgnoreCase(reversed) ? "Palindrome" : "Not Palindrome");
    }

    static void charArrayCheck(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        char[] arr = input.toCharArray();
        boolean isPalindrome = true;

        for(int i=0;i<arr.length/2;i++){

            if(arr[i] != arr[arr.length-1-i]){
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }

    static void stackCheck(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray())
            stack.push(c);

        String reversed = "";

        while(!stack.isEmpty())
            reversed += stack.pop();

        System.out.println(input.equals(reversed) ? "Palindrome" : "Not Palindrome");
    }

    static void queueStackCheck(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()){
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while(!queue.isEmpty()){

            if(!queue.remove().equals(stack.pop())){
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }

    static void dequeCheck(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : input.toCharArray())
            deque.add(c);

        boolean isPalindrome = true;

        while(deque.size()>1){

            if(!deque.removeFirst().equals(deque.removeLast())){
                isPalindrome=false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }

    static void linkedListCheck(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        LinkedList<Character> list = new LinkedList<>();

        for(char c : input.toCharArray())
            list.add(c);

        boolean isPalindrome = true;

        while(list.size()>1){

            if(!list.removeFirst().equals(list.removeLast())){
                isPalindrome=false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }

    static void recursiveCheck(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        boolean result = recursivePalindrome(input,0,input.length()-1);

        System.out.println(result ? "Palindrome" : "Not Palindrome");
    }

    static boolean recursivePalindrome(String str,int start,int end){

        if(start>=end)
            return true;

        if(str.charAt(start)!=str.charAt(end))
            return false;

        return recursivePalindrome(str,start+1,end-1);
    }

    static void ignoreCaseSpace(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        input = input.replaceAll("\\s","").toLowerCase();

        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println(input.equals(reversed) ? "Palindrome" : "Not Palindrome");
    }

    static void oopService(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        PalindromeService service = new PalindromeService();

        System.out.println(service.isPalindrome(input) ? "Palindrome" : "Not Palindrome");
    }

    static void strategyPattern(Scanner sc){

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy = new StringBuilderStrategy();

        System.out.println(strategy.check(input) ? "Palindrome" : "Not Palindrome");
    }

    static void performanceComparison(){

        String test = "racecar";

        long start = System.nanoTime();

        recursivePalindrome(test,0,test.length()-1);

        long end = System.nanoTime();

        System.out.println("Execution time: "+(end-start)+" ns");
    }
}

class PalindromeService{

    boolean isPalindrome(String text){

        String reversed = new StringBuilder(text).reverse().toString();

        return text.equals(reversed);
    }
}

interface PalindromeStrategy{

    boolean check(String text);
}

class StringBuilderStrategy implements PalindromeStrategy{

    public boolean check(String text){

        String reversed = new StringBuilder(text).reverse().toString();

        return text.equals(reversed);
    }
}
