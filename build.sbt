import Dependencies._

lazy val commonSettings = Seq(
  organization := "com.github.sdual",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.8"
)

lazy val sparkmlx = (project in file("."))
  .aggregate(
    core
  )

lazy val core = (project in file("core"))
  .settings(
    commonSettings,
    name := "core",
    libraryDependencies ++= sparkMLXDependencies
  )
