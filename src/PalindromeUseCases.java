import java.util.*;

public class PalindromeUseCases {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // UC1 — Application Entry & Welcome Message
        System.out.println("PALINDROME CHECKER APPLICATION");
        System.out.println("1. Hardcoded Result");
        System.out.println("2. String Reverse Method");
        System.out.println("3. Character Array Method");
        System.out.println("4. Stack Method");
        System.out.println("5. Queue + Stack Method");
        System.out.println("6. Deque Optimized Method");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> hardcodedPalindrome();
            case 2 -> stringReverse(sc);
            case 3 -> charArrayCheck(sc);
            case 4 -> stackCheck(sc);
            case 5 -> queueStackCheck(sc);
            case 6 -> dequeCheck(sc);
            default -> System.out.println("Invalid choice");
        }
    }

    // UC2 — Hardcoded Palindrome Result
    static void hardcodedPalindrome() {
        System.out.println("Hardcoded word: MADAM");
        System.out.println("MADAM is a palindrome");
    }

    // UC3 — String Reverse Method
    static void stringReverse(Scanner sc) {
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();

        if (input.equalsIgnoreCase(reversed))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }

    // UC4 — Character Array Method
    static void charArrayCheck(Scanner sc) {
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        char[] arr = input.toCharArray();
        boolean isPalindrome = true;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }

    // UC5 — Stack Method
    static void stackCheck(Scanner sc) {
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray())
            stack.push(c);

        String reversed = "";
        while (!stack.isEmpty())
            reversed += stack.pop();

        System.out.println(input.equals(reversed) ? "Palindrome" : "Not Palindrome");
    }

    // UC6 — Queue + Stack Method
    static void queueStackCheck(Scanner sc) {
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }

    // UC7 — Deque Optimized Method
    static void dequeCheck(Scanner sc) {
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray())
            deque.add(c);

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }
}