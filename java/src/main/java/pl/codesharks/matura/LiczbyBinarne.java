package pl.codesharks.matura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MATURA 2015 MAJ
 */
public class LiczbyBinarne {

    public static final int LINES_NUMBER = 1000;
    private String[] listaLiczb = null;

    public void wczytajLiczby() {
        listaLiczb = new String[LINES_NUMBER];
        try {
            Scanner s = new Scanner(new File("liczby.txt"));
            for (int i = 0; i < LINES_NUMBER; i++) {
                listaLiczb[i] = s.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        if (listaLiczb == null) {
            throw new IllegalStateException("Nie mozna urochomic bez wczytywania listy. Uzyj: LiczbyBinarne#wczytajLiczby()");
        }

        System.out.println("Zadanie 1: " + zadanie1(listaLiczb));
        System.out.println("Zadanie 2: " + zadanie2(listaLiczb));
        System.out.println("Zadanie 3: " + zadanie3(listaLiczb));
    }

    private String zadanie3(String[] listaLiczb) {
        int maxIndex = 0;
        int minIndex = 0;
        String min = listaLiczb[0];
        String max = listaLiczb[0];

        for (int i = 0; i < listaLiczb.length; i++) {
            int res = compare(min, listaLiczb[i]);
            if (res == 1) {
                min = listaLiczb[i];
                minIndex = i + 1;
            }

            int res2 = compare(max, listaLiczb[i]);
            if (res2 == -1) {
                max = listaLiczb[i];
                maxIndex = i + 1;
            }
        }
        return "Max: " + maxIndex + " Min:" + minIndex;
    }

    public int compare(String a, String b) {
        if (a.length() > b.length()) {
            return 1;
        } else if (a.length() < b.length()) {
            return -1;
        } else {
            for (int i = 0; i < a.length(); i++) {
                char ca = a.charAt(i);
                char cb = b.charAt(i);
                if (ca > cb) {
                    return 1;
                } else if (ca < cb) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private String zadanie2(String[] listaLiczb) {
        int podzielnychPrzez2 = 0;
        int podzielnychPrzez8 = 0;
        for (String str : listaLiczb) {
            if (str.charAt(str.length() - 1) == '0') {
                ++podzielnychPrzez2;
            }
            if (str.substring(str.length() - 3).equals("000")) {
                ++podzielnychPrzez8;
            }
        }
        return "Przez 8:" + podzielnychPrzez8 + " przez 2: " + podzielnychPrzez2;
    }


    private int zadanie1(String[] lista) {
        int liczbaLiczbSpelniajacychWarunek = 0;
        for (String str : lista) {
            int liczbaZer = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    ++liczbaZer;
                }
            }
            if (liczbaZer > (str.length() / 2)) {
                ++liczbaLiczbSpelniajacychWarunek;
            }
        }
        return liczbaLiczbSpelniajacychWarunek;
    }


}
