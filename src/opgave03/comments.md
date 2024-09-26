I har en metode updateCount() der ikke bliver brugt. I opdaterer roundCount to steder, brug updateCount metoden eller fjern den

---

Alle de steder I sammenligner med true

    while(wantsToPlay == true)

kan erstattes af

    while(wantsToPlay)

---

Pas på med at returnerer specielle værdier.

        if (terning1 == 1 || terning2 == 1) return 1;

Om en måned kan I garanteret ikke huske hvorfor I laver dette tjek

    else if (rulTerning == 1)

En bedre løsning ville være at rollDie returnerede int[] og I laver dette tjek

    else if(terninger[0] == 1 || terninger[1] == 1)

så ved man at betingelsen i if-sætninger er hvis en af terningerne er 1.

---
