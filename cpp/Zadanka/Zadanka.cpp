#include <iostream>
#include <iomanip>
#include <cmath>
#include <string>
#include <vector>
#include <strstream>
using namespace std;

#pragma region youngcoder

static int nwdModRecursive(int a, int b) {
	if (b != 0)
		return nwdModRecursive(b, a % b);
	return a;
}
static int tribonacci(int n){
	if (n == 0)
		return -1;
	if (n == 1) {
		cout << 0 << " ";
		return 0;
	}
	else if (n == 2) {
		cout << "0 0 ";
		return 1;
	}

	int prev = 1;
	int prevprev = 0;
	int prevprevprev = 0;
	int actual = 1;

	cout << prevprevprev << " " << prevprev << " " << prev << " ";
	for (int i = 3; i < n; i++) {

		actual = prev + prevprev + prevprevprev;
		cout << actual << " ";

		prevprevprev = prevprev;
		prevprev = prev;
		prev = actual;
	}
	return actual;
}
static void foo(int n){
	cout << fixed;
	cout << setprecision(5);
	if (n == 1)cout << 32.0;
	else if (n == 2)cout << 32.0 << " " << 64.0 << " ";
	else{
		int a1 = 32;
		int a2 = 64;
		double actual;
		double prev1 = a2;
		double prev2 = a1;
		cout << prev2 << " " << prev1 << " ";
		for (int i = 3; i <= n; i++){
			actual = (prev2 + prev1) / 2.0;
			cout << actual << " ";
			prev2 = prev1;
			prev1 = actual;
		}
	}
}
static void trojkatProst(){
	int x, y;
	cin >> x >> y;
	int a, b, c;
	a = x;
	b = x + 1;
	c = x + 2;
	for (int i = x; i <= y; i++){
		if (c*c == a*a + b*b){
			cout << a << " " << b << " " << c << " ";
			return;
		}
		a++;
		b++;
		c++;
	}
	cout << "brak";
}
static void cukierki(){
	int a, b, c;
	cin >> a >> b >> c;
	cout << fixed << setprecision(2);
	cout << a / 10.0 + b / 5.0 + c*(7.0 / 10.0) << " ";
}
static void rownanie(){
	int t;
	cin >> t;
	for (int i = 0; i < t; i++){
		double a, b, c;
		cin >> a >> b >> c;
		if (a == 0.0){
			if (b == 0.0){
				if (c == 0.0){
					cout << "nwr";
				}
				else{
					cout << 0;
				}
			}
			else{
				cout << 1;
			}
			cout << endl;
			continue;
		}
		double d = sqrt(b*b - 4 * a*c);
		if (d>0)cout << 2;
		else if (d == 0)cout << 1;
		else cout << 0;
		cout << endl;
	}
}
static void lustrzane(){
	int t;
	cin >> t;
	string a;
	for (int i = 0; i < t; i++)
	{
		getline(cin, a);
		long long x = 0;
		int j = 1;

		for (int i = 0; i < a.size(); i++){
			char c = a[i];
			if (c != '\0'){
				x += (a[i] - 48) * j;
				j *= 10;
			}
		}
		for (int i = a.size(); i >= 0; i--){
			char c = a[i];
			if (c != '\0'){
				x += (c - 48) * j;
				j *= 10;
			}
		}

		cout << x / 11.0 << endl;
		a.clear();
	}

}
static void max(){
	long long t;
	cin >> t;

	string *T = new string[t];
	for (long long i = 0; i < t; i++)
	{
		getline(cin, T[i]);
	}

	long ilosc = 0;
	long s = T[0].size();

	vector<string> vec;
	int vecLast = 0;

	/*
	for (long long  i = 0; i < t; i++)
	{
	if (T[i][0] != '-' && T[i].size() > s){
	s = T[i].size();
	vec[vecLast] = T[i];
	} else if (T[i][0] == '-' && T[i].size()-1>s)
	}
	*/
}

static void decToBin(){
	int x;
	string s;
	strstream ss;
	cin >> x;
	while (x != 0){
		ss << x % 2;
		x /= 2;
	}
	ss >> s;
	for (int i = s.size() - 1; i >= 0; i--)
	{
		cout << s[i];
	}

}
static void sum(){
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		int x;
		cin >> x;
		int suma = 0;
		while (x != 0){
			suma += x % 10;
			x /= 10;
		}
		cout << suma << endl;
	}
}
static void horner(){
	int a, b, c, d;
	cin >> a >> b >> c >> d;
	int x;
	cin >> x;
	int w = (x*(x*(a*x + b) + c) + d);
	cout << w;

}
static void trojki(){
	long t;
	cin >> t;
	long long suma = 0;
	long long x = 0;

	cin >> x;
	suma += x;
	cin >> x;
	suma += x * 2;

	for (long i = 0; i < t - 4; i++)
	{
		cin >> x;
		suma += (x * 3);
	}

	cin >> x;
	suma += x * 2;
	cin >> x;
	suma += x;

	if (suma % 3 == 0){
		cout << "TAK";
	}
	else{
		cout << "NIE";
	}
	cout << endl;
}
/*
http://youngcoder.eu/index.php/node/show/17406
*/
static void mikolaj(){
	int z;
	cin >> z;

	//rzut ukoœny pod k¹tem 45stopni => sin2x => sin90st == 1
	double v0 = sqrt(z * 10);
	cout << fixed << setprecision(3) << v0;
}
/*
http://youngcoder.eu/index.php/node/show/17502
*/
static void max20(){
	int x;
	cin >> x;
	int max = x;
	int index = 0;
	for (int i = 1; i < 20; i++)
	{
		cin >> x;
		if (x > max){
			max = x;
			index = i;
		}
	}
	cout << max << endl;
	cout << index << endl;

}
/*
http://youngcoder.eu/index.php/node/show/17503
*/
static void mediana(){
	int t;
	cin >> t;
	int x;
	if (t % 2 != 0){

		t = ceil(5 / 2.0);

		for (int i = 0; i < t; i++)
		{
			cin >> x;
		}
		cout << x;
	}
	else{
		t = t / 2;
		for (int i = 0; i < t; i++)
		{
			cin >> x;
		}
		int w;
		cin >> w;
		cout << (x + w) / 2.0 << endl;
	}

}

#pragma endregion  youngcoder

#pragma region spoj
/*
http://pl.spoj.com/problems/JWSPLIN/
*/
static void proste(){

	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		double x1, y1, x2, y2, x3, y3;
		cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;

		double a1 = (y2 - y1) / (x2 - x1);
		double b1 = y1 - a1 * x1;

		double a2 = (y3 - y2) / (x3 - x2);
		double b2 = y2 - a2 * x2;

		double a3 = (y3 - y1) / (x3 - x1);
		double b3 = y1 - a3 * x1;
		if (x1 == x2&&x2 == x3){
			cout << "TAK" << endl;
		}
		else{
			if (((a1 == a2) && (a2 == a3)) && ((b1 == b2)&(b3 == b2))){
				cout << "TAK" << endl;
			}
			else{
				cout << "NIE" << endl;
			}
		}
	}
}
/*
http://pl.spoj.com/problems/BINOMS/
*/
static long long silnia(int n) {
	if (n == 1) return 1;
	int wynik = 2;
	for (int i = 1; i < n; i++) {
		wynik *= i;
	}
	return wynik;
}
static void combinations(){
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		long long a, b;
		cin >> a >> b;
		if (a == 0 || b == 0){
			cout << 1 << endl;
			continue;
		}
		int sb = silnia(b);
		long long com = silnia(a) / (silnia(a - b) * sb);
		cout << com << endl;
	}
}
#pragma endregion spoj
int main()
{
	cin.ignore();
	return 0;
}

