package bj.orace.testdevariable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("entrez votre phrase");

        String phrase = scanner.nextLine();

        char[] lettre = phrase.toCharArray();
        String mot = "";

        System.out.println(inverse(phrase));

    }

    public static String inverse(String phrase){
        char[] lettre = phrase.toCharArray();
        String mot = "";

        for (int i = lettre.length -1; i >= 0; i--) {
            mot += lettre[i];
        }
        return mot;
    }
}
