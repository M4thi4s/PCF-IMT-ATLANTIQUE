package it.scala

trait TestGreen {
  val verbose : Boolean
  def report(): Unit
  def test(verbose: Boolean, filename: String, message: String, expectation: Option[Int]): Unit
  def testGreen(): Unit = {
    test(verbose, "src/it/scala/test/green0.pcf", "number", Option(0))
    test(verbose, "src/it/scala/test/green1.pcf", "number", Option(42))
    test(verbose, "src/it/scala/test/green2.pcf", "arithmetic (-)", Option(-1))
    test(verbose, "src/it/scala/test/green3.pcf", "simple ifz", Option(1))
    test(verbose, "src/it/scala/test/green4.pcf", "simple ifz", Option(2))
    test(verbose, "src/it/scala/test/green5.pcf", "arithmetic (-)", Option(-4))
    test(verbose, "src/it/scala/test/green6.pcf", "arithmetic (+, *)", Option(7))
    test(verbose, "src/it/scala/test/green7.pcf", "simple parentheses", Option(1))
    test(verbose, "src/it/scala/test/green8.pcf", "parentheses & arithmetic (+, *)", Option(9))
    test(verbose, "src/it/scala/test/green9.pcf", "arithmetic (/)", Option(2))
    report()
  }
}
