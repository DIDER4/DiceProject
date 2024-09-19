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

        int startSlag = rullterning();
        updateStatistics();
        System.out.println("\nDu rullede " + startSlag);


        if (startSlag == 7 || startSlag == 11){
            System.out.println("\nDu slog " + (startSlag) + " og vinder derfor på første slag!");
            printStatistics();
            return;
        }
        if (startSlag == 2 || startSlag == 3 || startSlag == 12){
            System.out.println("\nDu har slået " + startSlag + " og taber derfor på første slag!");
            printStatistics();
            return;
        }

        int point = startSlag;
        System.out.println("Du har nu " + point + " point");
        System.out.println("-------------------------");
        System.out.println("Spillet fortsætter du dine slag er: \n");
        boolean pointResultat = rollForPoint(point);

        if (pointResultat) {
            System.out.println("\nTillykke! Du har slået det samme point som dit startslag og har derfor vundet!");
        }
        else {
            System.out.println("\nDu har slået 7 før dit point og har derfor tabt");
        }
        printStatistics();
        scanner.close();

    }

    private static boolean rollForPoint(int point){
        int rulle;
        do {
            rulle = rullterning();
            System.out.println("Du rullede: "+ rulle);
            updateStatistics();
        }while (rulle != 7 && rulle != point);
        return rulle == point;
    }


    private static int rullterning() {
        int terning1 = (int) (Math.random() * 6 + 1);
        int terning2 = (int) (Math.random() * 6 + 1);
        return terning1 + terning2;
    }

    private static void updateStatistics() {
        rollCount++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul: ", rollCount);

    }
}
