import sbt._
import Keys._

object CodingKataBuild extends Build {
  import Dependency._
  import Resolvers._
  import BuildSettings._
  import scala.collection._

  lazy val root = Project(id = "codingkata", base = file("."), settings = standardBuildSettings ++ Seq(
    resolvers := Seq(jettyRepo, resolver, Classpaths.typesafeReleases),
    libraryDependencies ++= scalaTest ++ sl4
  ))
}

object BuildSettings {

  val dist = taskKey[Unit]("dist")

  val standardBuildSettings: Seq[Def.Setting[_]] = Defaults.coreDefaultSettings ++ Seq[Setting[_]](
      organization := "codingkata",
      version := "1.0",
      scalaVersion := "2.11.7")
}

object Resolvers {
  val jettyRepo = "jetty repo" at "http://siasia.github.com/maven2"
  val resolver = "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
}

object Dependency {
  private val scalaTestVersion = "2.2.4"
  private val slfLogVersion = "1.7.10"

  val sl4 =  Seq(
    "org.slf4j" % "slf4j-api" % slfLogVersion,
    "org.slf4j" % "slf4j-simple" % slfLogVersion
  )

  val scalaTest = Seq(
    "org.scalatest" % "scalatest_2.11" % scalaTestVersion  % "test"
  )
}
