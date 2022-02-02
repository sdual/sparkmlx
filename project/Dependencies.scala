import sbt._

object Dependencies {

  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.10"
  val sparkCore = "org.apache.spark" %% "spark-core" % "3.1.1"
  val sparkMLLib = "org.apache.spark" %% "spark-mllib" % "3.1.1"
  val sparkSQL = "org.apache.spark" %% "spark-sql" % "3.1.1"


  val sparkMLXDependencies = Seq(
    sparkCore,
    sparkMLLib,
    sparkSQL,
    scalaTest % Test
  )

}
