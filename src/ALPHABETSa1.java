import java.util.Scanner;

/*Question 2 )

Write a Java program that:
Repeatedly asks the user for a character


Uses switch-case to:


Print "Vowel" if input is a, e, i, o, u


Print "Consonant" otherwise


Stops execution when user enters #
*/



public class ALPHABETSa1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch = sc.next().charAt(0);

        switch (ch) {
            case 'a':
                System.out.println("A is vovel");
            break;
            case 'e':
                System.out.println("e is vovel");
            break;
            case 'i':
                System.out.println("i is vovel");
            break;
            case 'o':
                System.out.println("o is vovel");
            break;
            case 'u':
                System.out.println("u is vovel");
            break;

            default:
                System.out.print(ch + "is not consonut");
        }

    }

}
