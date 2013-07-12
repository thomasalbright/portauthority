import java.net._
import java.io._
import scala.io._

class PortAuthority(app: (String) => String) {
  def run {
    val server = new ServerSocket(9999)
    while (true) {
      val s = server.accept()
      val in = new BufferedSource(s.getInputStream).getLines
      val out = new PrintStream(s.getOutputStream)

      out.println(app(in.next()))
      out.flush()
      s.close()
	}
  }
}
