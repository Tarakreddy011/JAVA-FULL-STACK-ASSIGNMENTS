public class Assa2 {

    public String s2 = "java is fun";

    public static void Revstring() {
        String s = "hello";
        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        System.out.println(rev);
    }

    public static void Revstring2() {
        String s4 = "Hello";
        String rev4 = new StringBuilder(s4).reverse().toString();
        System.out.println(rev4);
    }

    public static Void Palindrome1() {
        String s1 = "madam";
        String rev1 = "";

        for (int i = s1.length() - 1; i >= 0; i--) {
            rev1 += s1.charAt(i);
        }
        System.out.println(rev1);
        System.out.println(s1.equals(rev1));
        return null;
    }

    /*public static void RevString1() {

        String s2 = "java is fun";
        String rev2 = "";

        for (int i = s2.length() - 1; i>= 0; i--) {
            rev2 += s2.charAt(i);
        }
        System.out.println(rev2);
    }*/

    public static void WordRev() {
        String s = "Java is awesome";
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        System.out.println(sb.toString().trim());




    }


    public static void main(String[] args) {
        Revstring();
        Revstring2();
        Palindrome1();
        //RevString1();
        WordRev();
    }
}
