/*
https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets

    There is a secret string which is unknown to you. Given a collection of
random triplets from the string, recover the original string.

    A triplet here is defined as a sequence of three letters such that each letter occurs
somewhere before the next in the given string. "whi" is a triplet for the string "whatisup".

    As a simplification, you may assume that no letter occurs more than once in the secret string.

    You can assume nothing about the triplets given to you other than that they are valid
triplets and that they contain sufficient information to deduce the original string.
    In particular, this means that the secret string will never contain letters that do not
occur in one of the triplets given to you.*/

const secret = "whatisup";
const triplets = [
    ['t','u','p'],
    ['w','h','i'],
    ['t','s','u'],
    ['a','t','s'],
    ['h','a','p'],
    ['t','i','s'],
    ['w','h','s']
];

const recoverSecret = (triplets) => {
    const TRIPLETS  = triplets.map((triplet, index) => (triplet.join("")));
    const UNIQUE_CHARACTERS = [...(new Set(TRIPLETS.join("")))];
    return buildStringFromTriplets(TRIPLETS, UNIQUE_CHARACTERS, "")
};

const buildStringFromTriplets = (triplets, uniqueCharacters, found) => {
    if (found.length === uniqueCharacters.length) {
        return found
    }
    for (let char of uniqueCharacters.filter((x) => !(found.includes(x)))) {
        let tripletsFiltered = triplets.filter((triplet) => (triplet.includes(char)));
        let re = new RegExp(`[${found}]`,"g");
        tripletsFiltered = tripletsFiltered.map(triplet => triplet.replace(re, ""));
        let is_match = tripletsFiltered.every(triplet => triplet[0] === char);
        if (is_match) {
            return buildStringFromTriplets(triplets, uniqueCharacters, found + char)
        }
    }

};

console.log(recoverSecret(triplets))
