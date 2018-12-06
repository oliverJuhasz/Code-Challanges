"""

https://www.codewars.com/kata/spelling-bee/train/python

How many bees are in the beehive?

    bees can be facing UP, DOWN, LEFT, or RIGHT
    bees can share parts of other bees

Examples

Ex1

bee.bee
.e..e..
.b..eeb

Answer: 5

Ex2

bee.bee
e.e.e.e
eeb.eeb

Answer: 8
Notes

    The hive may be empty or null
    Python: the hive is passed as a list of lists (not a list of strings)


"""

import re

def how_many_bees(hive):
    if hive == [] or hive == None: return 0
    counter = 0
    hive.extend(list(list(hive[i][i2] for i in range(len(hive))) for i2 in range(len(hive[1]))))
    for elem in hive:
        counter += len(re.findall("bee","".join(elem)))
        counter += len(re.findall("bee","".join(elem)[::-1]))
    return counter
