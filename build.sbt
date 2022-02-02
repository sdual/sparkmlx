import Dependencies._

lazy val commonSettings = Seq(
  organization := "com.github.sdual",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.8"
)

lazy val root = (project in file("."))
  .aggregate(
    sparkMLX
  )

lazy val sparkMLX = (project in file("sparkmlx"))
  .settings(
    commonSettings,
    name := "sparkmlx",
    libraryDependencies ++= sparkMLXDependencies
  )
