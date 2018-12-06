"""

https://www.codewars.com/kata/bowling-pins/train/python

Mount the Bowling Pins!
Task:

Did you ever play Bowling? Short: You have to throw a bowl into 10 Pins arranged like this:


I I I I  # each Pin has a Number:    7 8 9 10
 I I I                                4 5 6
  I I                                  2 3
   I                                    1

You will get an Array with Numbers, e.g.: [3,5,9] and remove them from the field like this:


I I   I
 I   I
  I
   I

Return a string with the current field.

Note that:

String.prototype.replace() is not allowed!

    You begin a new line with \n
    Each Line must be 7 chars long
    Fill the missing pins with a whitespace

Have fun!

"""

def bowling_pins(to_remove):
    pins = dict(zip(list(i for i in range(1,11)),list("I" for i in range(1,11))))
    for number in to_remove:
        pins[number] = " "
    return "{6} {7} {8} {9}\n {3} {4} {5} \n  {1} {2}  \n   {0}   ".format(*list(pins[i] for i in range(1,11)))