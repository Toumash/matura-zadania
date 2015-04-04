package pl.codesharks.maciura;

import java.util.Scanner;

@SuppressWarnings({"UnusedDeclaration", "SpellCheckingInspection"})
/**
 * Matura 2008 | Zadanie 4
 */
public class Wybory {

    String data = "325 155 200 248 311 69 15\n478 198 321 487 54 14 18\n489 224 79 287 254 125 20\n287 69 198 165 200 98 16\n385 245 95 198 212 74 17\n498 94 265 248 257 159 24\n212 165 123 236 301 111 23\n399 138 186 301 246 94 20\n298 94 148 297 295 168 14\n246 138 195 115 274 132 12\n315 198 175 165 261 112 14\n324 169 168 187 198 77 16\n498 194 138 149 195 92 18\n125 167 219 248 164 173 14\n269 294 284 268 183 182 16\n399 287 261 203 173 94 24\n219 305 238 406 194 106 16\n198 263 196 215 211 69 15\n268 94 183 269 193 173 16\n99 310 194 249 175 159 22";

    // 20 okręgów wyborczych, po 6 komitetów, ostatnia liczba - ilosc mandatów do rozdania
    int[][] tab = new int[20][7];

    public static void displayTable(int[] t) {
        for (int aT : t) {
            System.out.println(aT);
        }
    }

    /**
     * Algorytm do przydzielania mandatów przepisany z zadania
     */
    public static float X(int glosy, int mandaty) {
        return (float) glosy / (mandaty + 1);
    }

    /**
     * Szuka indexu, dla którego wartosc jest największa
     */
    public static int maxIndex(float[] arr) {
        int maxIndex = 0;
        float max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Wczytuje dane ze stringa
     */
    public void init() {
        //TODO: Rozbudowac o opcjonalny plik
        Scanner scanner = new Scanner(data);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 7; j++) {
                tab[i][j] = scanner.nextInt();
            }
        }
    }

    /**
     * Uruchamia wszystkie zadania
     */
    public void start() {
        init();
        System.out.println("Pierwsze");
        first();
        System.out.println("Drugie");
        second();
        System.out.println("Trzecie");
        third();
        System.out.println("Czwarte");
        fourth();
    }

    /**
     * Podaj, ile lacznie otrzymal kazdy z komitetow
     */
    int[] first() {
        int komitety[] = new int[6];
        for (int[] aTab : tab) {
            for (int j = 0; j < komitety.length && j < aTab.length; j++) {
                komitety[j] += aTab[j];
            }
        }
        return komitety;
    }

    /**
     * Podaj numery okręgów, w których łącznie na wszystkieg komitety wyborcze oddano najwięcej i najmniej głosów
     */
    void second() {
        int actualSum = 0;

        for (int i = 0; i < tab[0].length; i++) {
            actualSum += tab[0][i];
        }
        int min = actualSum, minIndex = 0;
        int max = actualSum, maxIndex = 0;

        for (int i = 0; i < tab.length; i++) {
            actualSum = 0;
            for (int j = 0; j < tab[i].length; j++) {
                actualSum += tab[i][j];
            }
            if (actualSum > max) {
                max = actualSum;
                maxIndex = i;
            }
            if (actualSum < min) {
                min = actualSum;
                minIndex = i;
            }
        }
        System.out.println("Max:" + maxIndex + " Min:" + minIndex);
    }

    /**
     * Podaj liczby mandatów uzyskanych przez komitetmy A B C D E F w okręgu 6
     */
    void third() {
        int doRozdania = tab[5][6];

        int mandaty[] = new int[6];

        for (int i = doRozdania; i > 0; i--) {
            float punkty[] = new float[6];
            for (int j = 0; j < tab[5].length - 1; j++) {
                punkty[j] = X(tab[5][j], mandaty[j]);
            }
            int najwiekszywynikIndex = maxIndex(punkty);
            mandaty[najwiekszywynikIndex]++;
        }

        displayTable(mandaty);
    }

    /**
     * Podaj, ile mandatów uzyskał każdy z komitetów A B C D E F w całym parlamencie
     */
    void fourth() {
        int[] mGlobal = new int[6];
        for (int[] aTab : tab) {
            int doRozdania = aTab[6];

            int mLocal[] = new int[6];

            if(mLocal.length == mGlobal.length){
                throw new IllegalStateException("Some Algorith error");
            }

            for (int i = doRozdania; i > 0; i--) {
                float punkty[] = new float[6];

                for (int j = 0; j < aTab.length - 1; j++) {
                    punkty[j] = X(aTab[j], mLocal[j]);
                }
                int najwiekszywynikIndex = maxIndex(punkty);
                mLocal[najwiekszywynikIndex]++;
            }


            for (int j = 0; j < mGlobal.length; j++) {
                mGlobal[j] += mLocal[j];
            }

        }

        //TEST
        int actual = 0;
        for (int aMGlobal : mGlobal) {
            actual += aMGlobal;
        }

        int expected = 0;
        for (int[] aTab : tab) {
            expected += aTab[6];
        }
        assert (actual == expected) : "Error in algorith: ilosc mandatow do rozdana != ilosci rozdanych";

        displayTable(mGlobal);
    }
}
