object Fib {
  def fib(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case n => fib(n - 2) + fib(n - 1)
  }

  def fib2(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, a: Int, b: Int): Int = {
      if(n == 0) a else loop(n - 1, b, a + b)
    }
    loop(n, 0, 1)
  }
}

object Main {
  def main(args: Array[String]): Unit = println(Fib.fib2(args(0).toInt))
}