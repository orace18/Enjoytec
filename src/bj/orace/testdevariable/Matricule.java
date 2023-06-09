package bj.orace.testdevariable;
import java.util.Scanner;

public class Matricule {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez le matricule : ");
            String matricule = scanner.nextLine();

            System.out.print("Entrez le facteur de pondération (séparé par des espaces) : ");
            String facteurPondStr = scanner.nextLine();
            String[] facteurPondArr = facteurPondStr.split(" ");
            int[] facteurPond = new int[facteurPondArr.length];
            for (int i = 0; i < facteurPondArr.length; i++) {
                facteurPond[i] = Integer.parseInt(facteurPondArr[i]);
            }

            int[] matriculeSecurise = securiserMatricule(matricule, facteurPond);

            System.out.print("Matricule sécurisé : ");
            for (int digit : matriculeSecurise) {
                System.out.print(digit + " ");
            }
        }

        public static int[] securiserMatricule(String matricule, int[] facteurPond) {
            int[] matriculeArr = new int[matricule.length()];
            for (int i = 0; i < matricule.length(); i++) {
                matriculeArr[i] = Character.getNumericValue(matricule.charAt(i));
            }

            int[] produits = new int[matriculeArr.length];
            for (int i = 0; i < matriculeArr.length; i++) {
                produits[i] = matriculeArr[i] * facteurPond[i % facteurPond.length];
            }

            int somme = 0;
            for (int produit : produits) {
                somme += sumDigits(produit);
            }

            int cle = (10 - (somme % 10)) % 10;

            int[] matriculeSecurise = new int[matriculeArr.length + 1];
            System.arraycopy(matriculeArr, 0, matriculeSecurise, 0, matriculeArr.length);
            matriculeSecurise[matriculeArr.length] = cle;

            return matriculeSecurise;
        }

        public static int sumDigits(int number) {
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }
    }

/***
 * **Programme pour sécuriser un matricule :**
 *
 *         1. On commence par demander à l'utilisateur d'entrer le matricule et le facteur de pondération.
 *         2. Le matricule et le facteur de pondération sont lus depuis la console à l'aide de la classe `Scanner`.
 *         3. Le matricule est une chaîne de caractères, donc nous la convertissons en un tableau d'entiers à l'aide de la boucle `for` et la méthode `Character.getNumericValue()`. Chaque caractère du matricule est converti en sa valeur numérique correspondante.
 *         4. Le facteur de pondération est une chaîne de caractères contenant les poids séparés par des espaces. Nous la divisons en un tableau de nombres entiers à l'aide de la méthode `split()` et nous parcourons ensuite chaque élément pour les convertir en entiers.
 *         5. Nous créons un tableau `produits` de la même taille que le matricule pour stocker les produits de chaque chiffre du matricule avec le poids correspondant du facteur de pondération. Pour cela, nous utilisons une boucle `for` pour itérer sur chaque chiffre du matricule et calculer les produits en utilisant l'opérateur modulo `%` pour obtenir le poids correct du facteur de pondération.
 *         6. Ensuite, nous calculons la somme des chiffres des produits obtenus en utilisant la méthode `sumDigits()` qui extrait chaque chiffre d'un nombre et les additionne.
 *         7. La clé de contrôle est calculée en soustrayant le reste de la division de la somme par 10 à 10, et en utilisant l'opérateur modulo `%` pour s'assurer que le résultat est compris entre 0 et 9.
 *         8. Nous créons un nouveau tableau `matriculeSecurise` en ajoutant la clé de contrôle à la fin du matricule d'origine à l'aide de `System.arraycopy()`.
 *         9. Enfin, nous affichons le matricule sécurisé en parcourant le tableau `matriculeSecurise` et en affichant chaque élément.
 *
 *         **Programme pour vérifier la validité d'un matricule :**
 *
 *         1. On commence également par demander à l'utilisateur d'entrer le matricule et le facteur de pondération.
 *         2. Le matricule et le facteur de pondération sont lus depuis la console à l'aide de la classe `Scanner`.
 *         3. Le matricule est converti en un tableau d'entiers de la même manière que dans le premier programme.
 *         4. Le facteur de pondération est converti en un tableau d'entiers de la même manière que dans le premier programme.
 *         5. Nous calculons les produits de chaque chiffre du matricule (à l'exception de la clé de contrôle) avec le poids correspondant du facteur de pondération, en utilisant une boucle `for` pour parcourir chaque chiffre du matricule et en utilisant l'opérateur modulo `%` pour obtenir le poids correct du facteur de pondération.
 *         6. Ensuite, nous calculons la somme des chiffres des produits obtenus en utilisant la méthode `sumDigits()` qui extrait chaque chiffre d'un nombre et les additionne.
 *         7. La clé de contrôle
 *
 *         est calculée de la même manière que dans le premier programme.
 *         8. Nous comparons ensuite la clé de contrôle calculée avec la dernière valeur du tableau `matriculeArr` (la clé de contrôle fournie avec le matricule).
 *         9. Si les clés correspondent, cela signifie que le matricule est valide, sinon il est invalide.
 *         10. Enfin, nous affichons un message indiquant si le matricule est valide ou non.
 *
 *         J'espère que cette explication vous aide à comprendre les programmes en Java pour sécuriser et vérifier la validité d'un matricule. Si vous avez d'autres questions, n'hésitez pas à demander !
 */