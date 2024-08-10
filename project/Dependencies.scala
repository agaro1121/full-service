import sbt._

object Dependencies {
  lazy val munit = "org.scalameta" %% "munit" % "0.7.29"

  object http4s {
    val http4sVersion = "0.23.27"
    val client = "org.http4s" %% "http4s-ember-client" % http4sVersion
    val server = "org.http4s" %% "http4s-ember-server" % http4sVersion
    val dsl = "org.http4s" %% "http4s-dsl" % http4sVersion
  }
}

