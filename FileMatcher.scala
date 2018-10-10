object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  // def filesEnding(query: String) =
  //   for(file <- filesHere; if file.getName.endsWith(query)) yield file

  // def filesContaining(query: String) =
  //   for(file <- filesHere; if file.getName.contains(query)) yield file

  // def filesRegex(query: String) =
  //   for(file <- filesHere; if file.getName.matches(query)) yield file

  // def FileMatching(query: String, method: String) =
  //   for(file <- filesHere; if file.getName.send(method, query)) yield file

  def filesMatching(matcher: String => Boolean) =
    for(file <- filesHere; if matcher(file.getName)) yield file

  def filesEnding(query: String) = filesMatching(_.endsWith(query))
  def filesContaining(query: String) = filesMatching(_.contains(query))
  def filesRegex(query: String) = filesMatching(_.matches(query))
}

object Main {
  def main(args: Array[String]) = {
    val files = FileMatcher.filesEnding(args(0))
    files.foreach(println)
  }
}
