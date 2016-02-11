trait RomanNumeralGenerator {
  def generate(number: Int): String
}

case object Symbols {
  val symbols = List("I", "V", "X", "L", "C", "D", "M")
  val sym = List(("I", 1), ("V", 5), ("X", 10), ("L", 50), ("C", 100), ("D", 500), ("M", 1000))
  def canBeRepeated(symbol: String) = !Set("V", "L", "D").contains(symbol)
}

//When a symbol appears before a larger symbol it is subtracted
//When a symbol appears after a larger symbol it is added
//Don't use the same symbol more than three times in a row
object RomanNumeralGenerator extends RomanNumeralGenerator {
  import Symbols._

  override def generate(n: Int) = n match {
    case _: Int if (n == nextNumber(n)) => nextSymbol(n)
    case _: Int if (n == nextNumber(n) - 1) =>
      if(canBeRepeated(previousSymbol(n))) s"${previousSymbol(n)}${nextSymbol(n)}" else s"${previousRepeatable(n)._1}${nextSymbol(n)}"
    case _: Int if (withinRange(n) && canBeRepeated(previousSymbol(n))) => addSymbol(n, previousSymbol(n))
    case _: Int if (withinRange(n) && !canBeRepeated(previousSymbol(n))) =>
      previousSymbol(n) + addSymbol(n - previousTuple(n)._2, previousSymbol(previousTuple(n)._2 - 1))
    case _ => "Unknown"
  }

  def addSymbol(n: Int, symbol: String, res: String = ""): String =
    if (n > 0) res + symbol + addSymbol(n - 1, symbol, res) else res

  def doesOccurMoreThanThreeTimes(s: String, sym: String) = s.count(_.toString == sym) > 3

  def doesOccurThreeTimes(s: String, sym: String) = s.count(c => c.toString.equals(sym)) == 3

  private def nextTuple(n: Int): (String, Int) = sym.dropWhile(e => e._2 < n).head
  private def nextNumber(n: Int): Int = nextTuple(n)._2
  private def nextSymbol(n: Int): String = nextTuple(n)._1
  private def previousTuple(n: Int): (String, Int) = sym.takeWhile(_._2 < n).last
  private def previousSymbol(n: Int): String = previousTuple(n)._1
  private def withinRange(n: Int): Boolean = n > previousTuple(n)._2 && n < nextNumber(n)
  private def previousRepeatable(n: Int) = sym.filter(s => canBeRepeated(s._1)).takeWhile(_._2 < n).last

}
