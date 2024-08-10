import Dependencies._
import com.typesafe.sbt.packager.docker._

ThisBuild / scalaVersion := "2.13.14"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "io.github"
ThisBuild / organizationName := "agaro"

releaseProcess := releaseProcess.value.filterNot(
  _ == ReleaseTransformations.publishArtifacts
)

lazy val root = (project in file("."))
  .enablePlugins(DockerPlugin, JavaAppPackaging, UniversalPlugin)
  .settings(
    name := "full-service",
    libraryDependencies ++= Seq(
      munit % Test,
      http4s.server,
      http4s.dsl,
      logbackClassic
    ),
    assembly / mainClass := Some("example.Main"),
    packageBin := assembly.value,
    dockerExposedPorts ++= Seq(8080),
    dockerBaseImage := "openjdk:17",
    Universal / mappings ++= Seq(
      (baseDirectory.value / "agent" / "sample-agent.jar") -> "sample-agent.jar"
    ),
    Universal / javaOptions := Seq(
      "-J-javaagent:/opt/docker/sample-agent.jar"
    ),
    dockerCommands ++= Seq(
      Cmd("COPY", "opt/docker/sample-agent.jar sample-agent.jar")
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
