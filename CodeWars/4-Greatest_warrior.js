//
// https://www.codewars.com/kata/the-greatest-warrior/train/javascript
//
// Create a class called Warrior which calculates and keeps track of their level and skills, and ranks them as the
// warrior they've proven to be.
//
// Business Rules:
//
//     A warrior starts at level 1 and can progress all the way to 100.
// A warrior starts at rank "Pushover" and can progress all the way to "Greatest".
//     The only acceptable range of rank values is "Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage",
//     "Elite", "Conqueror", "Champion", "Master", "Greatest".
//     Warriors will compete in battles. Battles will always accept an enemy level to match against your own.
//     With each battle successfully finished, your warrior's experience is updated based on the enemy's level.
//     The experience earned from the battle is relative to what the warrior's current level is compared to the level
//     of the enemy.
// A warrior's experience starts from 100. Each time the warrior's experience increases by another 100, the warrior's
// level rises to the next level.
// A warrior's experience is cumulative, and does not reset with each rise of level. The only exception is when the
// warrior reaches level 100, with which the experience stops at 10000
// At every 10 levels, your warrior will reach a new rank tier. (ex. levels 1-9 falls within "Pushover" tier, levels
// 80-89 fall within "Champion" tier, etc.)
// A warrior cannot progress beyond level 100 and rank "Greatest".
//
//     Battle Progress Rules & Calculations:
//
// If an enemy level does not fall in the range of 1 to 100, the battle cannot happen and should return "Invalid level".
//     Completing a battle against an enemy with the same level as your warrior will be worth 10 experience points.
//     Completing a battle against an enemy who is one level lower than your warrior will be worth 5 experience points.
//     Completing a battle against an enemy who is two levels lower or more than your warrior will give 0 experience
//     points.
//     Completing a battle against an enemy who is one level higher or more than your warrior will accelarate your
//     experience gaining. The greater the difference between levels, the more experinece your warrior will gain.
//     The formula is 20 * diff * diff where diff equals the difference in levels between the enemy and your warrior.
//     However, if your warrior is at least one rank lower than your enemy, and at least 5 levels lower, your warrior
//     cannot fight against an enemy that strong and must instead return "You've been defeated".
//     Every successful battle will also return one of three responses: "Easy fight", "A good fight", "An intense fight".
//     Return "Easy fight" if your warrior is 2 or more levels higher than your enemy's level. Return "A good fight" if
//     your warrior is either 1 level higher or equal to your enemy's level. Return "An intense fight" if your warrior's
//     level is lower than the enemy's level.
//
//     Logic Examples:
//
//     If a warrior level 1 fights an enemy level 1, they will receive 10 experience points.
//     If a warrior level 1 fights an enemy level 3, they will receive 80 experience points.
//     If a warrior level 5 fights an enemy level 4, they will receive 5 experience points.
//     If a warrior level 3 fights an enemy level 9, they will receive 720 experience points, resulting in the warrior
//     rising up by at least 7 levels.
//     If a warrior level 8 fights an enemy level 13, they will receive 0 experience points and return "You've been
//     defeated". (Remember, difference in rank & enemy level being 5 levels higher or more must be established for this.)
//   If a warrior level 6 fights an enemy level 2, they will receive 0 experience points.
//
//     Training Rules & Calculations:
//
// In addition to earning experience point from battles, warriors can also gain experience points from training.
//     Training will accept an array of three elements (except in java where you'll get 3 separated arguments): the
//     description, the experience points your warrior earns, and the minimum level requirement.
// If the warrior's level meets the minimum level requirement, the warrior will receive the experience points from it
// and store the description of the training. It should end up returning that description as well.
// If the warrior's level does not meet the minimum level requirement, the warrior doesn not receive the experience
// points and description and instead returns "Not strong enough", without any archiving of the result.


function Warrior () {
  this.stats = {
    level: 1,
    experience: 100,
    rank: "Pushover",
    achievements: []
  };

  //Constants
  this.ranks = {0: "Pushover",
    10: "Novice", 20: "Fighter", 30: "Warrior", 40: "Veteran", 50: "Sage",
    60: "Elite", 70: "Conqueror", 80: "Champion", 90: "Master", 100: "Greatest"
  };

  //Getters
  this.level = () => {return this.stats.level};
  this.experience = () => {return this.stats.experience};
  this.rank = () => {return this.stats.rank};
  this.achievements = () => {return this.stats.achievements};

  //Setters
  this.gainXP = (XP) => {
    this.stats.experience += XP;
    if (this.stats.experience > 10000) {
      this.stats.experience = 10000
    }
    this.stats.level = Math.floor(this.stats.experience / 100);
    this.stats.rank = this.calcRank(this.stats.level)
  };

  this.calcRank = (level) => {
    return this.ranks[(Math.floor((level/10)) * 10)]
  };

  this.training = (trainingDetails) => {
    let trainingLevel = trainingDetails[2];
    let trainingExperience = trainingDetails[1];
    let trainingDescription = trainingDetails[0];
    if (trainingLevel <= this.stats.level) {
      this.stats.achievements.push(trainingDescription);
      this.gainXP(trainingExperience);
      return trainingDescription
    } else {
      return "Not strong enough"
    }
  };

  this.battle = (level) => {
    if (level <= 0 || level > 100 ) {
      return "Invalid level"
    } else if (level === this.stats.level) {
      this.gainXP(10);
      return "A good fight"
    } else if (level === this.stats.level - 1) {
      this.gainXP(5);
      return "A good fight"
    } else if (level <= this.stats.level - 2) {
      return "Easy fight"
    } else if (level >= this.stats.level +5 && this.calcRank(level) !== this.calcRank(this.stats.level)) {
      return "You've been defeated"
    } else {
      this.gainXP(20 * Math.pow((level - this.stats.level), 2));
      return "An intense fight"
    }
  }
}

const assert = require('assert');

var Goku = new Warrior();

assert.deepEqual(Goku.level(), 1, "All warriors must start as LV 1")
assert.deepEqual(Goku.rank(), "Pushover", "All warriors must start as a Pushover")
assert.deepEqual(Goku.achievements(), [], "All warriors must start off with no achievements to their name")
assert.deepEqual(Goku.training(["Do ten push-ups", 95, 1]), "Do ten push-ups", "After obtaining a mastery, the achievement must be listed and returned")
assert.deepEqual(Goku.level(), 1, "After your warriors's first training, he/she must still be LV 1")
assert.deepEqual(Goku.battle(0), "Invalid level", "LV 0 enemies do not exist. This must be a mistake!")
assert.deepEqual(Goku.battle(1), "A good fight", "After fighting against a warrior of equal level, your warrior should provide the appropiate response")
assert.deepEqual(Goku.level(), 2, "With that fight under your belt, your warrior should now be ascended to LV 2")
assert.deepEqual(Goku.achievements(), ["Do ten push-ups"], "Don't forget what your warrior has achieved so far")
assert.deepEqual(Goku.rank(), "Pushover", "A pushover, however, your warrior should remain")
assert.deepEqual(Goku.battle(3), "An intense fight", "Another battle, this time with a slightly more skilled enemy, should have your warrior provide an appropiate response")
assert.deepEqual(Goku.level(), 2, "Your should still remain LV 2")
assert.deepEqual(Goku.training(["Survive one night at the Forest of Death", 170, 2]), "Survive one night at the Forest of Death", "After obatining a mastery, your achievement must be listed and returned")
assert.deepEqual(Goku.training(["Mastered the Spirit Bomb", 1580, 10]), "Not strong enough", "Your warrior isn't skilled enough to do everything just yet")
assert.deepEqual(Goku.achievements(), ["Do ten push-ups", "Survive one night at the Forest of Death"], "Your warrior shouldn't forget his achievements")
assert.deepEqual(Goku.battle(2), "A good fight", "Your enemy isn't exactly your level. Provide the appropriate response")
assert.deepEqual(Goku.level(), 4, "Your warrior should now be LV 3")
assert.deepEqual(Goku.experience(), 400, "Your warrior's experience should be relative to his level")
assert.deepEqual(Goku.battle(9), "An intense fight", "Your warrior picked a fight with a relatively strong enemy. Nothing he can't hold his/er own to. Prpvide the appropiate response")
assert.deepEqual(Goku.battle(14), "You've been defeated", "Your warrior picked a fight he/she can't win.")
assert.deepEqual(Goku.level(), 9, "Your level should be high than our last viewing, regardless of our recent defeat")
assert.deepEqual(Goku.battle(12), "An intense fight", "Your enemy's in a whole other league, but he's still within your reach")
assert.deepEqual(Goku.battle(8), "Easy fight", "Going back to the small fry, huh? Provide the appropiate respone")
assert.deepEqual(Goku.rank(), "Novice", "You definately ain't no pushover anymore!")
assert.deepEqual(Goku.experience(), 1080, "Startin' to get some serious experience points?")
assert.deepEqual(Goku.battle(140), "Invalid level", "Something not right here...")
assert.deepEqual(Goku.training(["Mastered the Spirit Bomb", 1580, 10]), "Mastered the Spirit Bomb", "Remember that training you weren't strong enough to do before? What's different now?")
assert.deepEqual(Goku.level(), 26, "Finally got some decent skill in you")
assert.deepEqual(Goku.rank(), "Fighter", "You ain't in the beginner tiers anymore!")
assert.deepEqual(Goku.battle(30), "An intense fight", "The enemy's strong, but you can hold your own")
assert.deepEqual(Goku.rank(), "Fighter", "Still a fighter at heart")
assert.deepEqual(Goku.level(), 29, "Your ascention nears...")
assert.deepEqual(Goku.experience(), 2980, "...ever so closely")
assert.deepEqual(Goku.training(["Mastered the Shadow Clone Jutsu", 19, 6]), "Mastered the Shadow Clone Jutsu", "Another technique doesn't hurt")
assert.deepEqual(Goku.experience(), 2999, "...sooooo very close")
assert.deepEqual(Goku.level(), 29, "But no cigar")
assert.deepEqual(Goku.battle(32), "An intense fight", "Gotta get your gain right. What kinda fight helps with that?")
assert.deepEqual(Goku.rank(), "Warrior", "You ain't the greatest, but you still a...")
assert.deepEqual(Goku.experience(), 3179, "Keep rackin' the experience")
assert.deepEqual(Goku.battle(39), "An intense fight", "Keep the big fights poppin'")
assert.deepEqual(Goku.rank(), "Veteran", "I think you're onto something with this whole fighting thing")
assert.deepEqual(Goku.experience(), 4459, "Think you know your way around a fight now?")
assert.deepEqual(Goku.level(), 44, "...Well, do you")
assert.deepEqual(Goku.training(["Defeat Superman", 10000, 100]), "Not strong enough", "Don't jump the gun just yet!")
assert.deepEqual(Goku.training(["Mastered the Spirit Gun", 1340, 43]), "Mastered the Spirit Gun", "That's more up your alley")
assert.deepEqual(Goku.rank(), "Sage", "What becomes of veterans when they start to become old?")
assert.deepEqual(Goku.experience(), 5799, "Quite the fighter now, aren't ya?")
assert.deepEqual(Goku.level(), 57, "Keep rising!")
assert.deepEqual(Goku.battle(61), "An intense fight", "Nothin' a Sage can't handle!")
assert.deepEqual(Goku.rank(), "Elite", "You're very good at what you do")
assert.deepEqual(Goku.experience(), 6119, "Experience needs to match the title")
assert.deepEqual(Goku.training(["Mastered the Perfect Roundhouse Kick", 1781, 60]), "Mastered the Perfect Roundhouse Kick", "Patrick Swayze would be proud")
assert.deepEqual(Goku.rank(), "Conqueror", "You're becoming a legend, yo!")
assert.deepEqual(Goku.experience(), 7900, "Ten lifetimes' worth of experience right here!")
assert.deepEqual(Goku.battle(83), "An intense fight", "A conqueror's gonna conquer, amirite?")
assert.deepEqual(Goku.level(), 82, "This is a level to be feared")
assert.deepEqual(Goku.rank(), "Champion", "The world looks to you for your skills now")
assert.deepEqual(Goku.experience(), 8220, "You're geeting too good that this fighting stuff")
assert.deepEqual(Goku.training(["Defeat The Four Horsemen", 1100, 82]), "Defeat The Four Horsemen", "Can the judgement of the Gods stop you anymore?")
assert.deepEqual(Goku.battle(100), "You've been defeated", "Your power is godlike, but there is still greater")
assert.deepEqual(Goku.rank(), "Master", "Your competition is quickly strinking")
assert.deepEqual(Goku.level(), 93, "Your greatness is rarely matched")
assert.deepEqual(Goku.experience(), 9320, "Your power is rising...overflowing!")
assert.deepEqual(Goku.training(["Win the Intergalaxtic Tournament", 679, 91]), "Win the Intergalaxtic Tournament", "Can you prove to be the Master of Masters?")
assert.deepEqual(Goku.experience(), 9999, "Only one stands in your way now...")
assert.deepEqual(Goku.training(["Fight Superman to a draw", 11000, 99]), "Fight Superman to a draw", "If you can do this... I think you might be the one")
assert.deepEqual(Goku.level(), 100, "..Wait, can it be?")
assert.deepEqual(Goku.experience(), 10000, "..Is it really you?")
assert.deepEqual(Goku.rank(), "Greatest", "Yes, you truly are the greatest!!! ... as soon as you pass this test at least")
assert.deepEqual(Goku.training(["Defeat Superman", 10000, 100]), "Defeat Superman", "*creates shrine in your honor*")
assert.deepEqual(Goku.achievements(), ['Do ten push-ups', 'Survive one night at the Forest of Death', 'Mastered the Spirit Bomb', 'Mastered the Shadow Clone Jutsu', 'Mastered the Spirit Gun', 'Mastered the Perfect Roundhouse Kick', 'Defeat The Four Horsemen', 'Win the Intergalaxtic Tournament', 'Fight Superman to a draw', 'Defeat Superman' ], "What a career you have!")
