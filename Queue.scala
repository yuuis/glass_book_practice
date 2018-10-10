import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = buf += x
}

// traits
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(2 * x)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = if(x >= 0) super.put(x)
}


object Main extends App {
  // the trait is applied from the right side
  // val queue = new BasicIntQueue
  // val queue = new BasicIntQueue extends Doubling
  val queue = new BasicIntQueue with Incrementing with Filtering 
  queue.put(-1)
  queue.put(10)
  queue.put(20)
  println(queue.get())
  println(queue.get())
}
