#include <bits/stdc++.h>
using namespace std;

int main() {
    string str;
    cin >> str;
    int stick = 1;
    int cnt = 0;
    for (int i = 1; i< str.length(); i++) {
        if (str[i] == ')') {
            if (str[i - 1] == '(') {
                stick--;
                cnt += stick;
            }
            else {
                stick--;
                cnt += 1;
            }

        }
        else {
            stick++;
        }

    }
    cout << cnt;
    return 0;
}