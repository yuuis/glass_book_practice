 # list operation
  * `::`(cons): Extended list at the beginning
  * `head`: a element of head
  * `last`: a element of last
  * `init`: elements other than last element, can use `head` or `tail` continue
  * `tail`: elements other than head element, can use `head` or `tail` continue
  * `take(n: Int)`: return n elements from the head
  * `drop(n: Int)`: return elements other than n elements from the head

```scala

  scala> val mainList = List(1, 2, 3)
  mainList: List[Int] = List(1, 2, 3)

// add element to head
  scala> 0 :: mainList
  res: List[Int] = List(0, 1, 2, 3)

  scala> List(-1, 0) :: mainList
  res: List[Any] = List(List(-1, 0), 1, 2, 3)

  scala> 0 +: mainList
  res: List[Int] = List(0, 1, 2, 3)


  scala> List(-1, 0) ++ mainList
  res: List[Int] = List(-1, 0, 1, 2, 3)

// add element to tail
  scala> mainList :+ 4
  res: List[Int] = List(1, 2, 3, 4)

  scala> mainList :: List(4, 5)
  res: List[Any] = List(List(1, 2, 3), 4, 5)

// link lists
  scala> mainList ::: List(4, 5)
  res: List[Int] = List(1, 2, 3, 4, 5)

  scala> mainList ++ List(4, 5)
  res: List[Int] = List(1, 2, 3, 4, 5)

  scala> mainList ++: List(4, 5)
  res: List[Int] = List(1, 2, 3, 4, 5)

```
