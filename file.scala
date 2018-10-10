import scala.io.Source

if(args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines.toList
  val longestLine = lines.reduceLeft (
    (a, b) => if(a.length > b.length) a else b
  )
  val maxWidth = widthOfLength(longestLine)
  println("max width: " + maxWidth)
  for(line <- lines) {
    val numSpace = maxWidth - widthOfLength(line)
    val padding = if(numSpace == 0) "" else "0"
    // var padding = if(numSpace == 0) "" else (0 to numSpace).foreach(" ")
    println(padding + line.length + " | " + line)
  }
} else {
  Console.err.println("please enter filename")
}

def widthOfLength(s: String) = s.length.toString.length
