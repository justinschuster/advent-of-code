#!/usr/bin/env python
# -*- coding: utf-8 -*-

input_file = 'input.txt'

data = list(map(int, open(input_file, 'r').readlines()))

def part_one(data):
    seen = set()
    for num1 in data:
        num2 = 2020 - num1
        if num2 in seen:
            return num1 * num2
        seen.add(num1)

def part_two(data):
    seen = set()
    two_sum = []
    for i in data:
        for j in two_sum:
            k = 2020 - i - j
            if k in seen:
                return i * j * k
        seen.add(i)
        two_sum.append(i)


print(part_one(data))
print(part_two(data))
