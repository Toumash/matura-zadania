package pl.codesharks.maciura;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@SuppressWarnings("UnusedDeclaration")
/**
 * Entry for our mature application
 */
public class Main {

    /**
     * Locale ENGLISH to workaround errors in floating-point numbers
     * delimited by "," (as in Poland) not "." (World standard)
     */
    protected static Scanner s = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public static void main(String[] args) {
        /* SRunner.runStringMerge();  */
        /* SRunner.runTelefony();  */
        /* sumUntil50(true); */
        /* System.out.println(decToBin(10)); */
        /* wydajReszte(s.nextInt());  */
        /* fibbonacciIterational(3); */
        /* tribonacci(7);*/
        /* trojka();*/

        /* anagram();*/
        /* tabliczkaMnozenia();*/
    }

    /**
     * Full program checking if inputs are anagrams
     */
    public static void anagram() {
        int t;
        t = s.nextInt();
        for (int j = 0; j < t; j++) {

            String w1, w2;

            w1 = s.next();
            w2 = s.next();
            if (w1.length() != w2.length()) {
                System.out.println("NIE");
            } else {

                // KODY ASCII UZYWANE JAKO INDEKSY
                int[] t1 = new int['Z'];
                int[] t2 = new int['Z'];


                int length = w1.length();

                for (int i = 0; i < length; i++) {
                    char x = w1.charAt(i);
                    t1[x]++;
                }

                for (int i = 0; i < length; i++) {
                    char x = w2.charAt(i);
                    t2[x]++;
                }

                boolean czyJest = true;
                for (int i = 0; i < 'Z'; i++) {
                    if (t1[i] != t2[i]) {
                        czyJest = false;
                        break;
                    }
                }
                if (czyJest) {
                    System.out.println("TAK");
                } else {
                    System.out.println("NIE");
                }
            }
        }
    }

    public static void trojka() {
        int n, suma = 0;
        n = s.nextInt();

        suma += s.nextInt();
        suma += s.nextInt() * 2;

        for (int i = 2; i < n - 2; i++) {
            suma += s.nextInt() * 3;
        }

        suma += s.nextInt() * 2;
        suma += s.nextInt();

        System.out.println(suma % 3 == 0 ? "TAK" : "NIE");

    }

    public static void tabliczkaMnozenia() {
        int n;
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    /**
     * Centers a string  by spaces in the given length to the right
     * If the length is smaller than string it does not append spaces
     * <br>
     * <code>
     * print('|');<br>
     * print(center("25",4));<br>
     * print('I');<br>
     * </code>
     */
    public static String center(String str, int length) {
        StringBuilder sb = new StringBuilder(length);
        int strLength = str.length();
        for (int i = 0; i < length - strLength; i++) {
            sb.append(" ");
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * Biggest pair multiplication
     *
     * @param a 1st number
     * @param b 2nd number
     * @return integer (the biggest pair multiplication)
     */
    public static int nww(int a, int b) {
        return (a * b) / (nwdSubtract(a, b));//or nwdMod
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            if (n == 2) return true;

            int sq = (int) Math.ceil(Math.sqrt(n));
            for (int i = 2; i <= sq; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    public static boolean czyPalindrom(String a) {
        StringBuilder sb = new StringBuilder(a);
        return a.equals(sb.reverse().toString());
    }

    public static boolean czyAnagram(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        return Arrays.equals(ac, bc);
    }

    public static Pair<Float, Float> square(int a, int b, int c) {
        float delta = b * b - 4 * a * c;
        float d = (float) Math.sqrt(delta);
        if (delta >= 0) {
            return new Pair<>((-b + d) / (2 * a), (-b - d) / (2 * a));
        } else {
            return null;
        }
    }

    public static String telefony(String str) {
        StringBuilder sb = new StringBuilder();
        char actual;
        final int length = str.length();
        int pom = 0;
        int aLetter = 'a';
        int number;
        for (int i = 0; i < length; i++) {
            number = 0;
            actual = str.charAt(i);
            int d = Character.toLowerCase(Character.valueOf(actual)) - aLetter;

            {
                if (d < 3) number = 2;//ABC
                else if (d < 6) number = 3;//DEF
                else if (d < 9) number = 4;//GHI
                else if (d < 12) number = 5;//JKL
                else if (d < 15) number = 6;//MNO
                else if (d < 19) number = 7;//PQRS
                else if (d < 22) number = 8;//TUV
                else if (d <= 25) number = 9;//WXYZ
            }
            sb.append(String.valueOf(number));

        }
        return sb.toString();
    }

    public static String stringMerge(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int j = Math.min(a.length(), b.length());

        for (int i = 0; i < j; i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        return sb.toString();
    }

    public static int nwdSubtract(int a, int b) {
        while (a != b) if (a > b) a -= b;
        else b -= a;
        return a;
    }

    public static int nwdMod(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int tribonacci(int n) {
        if (n == 0 || n == 1) {
            System.out.println(0);
            return 0;
        } else if (n == 2) {
            System.out.println(1);
            return 1;
        }

        int prev1 = 1;
        int prev2 = 0;
        int prev3 = 0;
        int actual = 1;

        System.out.println(prev3);
        System.out.println(prev2);
        System.out.println(prev1);
        for (int i = 3; i < n; i++) {

            actual = prev1 + prev2 + prev3;
            System.out.println(actual);

            prev3 = prev2;
            prev2 = prev1;
            prev1 = actual;
        }
        return actual;
    }

    public static int nwdModRecursive(int a, int b) {
        if (b != 0)
            return nwdModRecursive(b, a % b);
        return a;
    }

    /**
     * Zadanie z
     * http://pl.spoj.com/problems/PTCLTZ/
     */
    public static int collatz(int s) {
        int x = s;
        int i = 1;
        while (x != 1) {
            if (x % 2 != 0) {
                x = (3 * x) + 1;
            } else {
                x = x / 2;
            }
            i++;
        }
        i--;
        return i;
    }

    public static int[] rozlozNaCzynniki(int n) {
        int k = 2;
        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            while (n % k == 0) {
                list.add(k);
                n /= k;
            }
            k++;
        }
        return Helpers.toIntArray(list);
    }

    /**
     * Wydaje reszte prostym algorytmem bez ograniczen ilosci poszczegolnych nominalow
     *
     * @param input wartosc reszty do wydania
     */
    public static void wydajReszte(int input) {
        int[] nominaly = {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        System.out.println("Podaj resztę do wydania w groszach");
        int reszta = input;
        while (reszta != 0) {
            int odpowiedniNominal = 0;
            for (int nominal : nominaly) {
                if (reszta > nominal) {
                    odpowiedniNominal = nominal;
                    break;
                }
            }

            int ilosc = (int) Math.floor(reszta / odpowiedniNominal);
            System.out.println("Wydaje:" + ilosc + "x" + odpowiedniNominal);
            reszta -= odpowiedniNominal * ilosc;
        }
    }

    public static int factorialRecursive(int n) {
        if (n == 1 || n == 0) return 1;
        else {
            return n * factorialRecursive(n - 1);
        }
    }

    public static int factiorialIterational(int n) {
        if (n == 1) return 1;
        int wynik = 2;
        for (int i = 1; i < n; i++) {
            wynik *= i;
        }
        return wynik;
    }

    public static int fibbonacciRecursive(int n) {
        if (n == 1 || n == 2) return 1;
        else {
            return fibbonacciRecursive(n - 1) + fibbonacciRecursive(n - 2);
        }
    }

    public static int fibbonacciIterational(int n) {
        if (n == 1 || n == 2) return 1;
        int prev = 1;
        int prevprev = 1;
        int actual = 1;

        for (int i = 2; i < n; i++) {
            actual = prev + prevprev;
            prevprev = prev;
            prev = actual;
        }
        return actual;
    }

    public static String decToBin(int x) {
        StringBuilder sb = new StringBuilder();

        while (x != 0) {
            sb.append((x % 2));
            x /= 2;
        }
        return sb.reverse().toString();

    }

    /**
     * Oblicza sumę wpisywanych liczb, dopóki nie zostanie wprowadzona liczba
     * większa od 50
     *
     * @return suma liczb
     */
    public static long sumUntil50(boolean output) {
        long suma = 0;
        int wczytana = 0;
        while (!(wczytana > 50)) {
            wczytana = s.nextInt();
            suma += wczytana;
            System.out.println("Aktualna suma=" + suma);
        }
        return suma;
    }

    public static int maciura(int n) {
        if (n == 1) {
            return 1;
        } else {
            int suma = n + 1;
            int i = n - 1;
            while (i > 1) {
                suma = 1 + i * suma;
                i--;
            }
            return suma;
        }
    }

    public static StringBuilder koraliki(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            sb.append('c');
        } else if (n % 2 == 0) {
            return koraliki(n / 2).append('b');
        } else {
            return koraliki((n - 1) / 2).append('c');
        }
        return sb;
    }


    protected static class SRunner {
        public static void runStringMerge() {
            int t = s.nextInt();

            for (int test = 0; test < t; test++) {
                String a = s.next();
                String b = s.next();
                System.out.println(stringMerge(a, b));
            }
        }

        public static void runTelefony() {
            int t = s.nextInt();
            for (int i = 0; i < t; i++) {
                String str = s.next();
                System.out.println(telefony(str));
            }
        }
    }

    public static class Helpers {
        /**
         * Converts an array of Integer objects to an array of integer primitives
         *
         * @param integerList the integer list
         * @return an array of integer primitives
         */
        public static int[] toIntArray(List<Integer> integerList) {
            int[] intArray = new int[integerList.size()];
            for (int i = 0; i < integerList.size(); i++) {
                intArray[i] = integerList.get(i);
            }
            return intArray;
        }
    }
}
