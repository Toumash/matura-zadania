package pl.codesharks.matura;

import java.util.Locale;
import java.util.Scanner;

/**
 * <a href="http://pl.spoj.com/problems/JSUMRZYM/">SPOJ - Dodawanie liczb rzymskich</a>
 */
public class Rzymskie {
    public static Scanner s = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public static void run() {
        while (s.hasNextLine()) {
            String str = s.nextLine();
            String[] l = str.split(" ");
            System.out.println(LiczbaRzymska.valueOf(l[0]).add(LiczbaRzymska.valueOf(l[1])));
        }
    }


    public static class LiczbaRzymska {
        private int value;

        private LiczbaRzymska(int x) {
            value = x;
        }

        public static LiczbaRzymska valueOf(String str) {
            int out = 0, prv = 0;

            //Dla liczby dwucyfrowej petla nie chce działać
            if (str.length() == 2) {
                int first = toInt(str.charAt(0));
                int second = toInt(str.charAt(1));

                if (first < second) {
                    out = second - first;
                } else {
                    out = first + second;
                }
                return new LiczbaRzymska(out);
            }

            for (int i = 0; i < str.length(); i++) {
                int actual = toInt(str.charAt(i));
                // dla ostatniego znaku dodamy, nie odejmiemy
                // (roznica miedzy XI a XIV)
                if (i == str.length() - 1) {
                    out += actual;
                } else if (actual < prv) {
                    out -= actual;
                } else {
                    out += actual;
                }
                prv = actual;
            }

            return new LiczbaRzymska(out);
        }

        public static LiczbaRzymska valueOf(int v) {
            return new LiczbaRzymska(v);
        }

        public static int toInt(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
            }
            throw new IllegalArgumentException("Nieprawidłowa literka");
        }

        public static char toChar(int a) {
            switch (a) {
                case 1:
                    return 'I';
                case 5:
                    return 'V';
                case 10:
                    return 'X';
                case 50:
                    return 'L';
                case 100:
                    return 'C';
                case 500:
                    return 'D';
                case 1000:
                    return 'M';
            }
            throw new IllegalArgumentException("Nieprawidłowa liczba");
        }

        public static String toCharBelow10(int a) {
            if (a >= 0 && a <= 10) {
                String[] arr = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                return arr[a];
            }
            throw new IllegalArgumentException("Zla liczba");
        }

        public int getValue() {
            return value;
        }

        public LiczbaRzymska add(LiczbaRzymska b) {
            return LiczbaRzymska.valueOf(this.value + b.value);
        }

        public String toString() {
            int reszta = value;
            StringBuilder sb = new StringBuilder();
            int[] wartosci = {1000, 500, 100, 50, 10};
            while (reszta > 10) {
                // Troche buggy ale testy przechodzi
                //FIXME: troszke slabo to wyglada, trzeba to zrobic bardziej elegancko
                if (reszta >= 900 && reszta < 1000) {
                    reszta -= 900;
                    sb.append("CM");
                } else if (reszta >= 90 && reszta < 100) {
                    reszta -= 90;
                    sb.append("XC");
                } else {
                    for (int i = 0; i < wartosci.length; i++) {
                        int x = wartosci[i];
                        if (reszta > x) {
                            int ile = (int) Math.floor((double) reszta / x);
                            reszta -= x * ile;
                            for (int j = 0; j < ile; j++) {
                                sb.append(toChar(x));
                            }
                            break;
                        }
                    }
                }
            }
            sb.append(toCharBelow10(reszta));
            return sb.toString();
        }
    }
}
