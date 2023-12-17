
#include <iostream>
#include <queue>
using namespace std;

int T, M, N, K, ans;
int arr[51][51];
bool visited[51][51];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
queue <pair<int, int >> q;

void bfs(int x, int y) {
    visited[x][y] = true;
    q.push({ x,y });
    while (!q.empty()) {
        auto cur = q.front(); q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visited[nx][ny] || arr[nx][ny] != 1) continue;
            visited[nx][ny] = true;
            q.push({ nx,ny });
        }
    }
}


int main() {
    ios_base::sync_with_stdio(false);
    cin >> T;

    for (int t = 0; t < T; t++) {
        cin >> M >> N >> K;
        int x, y;
        int sum = 0;
        for (int j = 0; j < K; j++) {
            cin >> y >> x;
            arr[x][y] = 1;  
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    sum++;
                }
                
            }
        }
        
        cout << sum << "\n";
        for (int i = 0; i < N; i++) {
            fill(arr[i], arr[i] + M, 0);
            fill(visited[i], visited[i] + M, 0);
        }
    }
    


    return 0;
}