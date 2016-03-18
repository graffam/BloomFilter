Basic Bloom filter implemented using Murmur3 Hash function with two different seed values

To Run, sbt "run-main App dictionary.txt word size"
First argument is the path to your dictionary file, each word should be separated be newlines. Second argument is the
word you are looking for within the file. Third argument is the size of the dictionary bloom filter, the larger it is the
less false positives.
