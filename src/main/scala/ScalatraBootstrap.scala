import com.sammyrulez.ocs.api._
import org.scalatra._
import javax.servlet.ServletContext


class ScalatraBootstrap extends LifeCycle {
    override def init(context: ServletContext) {
        context.mount(new Operations, "/operations/*")
        //context.mount(new SessionsController, "/sessions/*")
    }
}
