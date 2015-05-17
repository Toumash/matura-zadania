package pl.codesharks.matura;

import java.util.Locale;
import java.util.Scanner;

/**
 * <a href="http://pl.spoj.com/problems/DAPPLES/">SPOJ - Zabójcze jabłka</a>
 */
public class DeadApples {

    public static final int G = 10;
    public static Scanner s = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public static void run() {
        final int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int zabijajacaPredkosc = s.nextInt();
            int iloscLudzi = s.nextInt();
            Human[] ludzie = new Human[iloscLudzi];

            for (int j = 0; j < iloscLudzi; j++) {
                int wzrost = s.nextInt();
                int wiek = s.nextInt();
                int szybkoscWzrostu = s.nextInt();

                ludzie[j] = new Human(wzrost, wiek, szybkoscWzrostu);
            }

            int[] r = logicLoop(zabijajacaPredkosc, ludzie);
            for (int j = 0; j < r.length; j++) {
                System.out.println(j + ": " + r[i]);
            }
        }
    }

    public static int[] logicLoop(int zabijajacaPredkosc, final Human[] tab) {
        final int ILOSC_LAT = 21;
        int[] maxWysokosciDrzewNaDanyRok = new int[ILOSC_LAT];

        for (int i = 0; i < ILOSC_LAT; i++) {
            int min = tab[0].wzrost;
            for (Human h : tab) {
                if (h.wzrost < min) {
                    min = h.wzrost;
                }
            }

            int h = ((zabijajacaPredkosc * zabijajacaPredkosc) * 100) / (2 * G);
            maxWysokosciDrzewNaDanyRok[i] = min + h;

            for (Human hum : tab) {
                hum.uplonalRok();
            }
        }
        return maxWysokosciDrzewNaDanyRok;
    }

    public static class Human {
        public int wzrost;
        public int szybkoscWzrostu;
        public int wiek;

        public Human(int wzrost, int wiek, int szybkoscWzrostu) {
            this.wzrost = wzrost;
            this.szybkoscWzrostu = szybkoscWzrostu;
            this.wiek = wiek;
        }

        public void uplonalRok() {
            if (wiek < 20) {
                wzrost += szybkoscWzrostu;
            }
            wiek++;
        }
    }

}

