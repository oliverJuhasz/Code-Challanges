"""

https://www.codewars.com/kata/number-of-measurements-to-spot-the-counterfeit-coin/train/python

I found this interesting interview question just today:

    8 coins are given where all the coins have equal weight, except one. The odd one weights less than the others,
    not being of pure gold. In the worst case, how many iterations are actually needed to find the odd one out on a
    two plates scale.

I am asking you then to tell me what is the minimum amount of weighings it will take to measure n coins in every
possible occurrence (including worst case scenario, ie: without relying on luck at all).

n is guaranteed to be a positive integer.

Tip: being able to think recursively might help here :p

Note: albeit this is more clearly a logical than a coding problem, do not underestimate (or under-rank) the kata
for requiring not necessarily wizard-class coding skills: a good coder is a master of pattern recognition and
subsequent optimization ;)

"""

def how_many_measurements(coin):
    measurements = 1
    if coin == 1:
        return 0
    elif coin < 4:
        return 1
    else:
        if int(coin / 3) % 2 == 0:
            measurements += how_many_measurements(int(coin / 3))
        elif int(coin / 3) % 2 != 0:
            measurements += how_many_measurements(int(coin / 3 + 1))
    return measurements