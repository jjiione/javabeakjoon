#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int K;
    int sum = 0;
    stack<int> s;
    cin >> K;
    for (int i = 0; i < K; i++) {
        int input;
        cin >> input;
        if (input == 0) {
            sum -= s.top();
            s.pop();
        }
        else {
            s.push(input);
            sum += input;
        }
    }
    cout << sum;

    return 0;
}