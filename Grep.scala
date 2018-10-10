object Grep {
  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines.toList

  def grep(here: String, pattern: String): Array[String] = {
    val filesHere = (new java.io.File(here)).listFiles
    val files = for{
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      if line.trim.contains(pattern)
    } yield (file + ": " + line.trim)
    files
  }
}

object Main {
  def main(args: Array[String]): Unit = Grep.grep(args(0), args(1)).foreach(println)
}
