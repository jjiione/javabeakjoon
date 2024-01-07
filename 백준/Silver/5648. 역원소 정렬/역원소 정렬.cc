#include <bits/stdc++.h>
#include <vector>
using namespace std;

int main() {
	vector<long long>v;
	int n;
	string str;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> str;
		reverse(str.begin(), str.end());
		v.push_back(stoll(str));
	}

	sort(v.begin(), v.end());
	for (auto i : v) {
		cout << i << '\n';
	}
		
}