package it.scala

object CompileTestGreen extends App with Test with TestGreen {
  val verbose = true
  testGreen()
}
object CompileTestBlue extends App with Test with TestBlue {
  val verbose = true
  testBlue()
}
object CompileTestRed extends App with Test with TestRed {
  val verbose = true
  testRed()
}
object CompileTestBlack extends App with Test with TestBlack {
  val verbose = true
  testBlack()
}
// same than above for all tests
object CompileAllTests extends App with Test with TestGreen with TestBlue with TestRed with TestBlack {
  val verbose = true
  testGreen()
  testBlue()
  testRed()
  testBlack()
}