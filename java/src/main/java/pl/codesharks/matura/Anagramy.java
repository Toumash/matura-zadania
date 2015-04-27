package pl.codesharks.matura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Matura 2015 probna zadanie 4
 */
public class Anagramy {

    String[][] lista = new String[1000][2];


    public boolean wczytajZPliku() {
        File dane = new File("dane_anagramy.txt");
        if (dane.exists()) {
            try {
                Scanner scanner = new Scanner(dane);
                int i = 0;
                while (scanner.hasNextLine()) {
                    lista[i][0] = scanner.next();
                    lista[i][1] = scanner.next();

                    i++;
                }
                return true;


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return false;

        }
        return false;
    }


    public boolean czyAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < a.length() - 1; j++) {
                if (A[j] > A[j + 1]) {
                    char tmb = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmb;
                }

                if (B[j] > B[j + 1]) {
                    char tmb = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = tmb;
                }
            }
        }
        //ArrayOutOfBoundException
        boolean czyAnagram = true;
        for (int i = 0; i < a.length(); i++) {
            if (B[i] != A[i]) {
                czyAnagram = false;
                break;
            }
        }

        return czyAnagram;
    }

    public void A() {
        int licznik = 0;
        for (int i = 0; i < lista.length; i++) {
            if (czyAnagram(lista[i][0], lista[i][1])) {
                licznik++;
            }
        }
        System.out.println("A) " + licznik);
    }

    public void B() {
        long startTime = System.currentTimeMillis();
        String[] dane = new String[lista.length * 2];
        for (int i = 0; i < dane.length; i++) {
            dane[i] = lista[i / 2][i % 2];
        }

        int max = 0;
        int licznik = 0;
        for (int i = 0; i < dane.length; i++) {
            String a = dane[i];
            licznik = 0;
            for (int j = 0; j < dane.length; j++) {
                if (i != j) {
                    String b = dane[j];
                    if (czyAnagram(a, b)) {
                        licznik++;
                    } else {
                        if (licznik > max) {
                            max = licznik;
                        }
                        licznik = 0;
                    }
                }
            }
        }
        if (licznik > max) {
            max = licznik;
        }
        System.out.println("Czas  wykonywania=" + (System.currentTimeMillis() - startTime) / 1000f + " s");
        System.out.println("B) " + max);

    }

}
