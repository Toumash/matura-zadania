package pl.codesharks.maciura;

import javafx.util.Pair;

import java.util.*;

@SuppressWarnings({"UnusedDeclaration", "SpellCheckingInspection"})
public class AlgorytmyMaturalne {

    /**
     * Locale ENGLISH to workaround errors in floating-point numbers
     * delimited by "," (as in Poland) not "." (World standard)
     */
    protected static Scanner s = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public static void main(String[] args) {
    }

    /**
     * <a href="http://youngcoder.eu/index.php/node/show/17500">Youngcoder - klasy adresow IP</a>
     */
    private static void klasyAdresowIP() {
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            String input = s.next();
            String[] parts = input.split("\\.");

            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            int d = Integer.parseInt(parts[3]);

            String out;
            if (a > 255 || b > 255 || c > 255 || d > 255) {
                out = "error";
            } else if (a <= 127) {
                out = "A";
            } else if (a <= 191) {
                out = "B";
            } else {
                out = "C";
            }
            System.out.println(out);
        }

    }

    /**
     * Wczytuje tablice o dlugosci t i szuka najwioekszej oraz najmniejszej wartosci poczym
     * wskazuje ich roznice i oblicza sume roznic kazdej sztafety od minimalnej dl (tej do ktorej trzeba przyciac plot)
     * <a href="http://youngcoder.eu/index.php/node/show/17506">Youngcoder Plot Stefana</a>
     */
    public static void plot() {
        int t = s.nextInt();
        int[] T = new int[t];
        for (int i = 0; i < t; i++) {
            T[i] = s.nextInt();
        }

        int max = T[0], min = T[0];
        for (int i = 0; i < t; i++) {
            if (T[i] > max) max = T[i];
            if (T[i] < min) min = T[i];
        }
        int sum = 0;
        for (int i = 0; i < t; i++) {
            sum += T[i] - min;
        }
        System.out.println(max - min);
        System.out.println(sum);
    }

    /**
     * Sortuje 12 par liczb, najpierw po pierwszej, następnie po drugiej
     * <a href="http://youngcoder.eu/index.php/node/show/17547">Youngcoder - sortowanie par</a>
     */
    private static Para[] sortujPary(Para[] T) {
        for (int i = 0, length = T.length; i < length; i++) {
            for (int j = 1; j < length; j++) {
                Para actual = T[j];
                Para prev = T[j - 1];

                if (actual.x < prev.x) {
                    Para tmp = T[j];
                    T[j] = T[j - 1];
                    T[j - 1] = tmp;
                } else if ((actual.x == prev.x) && (actual.y < prev.y)) {
                    int tmp = actual.y;
                    T[j].y = T[j - 1].y;
                    T[j - 1].y = tmp;
                }
            }
        }
        return T;
    }

    /**
     * Dana jest ilosć klocków, oblicz ilosc poziomów piramidy
     * n = sqrt(2s) to zwykle przeksztalcenie wzoru na sume ciagu arytmetycznego<br>
     * <code>
     * s = (a1 + an)*n/2        <br>
     * s  =(a1 + r(n-1))*n/2    <br>
     * </code>
     * <a href="http://youngcoder.eu/index.php/node/show/17505">Youngcoder - piramida klockow</a>
     */
    public static int piramidaKlockow(int s) {
        return (int) Math.sqrt(2 * s);
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

    public static boolean czyAnagramLiczenie(String stra, String strb) {
        // Różnej długości wyrazy nie mogą byc anagramami
        if (stra.length() != strb.length())
            return false;

        // KODY ASCII UZYWANE JAKO INDEKSY
        int[] t1 = new int['Z'];
        int[] t2 = new int['Z'];


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
        for (int i = 0; i < 'Z'; i++) {
            if (t1[i] != t2[i]) {
                czyAnagram = false;
                break;
            }
        }
        return czyAnagram;
    }

    public static boolean czyAnagramSortowanie(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        Arrays.sort(ac);
        Arrays.sort(bc);
        return Arrays.equals(ac, bc);
    }

    /**
     * Full program checking if inputs are anagrams
     * <a href="http://youngcoder.eu/index.php/node/show/17550">Youngcoder  - anagramy</a>
     */
    public static void anagramy() {
        int t;
        t = s.nextInt();
        for (int j = 0; j < t; j++) {

            String a, b;

            a = s.next();
            b = s.next();
            if (a.length() != b.length()) {
                System.out.println("NIE");
            } else {
                boolean czyJest = czyAnagramLiczenie(a, b);
                if (czyJest) {
                    System.out.println("TAK");
                } else {
                    System.out.println("NIE");
                }
            }
        }
    }

    /**
     * <a href="http://youngcoder.eu/index.php/node/show/17408">Youngcoder - suma trojek</a>
     */
    public static void sumaTrojek() {
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

    /**
     * Rysuje tabliczbe mnozenia  nxn w tabelce
     * n podawane jest w konsoli
     */
    public static void tabliczkaMnozenia() {
        int n = s.nextInt();
        //TODO: Generowanie poziomej linii
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(padRight(String.valueOf(i * j), 4) + " ");
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
     * print(padRight("25",4));<br>
     * print('I');<br>
     * </code>
     */
    public static String padRight(String str, int length) {
        StringBuilder sb = new StringBuilder(length);
        int strLength = str.length();
        for (int i = 0; i < length - strLength; i++) {
            sb.append(" ");
        }
        sb.append(str);
        return sb.toString();
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

    /**
     * <a href="http://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest common divisior</a>
     */
    public static int nwdSubtract(int a, int b) {
        while (a != b) if (a > b) a -= b;
        else b -= a;
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
        return Utils.toIntArray(list);
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

    public static int maciuraFoo(int n) {
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

    /**
     * Probna matura 2014 zadanie 1
     */
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

    public static class SRunner {
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

        /**
         * <a href="http://youngcoder.eu/index.php/node/show/17549">http://youngcoder.eu/index.php/node/show/17549</a>
         */
        public static void runPalindromy() {
            int t = s.nextInt();
            for (int i = 0; i < t; i++) {
                String str = s.next();
                System.out.println(czyPalindrom(str.replace(" ", "")) ? "t" : "n");
            }
        }

        public static void runPiramidaKlockow() {
            int t = s.nextInt();
            for (int i = 0; i < t; i++) {
                int sum = s.nextInt();
                System.out.println(piramidaKlockow(sum));
            }
        }

        /**
         * Sprawdza czy kolejne wartosci w danym przedziale A,B się zwiększaja
         * <a href="http://youngcoder.eu/index.php/node/show/17545">http://youngcoder.eu/index.php/node/show/17545</a>
         */
        public static void runSkoki() {
            // Ilosc liczb do wczytania
            int n = s.nextInt();

            int T[] = new int[n];

            for (int i = 0; i < n; i++) {
                T[i] = s.nextInt();
            }
            /* Ograniczniki, zakres,
            przedział indeksow do sprawdzania   */
            int a = s.nextInt();
            int b = s.nextInt();

            boolean ascending = isArrayAscending(T, a, b);
            System.out.println(ascending);
        }

        public static void runSortowaniePar() {
            int n = s.nextInt();

            Para[] t = new Para[n];
            for (int i = 0; i < n; i++) {
                Para p = new Para(s.nextInt(), s.nextInt());
                t[i] = p;
            }
            t = sortujPary(t);
            for (Para aT : t) {
                System.out.println(aT);
            }
        }
    }

    public static class Utils {
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

    public static class Para {
        public int x;
        public int y;

        public Para(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}
