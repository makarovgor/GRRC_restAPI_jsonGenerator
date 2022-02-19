

name := "json-service"

version := "0.1"

scalaVersion := "2.13.6"

val twitterVersion = "22.1.0"

val scalatest = "org.scalatest" %% "scalatest" % "3.2.9"

addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % "0.14.1")

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.2.9",
  scalatest % "test"
)

libraryDependencies ++= Seq(
  "com.twitter" %% "twitter-server-logback-classic" % twitterVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.10",
  "com.twitter" %% "finagle-http" % twitterVersion
)

libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % "1.43.2",
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)
