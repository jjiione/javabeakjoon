#include <bits/stdc++.h>

using namespace std;
int N, M;
int number[9];

void combination(int cnt, int start) {
	if (cnt > M) {
		for (int i = 1; i <= M; i++) {
			cout << number[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = start; i <= N; i++) {
		number[cnt] = i;
		combination(cnt + 1, i + 1);

	}
}
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

	cin >> N >> M;
	combination(1, 1);

    
}