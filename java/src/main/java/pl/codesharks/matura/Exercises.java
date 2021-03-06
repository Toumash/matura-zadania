package pl.codesharks.matura;


import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

@SuppressWarnings({"UnusedDeclaration", "SpellCheckingInspection"})
public class Exercises {
    /**
     * Locale ENGLISH to workaround errors in floating-point numbers
     * delimited by "," (as in Poland) not "." (World standard)
     */
    public static Scanner s = new Scanner(System.in).useLocale(Locale.ENGLISH);


    /**
     * <a href="http://pl.spoj.com/problems/KC005/">Weryfikacja formularza - SPOJ</a>
     *
     * @param line np. Imie: Roman; Nazwisko: Kowalski; Data ur.: 1900-01-30
     * @return <ul><li>0, jeżeli i-ty wczytany z wejścia formularz nie zawiera poprawnego imienia; poprawne imiona zaczynają się
     * od wielkiej litery, po której mogą nastąpić małe litery; </li>
     * <li>1, jeżeli i-ty wczytany z wejścia formularz zawiera poprawne imię, a nie zawiera poprawnego nazwiska;
     * poprawne nazwiska zaczynają się od wielkiej litery, po której następują małe litery;</li>
     * <li>2, jeżeli i-ty wczytany z wejścia formularz zawiera poprawne imię i nazwisko, a nie zawiera poprawnej daty;
     * w poprawnej dacie pole RRRR jest liczbą całkowitą z zakresu 1900-2000, pole MM jest liczbą całkowitą z zakresu 1-12,
     * a pole DD liczbą całkowitą z zakresu 1-31;</li>
     * <li>3, w pozostałych przypadkach.</li>
     * </ul>
     */
    public static int formularz(String line) {
        String[] dane = line.split(" ");
        // trzeba usuwać średniki na końcu danych
        String imie = dane[1].substring(0, dane[1].length() - 2);
        String nazwisko = dane[3].substring(0, dane[3].length() - 2);
        String data = dane[5].substring(0, dane[5].length() - 2);

        if (!czyWyraz(imie) || imie.length() > 10) {
            return 0;
        } else if (!czyWyraz(nazwisko) || nazwisko.length() > 20) {
            return 1;
        } else if (!sprawdzDate(data)) {
            return 2;
        }

        return 3;
    }

    /**
     * <a href="http://pl.spoj.com/problems/KC005/">Weryfikacja formularza - SPOJ</a>
     * II Część zadania formularz
     */
    private static boolean sprawdzDate(String data) {
        if (data.length() != 10) {
            return false;
        }

        String[] dane = data.split("-");
        if (!czyLiczba(dane[0])) {
            return false;
        }
        if (!czyLiczba(dane[1])) {
            return false;
        }
        if (!czyLiczba(dane[2])) {
            return false;
        }

        int rok = Integer.valueOf(dane[0]);
        if (!(rok >= 1900 && rok <= 2000)) {
            return false;
        }

        int miesiac = Integer.valueOf(dane[1]);
        if (!(miesiac >= 1 && miesiac <= 12)) {
            return false;
        }

        int dzien = Integer.valueOf(dane[2]);
        if (!(dzien >= 1 && dzien <= 31)) {
            return false;
        }

        return true;
    }

    public static boolean czyLiczba(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ignored) {
            // not a number
        }
        return false;
    }

    public static boolean czyWyraz(String imie) {
        char pierwsza = imie.charAt(0);
        if (!Character.isUpperCase(pierwsza)) {
            return false;
        }

        for (int i = 0; i < imie.length(); i++) {
            // isLowerCase returns true ONLY for CHARACTERS, not for digits, so further investigation is redundant
            if (!Character.isLowerCase(imie.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="http://pl.spoj.com/problems/MWPZ06X/"> Nowa działka - SPOJ</a>
     * wylicza kwadraty wpisywanych liczb
     */
    public static void nowaDzialka() {
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            System.out.println(n * n);
        }
    }

    /**
     * <a href="http://pl.spoj.com/problems/JZLICZ/">SPOJ - Zliczacz Liter</a>
     * Liczy każdą literę oddzielnie, pokazuje ile jest każdej z nich - nie zawiera tych których nie podano na wejściu
     *
     * @param text tekst do policznia literek
     */
    public static Hashtable<Character, Integer> zliczLitery(String text) {
        Hashtable<Character, Integer> table = new Hashtable<>();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (table.containsKey(character)) {
                table.put(character, table.get(character) + 1);
            } else {
                table.put(character, 1);
            }
        }
        return table;
    }


    /**
     * Liczy wyrazy i liczby w ciagu znaków
     *
     * @param linia ciąg z naków do policzenia
     * @return tablica-> 0 - wyrazy <br>
     * 1 - liczby
     */
    public static int[] zliczanieWyrazow(String linia) {
        String[] linie = linia.split(" ");
        int wyrazy = 0;
        int liczby = 0;

        for (int i = 0; i < linie.length; i++) {
            try {
                //noinspection ResultOfMethodCallIgnored
                Integer.parseInt(linie[i]);
                liczby++;
            } catch (NumberFormatException e) {
                wyrazy++;
            }
        }
        return new int[]{wyrazy, liczby};
    }

    /**
     * <a href="http://pl.spoj.com/problems/BFN1/">SPOJ - Dodawanie piotrusia</a>
     */
    public static void piotrus() {
        final int t = Integer.valueOf(s.nextLine());
        for (int i = 0; i < t; i++) {

            String input = s.nextLine();

            if (czyPalndrom(input)) {
                System.out.println(input + " " + 0);
            } else {
                int n = 0;
                String w = input;
                int wynik;
                while (true) {
                    n++;
                    wynik = Integer.valueOf(new StringBuilder(w).reverse().toString()) + Integer.valueOf(w);
                    w = String.valueOf(wynik);
                    if (czyPalndrom(w)) {
                        break;
                    }
                }
                System.out.println(w + " " + n);
            }
        }
    }

    public static boolean czyPalndrom(String x) {
        return new StringBuilder(x).reverse().toString().equals(x);
    }


    public static void szyfrCezara() {
        final int CEZAR_PRZESUNIECIE = 3;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                sb.append(PureFunctions.cezar(input.charAt(j), CEZAR_PRZESUNIECIE));
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * <a href="http://pl.spoj.com/problems/JZAPKAB/"> SPOJ - kabalistyczny sposob zapisu daty</a>
     *
     * @param input wyraz oznaczający date
     * @return data odkodowana z wyrazu
     */
    public static int kabalistyczneDaty(String input) {
        final char[] litery = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'v', 'x', 'y', 'z'};
        final int[] wartosci = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30,
                40, 50, 60, 70, 80, 90, 100, 250, 300, 400, 500};

        if (litery.length != wartosci.length) {
            throw new IllegalStateException("Niepoprawne przyporzadkowanie wartosci. Długości tablic są rózne");
        }

        //Przyporządkowanie liter do wartości
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < litery.length; i++) {
            map.put(litery[i], wartosci[i]);
        }

        int wynik = 0;
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                wynik += map.get(input.charAt(i));
            }
        }
        return wynik;
    }

    /**
     * <a href="http://pl.spoj.com/problems/NIEKOLEJ/">NIEKOLEJ - SPOJ</a>
     * wyswietla ciag liczb 1...n tak, aby obok każdej liczby delta sąsiada != 1
     */
    public static void niekolejne() {
        int n = s.nextInt();

        if (n < 2) {
            System.out.println("NIE");
        } else if (n == 2) {
            System.out.println("2 0 1 3");
        } else {
            for (int i = 0; i < n; i += 2) {
                System.out.print(i + " ");
            }
            for (int i = 1; i <= n; i += 2) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * <a href="http://pl.spoj.com/problems/JPESEL/">Sprawdzanie poprawności PESELów - SPOJ</a>
     */
    public static boolean isPESELValid(String p) {
        if (p.length() != 11) {
            return false;
        }
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};

        int wynik = 0;
        for (int i = 0, length = p.length(); i < length; i++) {
            wynik += PureFunctions.convertToInt(p.charAt(i)) * weights[i];
        }
        return wynik % 10 == 0;
    }

    /**
     * <a href="http://pl.spoj.com/problems/PP0601A2/">Test 3 - SPOJ</a>
     * wyswietla liczby dopoki nie napotka 3 par 42 i czegos innego niz 42 NAPRZEMIAN
     */
    public static void test3() {
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
     * <a href="http://pl.spoj.com/problems/JSPACE/">SPACJE - SPOJ</a>
     */
    public static void spacje() {
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
    public static void transponowanieMacierzy() {
        int w = s.nextInt();
        int k = s.nextInt();

        int[][] t = new int[w][k];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < k; j++) {
                t[i][j] = s.nextInt();
            }
        }

        int[][] transposed = PureFunctions.transposeMatrix(t);

        for (int[] tab : transposed) {
            for (int e : tab) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    /**
     * <a href="http://youngcoder.eu/index.php/node/show/17500">Youngcoder - klasy adresow IP</a>
     */
    public static void klasyAdresowIP() {
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
    public static Para[] sortujPary(Para[] tab) {
        for (int i = 0, length = tab.length; i < length; i++) {
            for (int j = 1; j < length; j++) {
                Para actual = tab[j];
                Para prev = tab[j - 1];

                if (actual.x < prev.x) {
                    Para tmp = tab[j];
                    tab[j] = tab[j - 1];
                    tab[j - 1] = tmp;
                } else if ((actual.x == prev.x) && (actual.y < prev.y)) {
                    int tmp = actual.y;
                    tab[j].y = tab[j - 1].y;
                    tab[j - 1].y = tmp;
                }
            }
        }
        return tab;
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
                boolean czyJest = PureFunctions.czyAnagramLiczenie(a, b);
                if (czyJest) {
                    System.out.println("TAK");
                } else {
                    System.out.println("NIE");
                }
            }
        }
    }

    /**
     * <a href="http://youngcoder.eu/index.php/node/show/17408">Youngcoder - suma trojek</a><br/>
     * z ciągu 1 2 3 4 5 6 7 8 9<br/>
     * sumujemy trojki<br/>
     * 123<br/>
     * 234<br/>
     * 345<br/>
     * 456<br/>
     * 567<br/>
     * 678<br/>
     * 789
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
     * <a href="http://pl.spoj.com/problems/PP0602D/">ROL(k) - SPOJ</a>
     * przesuwa elementy tablicy cyklicznie w lewo o k
     */
    public static void rolk() {
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

    /**
     * <a href="http://pl.spoj.com/problems/EUCGAME/">Gra Euklidesa - SPOJ</a>
     */
    public static void graEukl() {
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            int result = PureFunctions.nwdMod(a, b);

            System.out.println(result * 2);
        }
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

    /**
     * <a href="http://pl.spoj.com/problems/PTWPZ083/">SPOJ - Prosty kalkulator</a><br>
     * Kalkulator - pierwsza liczba potem znak '+' lub '-' itd.
     *
     * @param input równanie do wywołania
     * @return wynik działania
     */
    public static int prostyKalkulator(String input) {
        final char Z_PLUS = '+';
        final char Z_MINUS = '-';

        int sum = 0;
        char character = Z_PLUS;
        for (int i = 0; i < input.length(); i++) {
            char actualCharacter = input.charAt(i);

            //Co drugi element to liczba zaczynając od 0
            if (i % 2 == 0) {
                int number = actualCharacter - '0';
                //znak == Z_PLUS dodaj number
                //w przeciwnym wypadku dodaj ujemny number
                sum += (character == Z_PLUS) ? number : -number;
            } else {
                character = input.charAt(i);
            }
        }
        return sum;
    }

    /**
     * <a href="http://pl.spoj.com/problems/PP0602A/">SPOJ - Parzyste Nieparzyste</a>
     */
    public static int[] parzysteNieparzyste(final int[] numbers) {
        int[] shuffled = new int[numbers.length];
        int index = 0;
        for (int i = 1; i < numbers.length; i += 2) {
            shuffled[index] = numbers[i];
            index++;
        }
        for (int i = 0, length = numbers.length; i < length; i += 2) {
            shuffled[index] = numbers[i];
            index++;
        }
        return shuffled;
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


    public static int graEuklidesa(int a, int b) {

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a * 2;
    }

    /**
     * <a href="http://pl.spoj.com/problems/PP0506A/">Sortowanie punktów - SPOJ</a>
     * Sortuje punkty w zaleznosci od odległości od środka układu współrzędnych
     */
    public static void sortowaniePunktow() {
        int t;
        int n;
        t = s.nextInt();

        for (int i = 0; i < t; i++) {
            n = s.nextInt();
            Point[] T = new Point[n];
            for (int j = 0; j < n; j++) {
                int x, y;
                String nazwa;
                nazwa = s.next();
                x = s.nextInt();
                y = s.nextInt();

                Point p = new Point(nazwa, x, y);
                T[j] = p;
            }

            //Bubble sort
            for (int j = 0; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    if (T[k - 1].distance() > T[k].distance()) {
                        Point tmp = T[k - 1];
                        T[k - 1] = T[k];
                        T[k] = tmp;
                    }
                }
            }
            for (int j = 0; i < T.length; j++) {
                System.out.println(T[j].toString());

            }
        }
    }

    public static class Point implements Comparable<Point> {
        public String name;
        public int mX;
        public int mY;

        public Point(String name, int x, int y) {
            this.name = name;
            this.mX = x;
            this.mY = y;
        }

        public double distance() {
            return Math.sqrt(mX * mX + mY * mY);
        }

        @Override
        public int compareTo(@NotNull Point o) {
            double dist1 = this.distance();
            double dist2 = o.distance();

            if (dist1 > dist2) {
                return 1;
            } else if (dist1 < dist2) {
                return -1;
            } else return 0;
        }

        @Override
        public String toString() {
            return name + " " + mX + " " + mY;
        }
    }

    /**
     * Zwykła obudowana caa implementacja kolka i krzyzyk
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
            for (int[] aTab : tab) {
                for (int anATab : aTab) {
                    System.out.print(padRight(String.valueOf(anATab), 3));
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
                System.out.println(PureFunctions.stringMerge(a, b));
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
                System.out.println(PureFunctions.isPalindrome(str.replace(" ", "")) ? "t" : "n");
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

            boolean ascending = PureFunctions.isArrayAscending(T, a, b);
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
