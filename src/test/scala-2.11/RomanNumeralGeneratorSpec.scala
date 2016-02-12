import org.scalatest.FunSuite
import RomanNumeralGenerator._


class RomanNumeralGeneratorSpec extends FunSuite {

  test("find the highest decimal value that is less than or equal to the decimal number") {
    assert(findHighestDecimal(9) == ("IX", 9))
    assert(findHighestDecimal(11) == ("X", 10))
  }

  test("returns a roman numerical representation of a number from 1 to 10") {
    val numbers = 1 to 10 toList

    assert(numbers.map(generate) == List("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"))
  }

  test("returns a roman numerical representation of random numbers") {
    val numbers = List(36, 1996, 3999, 4000)

    assert(numbers.map(generate) == List("XXXVI", "MCMXCVI", "MMMCMXCIX", "Unsupported"))
  }
}

