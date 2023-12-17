#include <bits/stdc++.h>
using namespace std;

int dx[6] = { 0, 0, 1, -1, 0, 0 };
int dy[6] = { 1, -1, 0, 0, 0, 0 };
int dz[6] = { 0, 0, 0, 0, 1, -1 };
int arr[103][103][103];
int visited[103][103][103];
queue<tuple<int, int, int>> q;
int M, N, H;
int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> M >> N >> H;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                int tmp;
                cin >> tmp;
                arr[j][k][i] = tmp;
                if (tmp == 1) q.push({ j, k, i });
                if (tmp == 0) visited[j][k][i] = -1;
            }
        }
    }

    while (!q.empty()) {
        auto cur = q.front();
        q.pop();
        int curX, curY, curZ;
        tie(curX, curY, curZ) = cur;
        for (int dir = 0; dir < 6; dir++) {
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];
            int nz = curZ + dz[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
            if (visited[nx][ny][nz] >= 0) continue;
            visited[nx][ny][nz] = visited[curX][curY][curZ] + 1;
            q.push({ nx, ny, nz });
        }
    }

    int ans = 0;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if (visited[j][k][i] == -1) {
                    cout << -1 << "\n";
                    return 0;
                }
                ans = max(ans, visited[j][k][i]);
            }
        }
    }
    cout << ans << "\n";
    return 0;
}