import com.sammyrulez.ocs.api._
import org.scalatra._
import javax.servlet.ServletContext


class ScalatraBootstrap extends LifeCycle {

    implicit val swagger = new OperationsSwagger    

    override def init(context: ServletContext) {
        context.mount(new Operations, "/operations/*","operations")
        //context.mount(new SessionsController, "/sessions/*")
        context.mount (new ResourcesApp, "/api-docs")
    }
}
