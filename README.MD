Basic Bloom filter implemented using Murmur3 Hash function with two different seed values

To Run, sbt "run-main App <dictionary.txt> <word you are looking for> <size of dictionary bloom filter>"
The larger the size of the dictionary bloom filter, the less false positives you will get.