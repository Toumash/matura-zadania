package pl.codesharks.maciura;

import pl.codesharks.maciura.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings({"UnusedDeclaration", "SpellCheckingInspection"})
public class PureFunctions {
    /**
     * <a href="http://pl.spoj.com/problems/PTCLTZ/">Problem Colattza - SPOJ</a>
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

    public static ArrayList<Integer> rozlozNaCzynniki(int n) {
        int k = 2;
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 1) {
            while (n % k == 0) {
                list.add(k);
                n /= k;
            }
            k++;
        }
        return list;
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

    /**
     * <a href="http://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest common divisior</a>
     */
    public static int nwdSubtract(int a, int b) {
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }

    /**
     * <a href="http://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest common divisior</a>
     */
    public static int nwdMod(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    /**
     * Modified fibbonaci
     */
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
     * Computates greatest common multiplication
     */
    public static int nww(int a, int b) {
        return (a * b) / (nwdSubtract(a, b));//or nwdMod
    }

    public static boolean isPrimeNumber(int n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        }

        int sq = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i <= sq; i++) {
            if (n % i == 0) return false;
        }
        return true;

    }

    public static boolean czyPalindrom(String a) {
        StringBuilder sb = new StringBuilder(a);
        return a.equals(sb.reverse().toString());
    }

    /**
     * Computes the roots of the QUadratic Equation like (ax^2+bx+c)
     *
     * @return Pair of roots if d>0. <br>
     * Pair of same roots if d==0. <br>
     * Null in case if d<0
     */
    public static Pair<Float, Float> rootOfQuadraticEquation(int a, int b, int c) {
        float delta = b * b - 4 * a * c;
        float d = (float) Math.sqrt(delta);
        if (delta >= 0) {
            return new Pair<>((-b + d) / (2 * a), (-b - d) / (2 * a));
        } else {
            return null;
        }
    }

    /**
     * Checks if elements in given range, are in ascending order
     *
     * @param array array to check
     * @param a     left limiter
     * @param b     right limiter
     * @return are they ascending?
     * @throws java.lang.IndexOutOfBoundsException if a is out of array index range
     */
    public static boolean isArrayAscending(int[] array, int a, int b) throws IndexOutOfBoundsException {
        boolean ascending = true;
        for (int i = a + 1; i <= b; i++) {
            if (!(array[i] > array[i - 1])) {
                ascending = false;
                break;
            }
        }
        return ascending;
    }

    /**
     * Sprzawdza czy podabe wyrazy są anagramami, litery mogą być różnej wielkości
     * Wykorzystuje metode liczenia wystąpień liter
     */
    public static boolean czyAnagramLiczenie(String stra, String strb) {
        // Różnej długości wyrazy nie mogą byc anagramami
        if (stra.length() != strb.length())
            return false;
        //
        stra = stra.toLowerCase();
        strb = strb.toLowerCase();

        // KODY ASCII UZYWANE JAKO INDEKSY
        int[] t1 = new int['z'];
        int[] t2 = new int['z'];


        int length = stra.length();

        for (int i = 0; i < length; i++) {
            char x = stra.charAt(i);
            t1[x]++;
        }

        for (int i = 0; i < length; i++) {
            char x = strb.charAt(i);
            t2[x]++;
        }

        boolean czyAnagram = true;
        for (int i = 0; i < 'z'; i++) {
            if (t1[i] != t2[i]) {
                czyAnagram = false;
                break;
            }
        }
        return czyAnagram;
    }

    /**
     * Sprzawdza czy podabe wyrazy są anagramami, litery mogą być różnej wielkości.
     * Wykorzystuje metode sortowanie liter alfabetycznie
     */
    public static boolean czyAnagramSortowanie(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        return Arrays.equals(ac, bc);
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int transposed[][] = new int[n][m];

        for (int c = 0; c < m; c++) {
            for (int d = 0; d < n; d++)
                transposed[d][c] = matrix[c][d];
        }
        return transposed;
    }

    public static int convertToInt(char x) {
        return x - '0';
    }

    /**
     * Oblicza sume nieparzystych wyrazow ciagu arytmetyczniego 1,2,3,4...n
     */
    public static int sumaNieparzystych(int n) {
        return ((1 + n) / 2) * n;
    }

    /**
     * Oblicza sume parzystych wyrazow ciagu arytmetyczniego 1,2,3,4...n
     */
    public static int sumaParzystych(int n) {
        return ((n) / 2) * n;
    }

    public static String decToBin(int x) {
        StringBuilder sb = new StringBuilder();

        while (x != 0) {
            sb.append((x % 2));
            x /= 2;
        }
        return sb.reverse().toString();
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

    public static String reverseWordsOrder(String line) {
        String[] words = line.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString();
    }
}
