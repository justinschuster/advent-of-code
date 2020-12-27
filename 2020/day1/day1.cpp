#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

vector<int> read_file() {
    vector<int> numbers;
    fstream input_file;
    input_file.open("input.txt", ios::in);
    if (input_file.is_open()) {
        string line;
        int num;
        while(getline(input_file, line)) {
            numbers.push_back(stoi(line));
        }
        input_file.close();
    } else {
        cout << "File not found.";
    } 
    return numbers; 
}

int check_seen(vector<int> seen, int num) {
    for (int i = 0; i < seen.size(); i++) {
        if (seen[i] == num) {
            return 1;
        }
    }
    return 0;
}

int main() {
    vector<int> nums;
    vector<int> seen;

    nums = read_file();
    for (int i = 0; i < nums.size(); i++) {
        int j = 2020 - nums[i];   
        if (check_seen(nums, j)) {
            cout << nums[i] << endl;
            cout << j << endl;
            int prod = j*nums[i];
            cout << prod << endl;
            return 0;
        }
        seen.push_back(i);
    }

    return 0;
}
