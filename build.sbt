name := "soccer-rest"

version := "0.1"

scalaVersion := "2.11.5"

libraryDependencies ++= {
  val akkaStreamV = "1.0-M3"
  Seq(
    "com.typesafe.akka" %% "akka-stream-experimental"           % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental"        % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental"             % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental"  % akkaStreamV,
    "org.scala-lang.modules" %% "scala-xml" % "1.0.3",
    "org.mongodb" %% "casbah" % "2.8.0",
    "com.novus" %% "salat" % "1.9.9",
    "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    "com.typesafe.akka" %% "akka-http-testkit-experimental"     % akkaStreamV,
    "org.mockito" % "mockito-core" % "1.10.19"
  )
}

resolvers += "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "releases"  at "https://oss.sonatype.org/content/groups/scala-tools"