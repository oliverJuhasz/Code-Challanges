import unittest
import main

secret = "whatisup"
triplets = [
  ['t','u','p'],
  ['w','h','i'],
  ['t','s','u'],
  ['a','t','s'],
  ['h','a','p'],
  ['t','i','s'],
  ['w','h','s']
]

class SampleTests(unittest.TestCase):

    def test1(self):
        self.assertEquals(main.recoverSecret(triplets), secret)

if __name__ == '__main__':
    unittest.main(verbosity=2)