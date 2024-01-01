#include <bits/stdc++.h>
using namespace std;

int dr[4] = { -1, 0, 1, 0 };
int dc[4] = { 0, 1, 0, -1 };
int N, M, currR, currC, dir, ans;
int arr[50][50];
bool flag = true;
// 인접한 칸 청소 여부 확인
bool search() {
	for (int i = 0; i < 4; i++) {
		int nr = currR + dr[i];
		int nc = currC + dc[i];
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 0)  // 청소 안한 칸이 있는 경우
			return true;  
	}
	return false;  // 인접한 칸이 모두 청소되어 있음
}

void moveBack() {
	int nr = currR + dr[(dir + 2) % 4];
	int nc = currC + dc[(dir + 2) % 4];
	if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] != 1) {  // 이동 가능할 때
		currR = nr;
		currC = nc;
	}
	else flag = false;


}

void turn() {

	// 반시계 방향 90도 회전
	if (dir == 0) dir = 3;
	else dir = dir - 1;
	
	int nr = currR + dr[dir];
	int nc = currC + dc[dir];
	if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 0) {  // 청소 가능할 때
		currR = nr;
		currC = nc;
	}

}

// 로봇청소기 현재 칸 청소
void clean() {  
	if (arr[currR][currC] == 0) {
		ans++;
		arr[currR][currC] = 2;  // 청소된 칸을 의미
	}
}


int main() {

	cin >> N >> M;
	cin >> currR >> currC >> dir;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}

	
	while (flag) {
		clean();
		if (search()) turn();
		else moveBack();
	}

	cout << ans;
	

}