#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    while(T--) {
        stack<char> s1;
        stack<char> s2;
        string L;
        cin >> L;
        for (char letter : L) {
            if (letter == '<') {
                if (s1.empty()) continue;
                s2.push(s1.top());
                s1.pop();
            } else if (letter == '>') {
                if (s2.empty()) continue;
                s1.push(s2.top());
                s2.pop();
            } else if (letter == '-') {
                if (s1.empty()) continue;
                s1.pop();
            } else {
                s1.push(letter);
            }
        }

        while(!s2.empty()) {
            s1.push(s2.top());
            s2.pop();
        }

        while(!s1.empty()) {
            s2.push(s1.top());
            s1.pop();
        }

        while(!s2.empty()) {
            cout << s2.top();
            s2.pop();
        }

        cout << '\n';
    }

    return 0;
}