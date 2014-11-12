name := "octo-crypto-samurai"

version := "1.0"

scalaVersion := "2.10.4"

jetty()

seq(lessSettings:_*)

(LessKeys.filter in (Compile, LessKeys.less)) := "bootstrap.less"

(resourceManaged in (Compile, LessKeys.less)) <<= (target in Compile)(_ / "webapp" / "css")

seq(jasmineSettings : _*)

appJsDir <+= sourceDirectory { src => src / "main" / "webapp" / "static" / "js" }

appJsLibDir <+= sourceDirectory { src => src / "main" / "webapp" / "static" / "js" / "lib" }

jasmineTestDir <+= sourceDirectory { src => src / "test" / "webapp" / "static" / "js" }

jasmineConfFile <+= sourceDirectory { src => src / "test" / "webapp" / "static" / "js" / "test.dependencies.js" }

jasmineEdition := 2

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5" % "provided"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.10" % "2.3.6"

libraryDependencies += "io.spray" % "spray-servlet_2.10" % "1.3.2"

libraryDependencies += "org.apache.maven" % "maven-model" % "3.0.4"

libraryDependencies += "org.apache.maven" % "maven-core" % "3.0.4"

libraryDependencies += "org.codehaus.plexus" % "plexus-utils" % "2.0.6"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test"

libraryDependencies += "com.typesafe.akka" % "akka-testkit_2.10" % "2.3.6" % "test"

libraryDependencies += "org.mockito" % "mockito-all" % "1.10.8" % "test"
    
