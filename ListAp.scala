object ListAp {
  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match {
      case List() => ys
      case xs1 :: list => xs1 :: append(list, ys)
    }
}

object Main extends App {
  println(ListAp.append(List("hoge"), List("fuga", "piyo")))
}