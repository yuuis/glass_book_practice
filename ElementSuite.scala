// use ScalaTest
// command for compile: scalac -cp scalatest.jar CLASSNAME.scala
// command for execute: scala -cp scalatest.jar org.scalatest.run CLASSNAME

import org.scalatest.FunSuite
import org.scalatest.FlatSpec
import Element.elm

class ElementSuite extends FunSuite {
  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}

class ElementSpec extends FlatSpec with Matchers {
  "a uniform element" should "have a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be (2)
  }
  it should "havee a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be (3)
  }
}

object Main extends App {
  (new ElementSuite).execute()
  (new ElementSpec).execute()
}
