"""
https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets

There is a secret string which is unknown to you. Given a collection of
random triplets from the string, recover the original string.

A triplet here is defined as a sequence of three letters such that each letter occurs 
somewhere before the next in the given string. "whi" is a triplet for the string "whatisup".

As a simplification, you may assume that no letter occurs more than once in the secret string.

You can assume nothing about the triplets given to you other than that they are valid 
triplets and that they contain sufficient information to deduce the original string. 
In particular, this means that the secret string will never contain letters that do not 
occur in one of the triplets given to you."""


def recoverSecret(triplets):
    triplets = [''.join(triplet) for triplet in triplets]
    characterset = set(''.join(triplets))
    return findnext(triplets, characterset, "")

def findnext(triplets, characterset, found):
    if len(found) == len(characterset): return found
    for char in characterset - set(found):
        triplets_filtered = [triplet.lstrip(found) for triplet in triplets if char in triplet]
        match = all(triplet[0]==char for triplet in triplets_filtered)
        if match:
            return findnext(triplets, characterset, found + char)
            