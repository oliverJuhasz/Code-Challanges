"""

https://www.codewars.com/kata/the-deaf-rats-of-hamelin

Story

The Pied Piper has been enlisted to play his magical tune and coax all the rats out of town.

But some of the rats are deaf and are going the wrong way!
Kata Task

How many deaf rats are there?
Legend

    P = The Pied Piper
    O~ = Rat going left
    ~O = Rat going right

Example

    ex1 ~O~O~O~O P has 0 deaf rats

    ex2 P O~ O~ ~O O~ has 1 deaf rat

    ex3 ~O~O~O~OP~O~OO~ has 2 deaf rats




"""

def count_deaf_rats(town):
    town = town.partition("P")
    rats = town[0].replace(" ","") + town[2][::-1].replace(" ","")
    rats_in_list = list(rats[i:i+2] for i in range(0, len(rats), 2) if rats[i:i+2] != "~O")
    return len(rats_in_list)
