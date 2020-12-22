#!/usr/bin/env python
# -*- coding: utf-8 -*-

data = list(map(str, open('input.txt', 'r').readlines()))

def part_one_checker(pwd):
    letter_range = pwd[0].split('-')
    low_limit = int(letter_range[0])
    up_limit = int(letter_range[1]) 
    letter = pwd[1]
    pwd_string = pwd[2]
    if pwd_string.count(letter) >= low_limit and pwd_string.count(letter) <= up_limit: 
        return True 
    else:
        return False

def part_one(data):
    num_correct = 0
    for pwd in data:
        pwd = pwd.replace(':', '').replace('\n', '').split(' ')
        if part_one_checker(pwd):
            num_correct = num_correct + 1
    return num_correct

def part_two_checker(pwd):
    letter_positions = pwd[0].split('-')
    pos_one = int(letter_positions[0])
    pos_two = int(letter_positions[1]) 
    letter = pwd[1]
    pwd_string = pwd[2]
    if letter == pwd_string[pos_one-1] and letter != pwd_string[pos_two-1]:
        return True
    elif letter != pwd_string[pos_one-1] and letter == pwd_string[pos_two-1]:
        return True
    else:
        return False

def part_two(data):
    num_correct = 0
    for pwd in data:
        pwd = pwd.replace(':', '').replace('\n', '').split(' ')
        if part_two_checker(pwd):
            num_correct = num_correct + 1
    return num_correct

print(part_one(data))
print(part_two(data))
