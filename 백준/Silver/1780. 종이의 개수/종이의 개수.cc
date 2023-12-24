#include <bits/stdc++.h>
using namespace std;
int one, zero, m;
int arr[2187][2187];


void recursive(int n, int y, int x) {
    int firstNum = arr[y][x];
    if (n == 0) {
        return;
    }
    for (int i = y; i < y + n; i++) {
        for (int j = x; j < x + n; j++) {
            if (arr[i][j] != firstNum) {
                recursive(n / 3, y, x);
                recursive(n / 3, y, x + n / 3);
                recursive(n / 3, y, x + n / 3 + n / 3);

                recursive(n / 3, y + n / 3, x);
                recursive(n / 3, y + n / 3, x + n / 3 );
                recursive(n / 3, y + n / 3, x + n / 3 + n / 3);

                recursive(n / 3, y + n / 3 + n / 3, x );
                recursive(n / 3, y + n / 3 + n / 3, x + n / 3);
                recursive(n / 3, y + n / 3 + n / 3, x + n / 3 + n / 3);
                return;
            }
        }
    }
    if (firstNum == 0) {
        zero++;
    }
    else if (firstNum == 1) {
        one++;
    }
    else m++;
	
}
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    string str;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    recursive(n, 0, 0);

    cout << m << '\n';
    cout <<zero << '\n';
    cout << one << '\n';
    
}