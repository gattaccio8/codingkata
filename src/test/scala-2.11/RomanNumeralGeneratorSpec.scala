import org.scalatest.FunSuite
import RomanNumeralGenerator._


class RomanNumeralGeneratorSpec extends FunSuite {

  test("returns a roman numerical representation of a number from 1 to 4") {
    val numbers = 1 to 4 toList

    assert(numbers.map(generateOneToTen) == List("I", "II", "III", "IV"))
  }

  test("returns a roman numerical representation of a number from 1 to 10") {
    val numbers = 1 to 10 toList

    assert(numbers.map(generateOneToTen) == List("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"))
  }

  test("returns a roman numerical representation of a number from 9 to 20") {
    val numbers = 9 to 20 toList

    assert(numbers.map(generate) == List("IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"))
  }


//  test("returns a roman numerical representation of a number from 4 to 8") {
//    val oneToEight = 4 to 6 toList
//
//    assert(oneToEight.map(generate) == List("IV", "V", "VI", "VII", "VIII"))
//  }
}

