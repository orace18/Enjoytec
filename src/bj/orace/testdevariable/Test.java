package bj.orace.testdevariable;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez une valeur:");
        Integer value = sc.nextInt();


        System.out.println(value < 0 ? "Negative" : "positive");

}
}
