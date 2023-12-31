#include <bits/stdc++.h>
#include <limits.h>
#include <vector>
using namespace std;

int N; 
int max_num = INT_MIN;
int min_num = INT_MAX;
char result[10];
bool is_selected[10];
int number[11];
vector<char> v;


void permutation(int cnt, int N) {
	if (cnt >= N - 1) {
		int tmp = number[0];

		for (int i = 0; i < N - 1; i++) {
			if (result[i] == '+') {
				tmp += number[i + 1];
			}
			else if (result[i] == '-') {
				tmp -= number[i + 1];
			}
			else if (result[i] == '*') {
				tmp *= number[i + 1];
			}
			else {
				tmp /= number[i + 1];
			}
		}
		//cout << "tmp : " << tmp << "\n";
		min_num = min(min_num, tmp);
		max_num = max(max_num, tmp);

		return;
	}

	for (int i = 0; i < N-1; i++) {
		if (!is_selected[i]) {
			is_selected[i] = true;
			result[cnt] = v[i];
			permutation(cnt + 1, N);
			is_selected[i] = false;
		}
	}

}

int main() {

	cin >> N;
	int plus, minus, mul, div;
	for (int i = 0; i < N; i++) {
		cin >> number[i];
	}
	
	cin >> plus >> minus >> mul >> div;
	
	
	for (int i = 0; i < plus; i++) v.push_back('+');
	for (int i = 0; i < minus; i++) v.push_back('-');
	for (int i = 0; i < mul; i++) v.push_back('*');
	for (int i = 0; i < div; i++) v.push_back('/');

	permutation(0, N);
	cout << max_num << "\n" << min_num << "\n";

}