#include <bits/stdc++.h>
#include <math.h>

using namespace std;

int main(void) {
	int ans = 0;
	int num[10] = {};
	string input;
	cin >> input;
	for (int i = 0; i < input.length(); i++) {
		num[input[i] - '0'] += 1;
	}

	num[6] = ceil((num[6] + num[9]) / 2.0);
	for (int i = 0; i < 9; i++) {
		ans = ans < num[i] ? num[i] : ans;
	}
	cout << ans;
	
}