#include <bits/stdc++.h>
#include <queue>
using namespace std;

int K, N;
int main(void) {
	cin >> N>> K;
	cout << "<";
	queue<int> q;
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}
	while (q.size() > 1) {
		for (int i = 0; i < K - 1; i++) {
			q.push(q.front());
			q.pop();
		}
		cout << (q.front()) << ", ";
		q.pop();
	}
	cout << (q.front()) << ">";
	

}