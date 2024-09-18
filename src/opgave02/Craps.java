package opgave02;

import java.util.Scanner;

public class Craps {
    private static int rollCount = 0;
    private static int sum = 0;


    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, Craps.");
        printRules();
        System.out.println();

        playCraps();

        System.out.println();
        System.out.println("Tak for at spille, Craps.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for Craps");
        System.out.println("Spillet består af en række kast med to terninger. Udfaldet af et kast er summen af de to terningers\n" +
                "øjne.\n" +
                "Det første kast kaldes ‘come out roll’. Spilleren vinder med det samme, hvis det første kast er 7\n" +
                "eller 11, og taber med det samme, hvis det første kast er 2, 3 eller 12. Hvis spillerens første kast er\n" +
                "4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’. Spilleren bliver derefter ved med at\n" +
                "kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7. Kaster han 7, har han tabt. Kaster han\n" +
                "sit ’point’, har han vundet");
        System.out.println("=====================================================");
    }

    public static void playCraps() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Klar til at prøve lykken med de 2 terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            if (faces[0] + faces[1] == 7 || faces[0] + faces[1] == 11){
                System.out.println("Du slog" + (faces[0]+faces[1]) + "og taber derfor");
                printStatistics();
            }
            System.out.println("Du rullede: " + faces[0]);
            System.out.println("Du rullede: " + faces[1]);
            sum += faces[0] + faces[1];

            updateStatistics();

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }
        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] dices = new int[2];
        dices[0] = (int) (Math.random() * 6 + 1);
        dices[1] = (int) (Math.random() * 6 + 1);
        return dices;
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void updateStatistics() {
        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);

    }
}
