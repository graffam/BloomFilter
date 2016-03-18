import scala.io.Source
import scala.util.hashing.MurmurHash3

/**
  * Created by admin on 3/17/16.
  */
class BloomFilter(file: String, size: Int) {

  /** Creates vector of size containing false, uses hash functions to set corresponding index to true */
  private val lineIterator = Source.fromFile(file, "UTF-8").getLines

  /** Commented out line, not sure how to assign size of dictionary vector, for now
    * just having user input size and trying stuff out. Also didn't want to read file twice... */

  //  private val size = (Source.fromFile(file, "UTF-8").size) * 8

  val dictionary: Vector[Boolean] = insert(lineIterator,(0 until size).foldLeft(Vector[Boolean]()) { (total, i) =>  total ++ Vector(false)})

  def insert(lines: Iterator[String], list: Vector[Boolean]): Vector[Boolean] = {
    var currentVector = list
    for(line <- lineIterator){
      currentVector = currentVector.updated(MurmurHash3.stringHash(line.toLowerCase,2).abs % size, true)
      currentVector = currentVector.updated(MurmurHash3.stringHash(line.toLowerCase,10).abs % size, true)
    }
    currentVector
  }


  /** Uses same hash functions on string, goes to index and checks value */

  def find(word: String): Boolean = {
    if(dictionary(MurmurHash3.stringHash(word.toLowerCase,2).abs % size) || dictionary(MurmurHash3.stringHash(word.toLowerCase,10).abs % size)) true
    else false
  }
}
