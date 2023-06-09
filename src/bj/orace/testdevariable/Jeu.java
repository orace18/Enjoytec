package bj.orace.testdevariable;
import java.util.Random;
import java.util.Scanner;

public class Jeu {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Demande aux joueurs de choisir leur pseudo
            System.out.print("Joueur 1, entrez votre pseudo : ");
            String joueur1 = scanner.nextLine();
            System.out.print("Joueur 2, entrez votre pseudo : ");
            String joueur2 = scanner.nextLine();

            int pointsDeVieJoueur1 = 250;
            int pointsDeVieJoueur2 = 250;

            System.out.println("Le combat commence !");

            Random random = new Random();

            // Déroulement des 4 attaques
            for (int i = 1; i <= 4; i++) {
                System.out.println("Attaque " + i + " :");

                // Joueur 1 attaque
                if (i % 2 != 0) {
                    System.out.println(joueur1 + " attaque !");
                    int degats = random.nextInt(101); // Nombre de dégâts entre 0 et 100
                    System.out.println("Dégâts infligés : " + degats);
                    pointsDeVieJoueur2 -= degats;
                }
                // Joueur 2 attaque
                else {
                    System.out.println(joueur2 + " attaque !");
                    int degats = random.nextInt(101); // Nombre de dégâts entre 0 et 100
                    System.out.println("Dégâts infligés : " + degats);
                    pointsDeVieJoueur1 -= degats;
                }

                System.out.println(joueur1 + " : " + pointsDeVieJoueur1 + " PV");
                System.out.println(joueur2 + " : " + pointsDeVieJoueur2 + " PV");
                System.out.println();
            }

            // Déclaration du gagnant
            String gagnant;
            if (pointsDeVieJoueur1 > pointsDeVieJoueur2) {
                gagnant = joueur1;
            } else if (pointsDeVieJoueur2 > pointsDeVieJoueur1) {
                gagnant = joueur2;
            } else {
                gagnant = "Aucun";
            }

            System.out.println("Le combat est terminé !");
            System.out.println("Le gagnant est : " + gagnant);
        }
    }
