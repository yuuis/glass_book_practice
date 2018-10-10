class Rational(val n: Int, val d: Int) extends Ordered[Rational] {
  require(d != 0)
  private val gcd: Int = gcd(n.abs, d.abs)
  val numer = n / gcd
  val denom = d / gcd

  override def toString = n + "/" + d

  def this(n: Int) = this(n, 1) // support constructor

  def compare(that: Rational) = (this.numer + that.denom) - (that.numer * this.denom)

  def + (that: Rational): Rational =
    correct(new Rational(numer * that.denom + that.numer * denom, denom * that.denom))

  def + (i: Int): Rational =
    correct(new Rational(numer + i * denom, denom))

  def - (that: Rational): Rational =
    correct(new Rational(numer * that.denom - that.numer * denom, denom * that.denom))

  def - (i: Int): Rational =
    correct(new Rational(numer - i * denom, denom))

  def * (that: Rational): Rational =
    correct(new Rational(numer * that.numer, denom * that.denom))

  def * (i: Int): Rational =
    correct(new Rational(numer * i, denom))

  def / (that: Rational): Rational =
    correct(new Rational(numer * that.denom, denom * that.numer))

  def / (i: Int): Rational =
    correct(new Rational(numer, denom * i))

  private def gcd(n: Int, d: Int): Int = if(d == 0) n else gcd(d, n % d)

  private def correct(that: Rational): Rational = {
    val g: Int = gcd(that.n.abs, that.d.abs)
    if(g == 1) that else new Rational(that.n / g,  that.d / g)
  }
}


object Main extends App {
  implicit def intToRational(x: Int) = new  Rational(x)

  println(new Rational(n = 5))

  val rational_1 = new Rational(n = 1, d = 2)
  val rational_2 = new Rational(n = 4, d = 6)
  val rational_3 = new Rational(n = 2, d = 3)

  println("\n")
  println(rational_1 + " + " + rational_2 + " = " + (rational_1 + rational_2))
  println(rational_1 + " + " + 2 + " = " + (rational_1 + 2))
  println("\n")
  println(rational_1 + " - " + rational_2 + " = " + (rational_1 - rational_2))
  println(rational_1 + " - " + 2 + " = " + (rational_1 - 2))
  println("\n")
  println(rational_1 + " * " + rational_2 + " = " + (rational_1 * rational_2))
  println(rational_1 + " * " + 2 + " = " + (rational_1 * 2))
  println(2 + " * " + rational_1 + " = " + (2 * rational_1))
  println("\n")
  println(rational_1 + " / " + rational_2 + " = " + (rational_1 / rational_2))
  println(rational_1 + " / " + 2 + " = " + (rational_1 / 2))
  println("\n")
  println(rational_1 + " * " + rational_2 + " + " + rational_3 + " = " + (rational_1 * rational_2 + rational_3))
  println("\n")
  println(rational_1 + " > " + rational_2 + " = " + (rational_1 > rational_2))
  println(rational_1 + " =< " + rational_2 + " = " + (rational_1 <= rational_2))
}
