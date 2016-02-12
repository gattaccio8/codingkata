trait RomanNumeralGenerator {
  def generate(number: Int): String
}

case object Symbols {
  val table: List[(String, Int)] = List(("I", 1), ("IV", 4), ("V", 5), ("IX", 9), ("X", 10), ("XL", 40), ("L", 50), ("XC", 90),
    ("C", 100), ("CD", 400), ("D", 500), ("CM", 900), ("M", 1000))
}

object RomanNumeralGenerator extends RomanNumeralGenerator {
  import Symbols._


  override def generate(number: Int) = buildResult(number, "")

  def buildResult(decimal: Int, result: String): String = findHighestDecimal(decimal) match {
    case (s: String, x: Int) if(x == decimal) => result + s
    case (s: String, x: Int) if(x < decimal) => result + findHighestDecimal(decimal)._1 + buildResult(decimal - x, result)
    case _ => result
  }

  def findHighestDecimal(decimal: Int): (String, Int) = table.takeWhile(t => t._2 == decimal || t._2 < decimal).last
}
