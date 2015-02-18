package soccerstand.implicits

import java.util.Date
import java.util.concurrent.TimeUnit

import soccerstand.parser.token.SoccerstandTokens._

object Implicits {
  implicit class SoccerstandData(a: String) {
    val endChar = '¬'
    def readIntAt(i: Int) = a.substring(i).takeTillEndChar.toInt
    def readDateAt(i: Int) = new Date(a.substring(i).takeTillEndChar.toLong * 1000)
    def readDataAfterIdx(i: Int) = a.substring(i).takeTillEndChar
    def takeTillEndChar = a.takeWhile(_ != endChar)
    def onlyUsefulData = a.replaceAll(s"$endOfUsefulData1(.*)", "").replaceAll(s"$endOfUsefulData2(.*)", "")
  }
  implicit class SplittedString(a: String) {
    def splitOmitFirst(regex: String) = a.split(regex).tail
    def splitOmitFirst(char: Char) = a.split(char).tail
  }
  implicit class RichDate(date: Date) {
    def diffInMinutes(otherDate: Date): Int = {
      val diffInMillies = Math.abs(otherDate.getTime - date.getTime)
      TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS).toInt
    }
  }
  implicit class RichString(s: String) {
    def withoutWhitespaces = s.replaceAll(" ", "")
    def whitespacesToDashes = s.replaceAll(" ", "-").replaceAll("---", "-").replaceAll("'", "-")
    def withoutClausura = s.replace(" - clausura", "")
  }
}
