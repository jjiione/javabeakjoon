import sys, bisect, collections

# 입력부
n = int(sys.stdin.readline())

# zero : y=0인 교점의 x좌표를 저장하는 set
zero = set()
arr = []
for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    arr.append((a, b))
for i in range(n):
    x1, y1 = arr[i]
    x2, y2 = arr[(i + 1) % n]
    
    # now와 next의 y좌표의 부호가 다른 경우 zero에 추가
    if x1 == x2 and y1 * y2 < 0:
        zero.add(x1)
        
# x좌표 기준 오름차순 정렬
zero = sorted(zero)

# cache : zero에 있는 점들의 x좌표를 key, 인덱스를 value로 갖는 딕셔너리
cache = dict()
for i in range(len(zero)):
    cache[zero[i]] = i

# res : (시작점, 끝점)의 튜플을 저장하는 리스트
res = []

# now : 대응되는 2개의 점을 묶어주는 deque
now = collections.deque()

# check : 현재 인덱스가 방문했는지 점검하는 배열
check = [False] * n
temp = sorted(arr, key=lambda x : (x[0], x[1]))

# 가장 왼쪽 하단에 있는 점의 인덱스를 찾음
val = temp[0]
idx = -1
for i in range(n):
    if arr[i] == val:
        idx = i
        break

# idx가 0이라는 보장이 없으므로 modulo 연산을 통해 원형으로 순회
while not check[(idx + 1) % n]:
    check[idx] = True
    x1, y1 = arr[idx]
    x2, y2 = arr[(idx + 1) % n]
    # y=0의 교점 조건에 만족하면 deque에 삽입
    if x1 == x2 and y1 * y2 < 0:
        now.append(x1)
        # 갯수가 2개라면 대응되는 쌍을 찾았음으로 res에 추가
        if len(now) >= 2:
            first = now.popleft()
            second = now.popleft()
            res.append((min(first, second), max(first, second)))
    idx += 1
    idx %= n

# dots : y=0에서의 교점의 x좌표를 key, (시작/끝을 나타내는 flag, 인덱스)의 튜플을 value로 갖는 딕셔너리
dots = dict().fromkeys(zero)
for i in res:
    idx1 = cache[i[0]]
    idx2 = cache[i[1]]
    dots[i[0]] = (1, idx1)
    dots[i[1]] = (-1, idx2)

# st : 스택 리스트
st = []

# outside : 가장 바깥쪽 봉우리 갯수
outside = 0
# inside : 가장 안쪽 봉우리 갯수
inside = 0

# cnt : 현재 스택안에 남은 좌표의 갯수
cnt = 0
for i in dots:
    # 끝점이라면 스택에서 pop
    if dots[i][0] == -1:
        _, idx = st.pop()
        # 남은 좌표 갯수 1 차감
        cnt -= 1
        # 스택이 빈 경우는 가장 바깥쪽 봉우리이므로 outside 1증가
        if cnt == 0:
            outside += 1
        # 인덱스가 1차이 나는 경우는 가장 안쪽 봉우리이므로 inside 1증가
        if abs(dots[i][1] - idx) == 1:
            inside += 1
            
    # 시작점이면 무조건 스택에 push
    else:
        st.append(dots[i])
        cnt += 1

# 정답 출력
print(outside, inside)