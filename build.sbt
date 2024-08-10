import Dependencies._

ThisBuild / scalaVersion := "2.13.14"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "io.github"
ThisBuild / organizationName := "agaro"

releaseProcess := releaseProcess.value.filterNot(_ == ReleaseTransformations.publishArtifacts)

lazy val root = (project in file("."))
  .settings(
    name := "full-service",
    libraryDependencies ++= Seq(
      munit % Test,
      http4s.server,
      http4s.dsl
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
