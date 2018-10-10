case object Nil extends List[Notiing] {
  override def isEmpty = true
  def head: Notiing = throw new NoSuchElementExeption("head of empty list")
  def tail: Notiing = throw new NoSuchElementExeption("tail of empty list")
}

final case class ::[T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty = false
}

class List {
  def ::[U :> T](x: U): List[U] = new scala.::(x, this)
  def :::[U :> T](prefix: List[U]): List[U] = 
    if(prefix.isEmpty) this
    else prefix.head :: prefix.tail ::: this
}