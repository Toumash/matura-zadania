package pl.codesharks.matura;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Matura 2007 zadanie 2 cz. II
 */
public class SuperPierwszeLiczby {


    boolean[] sito = new boolean[100001];

    public SuperPierwszeLiczby() {
        Arrays.fill(sito, true);
        sito[0] = false;
        sito[1] = false;
    }

    public String decToBin(int x) {

        StringBuilder sb = new StringBuilder();

        while (x > 0) {
            sb.append(x % 2);
            x /= 2;
        }
        return sb.reverse().toString();
    }

    public ArrayList<Integer> toDigitList(int x) {
        ArrayList<Integer> list = new ArrayList<>();

        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        return list;
    }

    public void przesiew() {
        int[] pierwsze = new int[]{2, 3, 5, 7, 11};
        long startTime = System.nanoTime();
        for (int p : pierwsze) {
            for (int j = 2, length = sito.length; p * j < length; j++) {
                sito[j * p] = false;
            }
        }
        System.out.println((System.nanoTime() - startTime) / 1000000d + " ms");
    }

    public void wyswietl(boolean[] t) {
        int licznik = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i]) {
                System.out.println(i);
                licznik++;
            }
        }
        System.out.println(licznik + " liczb pierwszych");
    }

}
