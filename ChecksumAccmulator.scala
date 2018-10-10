import scala.collection.mutable

class ChecksumAccmulator {
  private var sum = 0

  def add(b: Byte): Unit = sum += b
  def checkSum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccmulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if (cache.contains(s)) 
      cache(s) 
    else {
      val acc =  new ChecksumAccmulator
      for (c <- s) (acc.add(c.toByte))
      val cs = acc.checkSum()
      cache += (s -> cs)
      cs
    }
  }
}

object Main extends App {
  println(ChecksumAccmulator.calculate("hoge"))
}