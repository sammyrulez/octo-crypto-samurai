name := "octo-crypto-samurai"

version := "1.0"

scalaVersion := "2.10.4"

jetty(port = 9090)

seq(lessSettings:_*)

(LessKeys.filter in (Compile, LessKeys.less)) := "bootstrap.less"

(resourceManaged in (Compile, LessKeys.less)) <<= (target in Compile)(_ / "webapp" / "static" / "css")

resolvers += "SpringSource Milestone Repository" at "http://repo.springsource.org/milestone"

libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % "2.3.0",
        "org.scalatra" %% "scalatra-scalate" % "2.3.0",
        "org.scalatra" %% "scalatra-auth" % "2.3.0",
        "org.scalatra" %% "scalatra-specs2" % "2.3.0" % "test",
        "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % "9.2.1.v20140609" % "container",
        "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
        "org.springframework.scala" % "spring-scala" % "1.0.0.M2",
        "org.scalatra" %% "scalatra-json" % "2.3.0",
        "org.json4s"   %% "json4s-jackson" % "3.2.9",
        "com.typesafe.akka" % "akka-actor_2.10" % "2.3.6",
        "com.typesafe.akka" % "akka-testkit_2.10" % "2.3.6" % "test",
        "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test",
        "junit" % "junit" % "4.11" % "test",
        "org.mockito" % "mockito-all" % "1.10.8" % "test",
        "org.seleniumhq.selenium" % "selenium-java" % "2.44.0" % "test"
)

    
