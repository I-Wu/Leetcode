#include <iostream>
#include <limits>
#include <string>
#include <vector>

using namespace std;
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int temp = 0;
    vector<int> input;
    string line;
    while (getline(cin, line)){
        input.push_back(stoi(line));
    }
    int len = input.size();
    /*special case for len = 1*/
    if(len == 1){
        if(input[0] != 0)
            cout << "0, out";
        else
            cout << "failure";
        return 0;
    }
    vector<int> output;
    output.push_back(0);
    bool flag = false;
    int jumps = 0;
    int curEnd = 0;
    int curFarest = 0;
    for(int i = 0; i < len; i++){
        if(i+input[i] > curFarest){
            curFarest = i + input[i];
            if(curFarest >= len){
                flag = true;
                break;
            }
        }
        if(i == curEnd){
            jumps++;
            curEnd = curFarest;
            output.push_back(curEnd);
        }
    }
    if(flag){
        for(int i = 0; i < output.size(); i++)
            cout << output[i] << ", ";
        cout << "out";
    }
    else
        cout << "failure";
    /* this is my original method using dp, time complexity is O(n^2), further improved to previous one O(n)
    int dp[len];
    int next_id[len];
    for(int i = 0; i < len; i++){
        dp[i] = numeric_limits<int>::max();
        next_id[i] = -1;
    }
    if(input[len-1] > 0)
        dp[len-1] = 1;
    for(int i = len-2; i >=0; i--){
        int temp = numeric_limits<int>::max();
        if(i+input[i] >= len){
            dp[i] = 1;
            next_id[i] = -1;
            continue;
        }
        for(int j = 1; j <= input[i]; j++){
            if(dp[i+j] == numeric_limits<int>::max())
                continue;
            temp = min(dp[i+j]+1, temp);
            next_id[i] = i+j;
        }
        dp[i] = temp;
    }
    int start = next_id[0];
    if(start == -1){
        cout << "failure";
        return 0;
    }
    cout << "0, "; 
    while(true){
        if(start != -1){
            cout << start << ", ";
            start = next_id[start];
        }
        else{
            cout << "out";
            break;
        }
    }
    */
    return 0;
}