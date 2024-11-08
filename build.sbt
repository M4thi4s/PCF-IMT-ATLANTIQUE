ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "PCF-IMT-ATLANTIQUE",
      libraryDependencies ++= Seq(
      "org.antlr" % "antlr4-runtime" % "4.13.2"
    ),
    Compile / mainClass := Some("main.scala.Main"),
    logLevel := Level.Error
  )
