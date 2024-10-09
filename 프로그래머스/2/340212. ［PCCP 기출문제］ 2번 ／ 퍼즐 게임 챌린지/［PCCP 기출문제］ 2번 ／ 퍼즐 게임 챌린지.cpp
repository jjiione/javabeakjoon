#include <bits/stdc++.h>

using namespace std;
bool find(int level, vector<int>& diffs, vector<int>& times, long long limit){
    long long prev = 0;
    long long curr = 0;
    for(int i=0; i<diffs.size(); i++){
        if(level >= diffs[i])
        {
            curr += times[i];
        }
        else
        {
            long long repeat = diffs[i] - level;  
            curr += times[i] + (times[i] + prev) * repeat;
        }
        prev = times[i];
        if(curr > limit) return false;
           
    }
    return true;
}

int solution(vector<int> diffs, vector<int> times, long long limit) {
    int answer = INT_MAX;
    // 이분탐색
    int left = 1;
    int right = 1000000;
    
    while(left <= right){
        int mid = (right + left) / 2;
        if(find(mid, diffs, times, limit)){
            // cout << "test \n";
            answer = min(answer, mid);
             right = mid - 1;
        }else{
            left = mid + 1;
        }
    }
    
    return answer;
}