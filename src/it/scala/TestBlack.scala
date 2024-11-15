package it.scala

trait TestBlack {
  val verbose : Boolean
  def report(): Unit
  def test(verbose: Boolean, filename: String, message: String, expectation: Option[Int]): Unit
  def test(): Unit = {
    test(verbose, "src/it/scala/test/black0.pcf", "count", Option(0))
    test(verbose, "src/it/scala/test/black1.pcf", "factorial", Option(6))
    test(verbose, "src/it/scala/test/black2.pcf", "loop", None)
    report()
  }
}
