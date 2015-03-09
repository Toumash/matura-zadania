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
     * <a href="http://pl.spoj.com/problems/PP0601A2/">Test 3 - SPOJ</a>
     * wyswietla liczby dopoki nie napotka 3 par 42 i czegos innego niz 42 NAPRZEMIAN
     */
    private static void test3() {

        int n42 = 0;
        int ncos = 0;
        int prev = 0;
        while (true) {
            int x = s.nextInt();

            if (x == 42 && prev != 42) {
                n42++;
            } else if (x != 42 && prev == 42) {
                ncos++;
            } else if (x == 42) {
                //gdy mamy pare 42
                n42 = 1;
                ncos = 0;
            } else {
                //gdy mamy pare czegos != 42
                ncos = 1;
                n42 = 0;
            }

            System.out.println(x);
            // 3 pary (42 , cos!=42)
            if (ncos == 3 && n42 == 3) {
                break;
            }
            prev = x;
        }

    }

    /**
     * <a href="http://pl.spoj.com/problems/PP0506A/">Sortowanie punktów - SPOJ</a>
     * Sortuje punkty w zaleznosci od odległości od środka układu współrzędnych
     */
    private static void sortujPunkty() {
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            Point[] tab = new Point[n];

            for (int j = 0; j < n; j++) {
                Point tmp = new Point();
                tmp.name = s.next();
                tmp.x = s.nextInt();
                tmp.y = s.nextInt();
                tab[j] = tmp;
            }

            Arrays.sort(tab);

            for (int j = 0; j < n; j++) {
                System.out.println(tab[j]);
            }
            System.out.println();
        }
    }

    /**
     * <a href="http://pl.spoj.com/problems/JSPACE/">SPACJE - SPOJ</a>
     */
    private static void spacje() {
        String line;
        while (s.hasNextLine()) {
            line = s.nextLine();

            boolean czyRobicDuza = true;
            for (int i = 0; i < line.length(); i++) {
                char znak = line.charAt(i);

                if (znak == ' ') {
                    czyRobicDuza = true;
                } else if (czyRobicDuza) {
                    System.out.print(String.valueOf(znak).toUpperCase());
                    czyRobicDuza = false;
                } else {
                    System.out.print(znak);
                }
            }
            System.out.println();
        }
    }

    /**
     * <a href="http://pl.spoj.com/problems/TRN/">Transponowanie Macierzy - SPOJ</a>
     */
    private static void transponowanieMacierzy() {
        int w = s.nextInt();
        int k = s.nextInt();

        int[][] t = new int[w][k];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < k; j++) {
                t[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(t[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static void tablica() {
        String line = s.nextLine();

        String[] lines = line.split(" ");

        for (int i = lines.length - 1; i >= 0; i--) {
            System.out.print(lines[i] + " ");
        }

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
    private static void plot() {
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
    public static Para[] sortujPary(Para[] T) {
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
    private static void anagramy() {
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
    private static void sumaTrojek() {
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
    private static void tabliczkaMnozenia() {
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

    /**
     * <a href="http://pl.spoj.com/problems/PP0602D/">ROL(k) - SPOJ</a>
     * przesuwa elementy tablicy cyklicznie w lewo o k
     */
    private static void rolk() {
        int n = s.nextInt();
        // ilosc elementow
        int k = s.nextInt();

        int[] tab = new int[n];

        // Wczytanie danych do tablicy
        for (int i = 0; i < tab.length; i++) {
            tab[i] = s.nextInt();
        }

        for (int i = k; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }

        for (int i = 0; i < k; i++) {
            System.out.print(tab[i] + " ");
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
     * <a href="http://pl.spoj.com/problems/EUCGAME/">Gra Euklidesa - SPOJ</a>
     */
    private static void graEukl() {
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            // NWD
            // || lub
            // && i
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }

            System.out.println(a + b);
        }
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
    private static void wydajReszte(int input) {
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

    private static class Point implements Comparable<Point> {
        public String name;
        public int x;
        public int y;

        @Override
        public int compareTo(Point o) {
            double dist1 = Math.sqrt(x * x + y * y);
            double dist2 = Math.sqrt(o.x * o.x + o.y * o.y);

            if (dist1 > dist2) {
                return 1;
            } else if (dist1 < dist2) {
                return -1;
            } else return 0;
        }

        @Override
        public String toString() {
            return name + " " + x + " " + y;
        }
    }

    /**
     * Zwyka obudowana caa implementacja kolka i krzyzyk
     */
    public static class TicTacToe {

        public static final int O = 0;
        public static final int X = 1;
        public static final int P = -1;
        public static int aktualnyGracz = O;
        /**
         * Cokolwiek, widac to dopiero gdy ktos wygral, a wtedy ma normalna wartosc
         */
        private static int wygrany = -2;

        public static void TickTacToe() {
            int[][] T = new int[3][3];

            for (int i = 0; i < T.length; i++) {
                for (int j = 0; j < T[i].length; j++) {
                    T[i][j] = P;
                }
            }

            while (!czyKtosWygral(T)) {
                wyswietl(T);

                System.out.println("Twoja kolej: " + (aktualnyGracz == O ? "O" : "X"));

                int x = s.nextInt(), y = s.nextInt();

                if (T[x][y] == P) {
                    T[x][y] = aktualnyGracz;
                    aktualnyGracz = (aktualnyGracz == O) ? X : O;

                } else {
                    System.out.println("Sorki, pole juz zajete");
                }

                System.out.println("=================================");
            }
            System.out.println("HURA WYGRAŁES " + (wygrany == X ? "X" : "O") + " !!111oneoneone");

        }

        public static boolean czyKtosWygral(int[][] t) {
            if (t[0][0] == t[0][1] && t[0][1] == t[0][2]) {
                if (t[0][1] != P) {
                    wygrany = t[0][1];
                    return true;
                }
            }
            if (t[1][0] == t[1][1] && t[1][1] == t[1][2]) {
                if (t[1][0] != P) {
                    wygrany = t[1][0];
                    return true;
                }
            }
            if (t[2][0] == t[2][1] && t[2][1] == t[2][2]) {
                if (t[2][0] != P) {
                    wygrany = t[2][0];
                    return true;
                }
            }

            for (int x = 0; x < t.length; x++) {
                if (t[0][x] == t[1][x] && t[1][x] == t[2][x]) {
                    if (t[2][x] != P) {
                        wygrany = t[2][x];
                        return true;
                    }
                }
            }

            if (t[0][0] == t[1][1] && t[1][1] == t[2][2]) {
                if (t[2][2] != P) {
                    wygrany = t[2][2];
                    return true;
                }
            }
            if (t[0][2] == t[1][1] && t[1][1] == t[2][0]) {
                if (t[0][2] != P) {
                    wygrany = t[0][2];
                    return true;
                }
            }

            return false;
        }

        public static void wyswietl(int[][] tab) {
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    System.out.print(padRight(String.valueOf(tab[i][j]), 3));
                }
                System.out.println();
            }
        }
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
