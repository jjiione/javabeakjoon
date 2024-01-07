#include <bits/stdc++.h>
#include <vector>
#include <set>
using namespace std;

bool compare(const string& str1, const string& str2) {
	if (str1.length() < str2.length()) return true;
	else if (str1.length() == str2.length()) {
		if (str1.compare(str2) < 0) return true;
	}
	return false;
}
int main() {
	int n;
	set<string> s;
	vector<string> v;
	string str;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str;
		s.insert(str);
	}
	for (auto a : s) v.push_back(a);

	sort(v.begin(), v.end(), compare);
	
	for (auto a : v)
		cout << a << "\n";
}