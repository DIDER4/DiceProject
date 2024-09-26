Dette kode 

            sum += faces[0] + faces[1];

            if (faces[0] == faces[1]) {
                sammeAntalØjne++;
            }
            if (faces[0] + faces[1] > størsteØjne) {
                størsteØjne = faces[0] + faces[1];
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < antaløjne.length; j++) {
                    if (faces[i] == antaløjne[j]) {
                        resultatAfØjne[j]++;
                    }
                }
            }

har noget med statistikken at gøre, så jeg ville flytte dette til updateStatistics() metoden

---

Dette 

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < antaløjne.length; j++) {
                    if (faces[i] == antaløjne[j]) {
                        resultatAfØjne[j]++;
                    }
                }
            }

kan erstattes af

     resultatAfØjne[faces[0] - 1]++;
     resultatAfØjne[faces[1] - 1]++;

---
