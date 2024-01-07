#include <bits/stdc++.h>
#include <vector>

using namespace std;

vector<pair<int, int>> v;


bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second > b.second) return true;
	else return false;
}
int main() {
	int n, c, tmp;
	cin >> n >> c;
	
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		bool flag = false;
		for (auto &a : v) {
			flag = false;
			if (a.first == tmp) {
				a.second++;
				flag = true;
				break;
			}
		}
		if (!flag) v.push_back({tmp, 1});
	}
	stable_sort(v.begin(), v.end(), compare);

	for (auto a : v) {
		for (int i = 0; i < a.second; i++) {
			cout << a.first << " ";
		}
	}

}