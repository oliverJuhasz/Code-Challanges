"""
https://www.codewars.com/kata/last-digit-of-a-large-number/train/python

Define a function that takes in two numbers a and b and returns the last decimal digit of a^b. Note that a and b may be very large!

For example, the last decimal digit of 9^7 is 9, since 9^7 = 4782969. The last decimal digit of (2^200)^(2^300), which has over 10^92 decimal digits, is 6.

The inputs to your function will always be non-negative integers.
Examples

last_digit(4, 1)                # returns 4
last_digit(4, 2)                # returns 6
last_digit(9, 7)                # returns 9
last_digit(10, 10 ** 10)        # returns 0
last_digit(2 ** 200, 2 ** 300)  # returns 6


"""

def last_digit(n1, n2):
    if n2 == 0: return 1
    last_digit_of_powers = "".join(str(n1 ** power)[-1] for power in range(1,11))
    for i in range(1,10):
        if last_digit_of_powers.count(last_digit_of_powers[:i]) == 1:
            repetition = last_digit_of_powers[:i - 1]
            break
    remainder = n2 % len(repetition)
    return int(repetition[remainder - 1])
