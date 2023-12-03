#include <bits/stdc++.h>

using namespace std;

int main(void) {
	int input;
	int total = 1;
	int num[10] = {};
	for (int i = 0; i < 3; i++) {
		cin >> input;
		total *= input;
	}

	while (total > 0) {
		num[total % 10]++;
		total /= 10;
		// cout << total << "\n";
	}

	for (int i = 0; i < 10; i++) {
		cout << num[i] << "\n";
	}
	
}