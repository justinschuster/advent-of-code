#!/usr/bin/env python
# -*- coding: utf-8 -*-

input_file = 'input.txt'
target_sum = 2020

def read_input(file_string):
    f = open(file_string, "r")
    input_arr = f.read().split("\n")
    return input_arr

def type_handler(entry):
    num = 0
    try:
        num = int(entry)
    except ValueError:
        num = int(float(entry)) 
    return num

def number_finder(arr, target_sum):
    arr_len = len(arr)
    for i in range(arr_len):
        if arr[i] == '':
            break
        num1 = type_handler(arr[i])
        if num1 <= 2020:
            for j in range(arr_len):
                if arr[j] == '':
                    break
                num2 = type_handler(arr[j])
                if num2 <= 2020:
                    if num1 + num2 == 2020:
                        print(num1 * num2)
                        return
 

input_arr = read_input(input_file)
number_finder(input_arr, target_sum)
