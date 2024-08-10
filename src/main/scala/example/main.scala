package example

import cats.effect.IOApp
import cats.effect.IO
import cats.effect.ExitCode
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import com.comcast.ip4s._

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(Routes.helloWorldService.orNotFound)
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)
}
