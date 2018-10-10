object Factorial {
  def factorial(x: Int): Int = {
    if(x > 0) x * factorial(x - 1) else 1
  }
}

object Main {
  def main(args: Array[String]): Unit = println(Factorial.factorial(args(0).toInt))
}