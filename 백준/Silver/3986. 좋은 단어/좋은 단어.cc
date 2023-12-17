#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    int count = 0;
    for (int n = 0; n < N; n++) {
        stack<char> s;
        string str;
        cin >> str;
        for (auto c : str) {
            if (!s.empty() && s.top() == c)
                s.pop();
            else
                s.push(c);
        }
        if (s.empty())
            count++;
    }
    cout << count;

    return 0;
}