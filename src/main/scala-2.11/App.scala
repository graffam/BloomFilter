/**
  * Created by admin on 3/17/16.
  * An application designed to utilize a simple Bloom Filter
  * Using Murmur 3 with two seperate seed numbers
  */

import java.io.{FileNotFoundException, IOException}

object App {
  def main(args: Array[String]): Unit ={
    if(args.length != 3) println("usage: dictionary word sizeOfDictionaryMap")

    /**
      * Read in dictionary text, create iterator, load into bloom filter line by line
      */

    else{
      try {
        val filter = new BloomFilter(args(0), args(2).toInt)
        if (filter.find(args(1))) println("Found word")
        else println("Did not find word")
      } catch {
        case e: FileNotFoundException => println("Couldn't find that file.")
        case e: IOException => println("Got an IOException!")
        case e: NumberFormatException => println("size must be a number")
      }
    }
  }
}


