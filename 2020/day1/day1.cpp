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

int part_one(vector<int> nums) {
    vector<int> seen;

    for (int i = 0; i < nums.size(); i++) {
        int j = 2020 - nums[i];   
        if (check_seen(nums, j)) {
            int prod = j*nums[i];
            cout << "Part One: " << prod << endl;
            return 0;
        }
        seen.push_back(i);
    }

    return 1;
}

int part_two(vector<int> nums) {
    vector<int> seen;
    vector<int> two_sum;

    for (int i = 0; i < nums.size(); i++) {
        for (int j = 0; j < two_sum.size(); j++) {
            int k = 2020 - nums[i] - two_sum[j];
            if (check_seen(nums, k)) {
                int prod = k * nums[i] * two_sum[j];
                cout << "Part Two: " << prod << endl;
                return 0;
            }
        }
        seen.push_back(nums[i]);
        two_sum.push_back(nums[i]);
    }

    return 1;
}

int main() {
    vector<int> nums; 

    nums = read_file();
    if (part_one(nums)) {
        cout << "error in part one." << endl;
        return 1;
    }

    if (part_two(nums)) {
        cout << "Error in Part Two." << endl;
        return 1;
    }
    
    return 0;
}
