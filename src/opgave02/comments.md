Jeres playCraps() metode er blevet lidt stor, I kunne evt flytte

                    do {
                        System.out.println("Tryk Enter for at kaste igen...");
                        scanner.nextLine();

                        nytkast = rollDice();
                        System.out.println("Du kastede: " + nytkast);

                        if (nytkast == point) {
                            System.out.println("Du har vundet ved at kaste dit point!");
                            vinderRunder++;
                            break;
                        } else if (nytkast == 7) {
                            System.out.println("Du har tabt ved at kaste 7.");
                            runderTabt++;
                            break;
                        }

                    } while (true);

Den del hvor man ruller for point ud I en seperat metode, så kunne I også slippe for at bruge breaks.

---
