import sbt._
import sbt.Keys._

object SbtSintyokuDoudesukaBuild extends Build {

  lazy val sbtshintyokuDoudesuka = Project(
    id = "sbt-shintyoku-doudesuka",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "sbt-shintyoku-doudesuka",
      organization := "com.github.tototoshi",
      version := "0.1.0-SNAPSHOT",
      sbtPlugin := true
    ) ++ publishingSettings
  )

  val publishingSettings = Seq(
    publishMavenStyle := true,
    publishTo <<= version { (v: String) => _publishTo(v) },
    publishArtifact in Test := false,
    pomExtra := _pomExtra
  )

  def _publishTo(v: String) = {
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }

  val _pomExtra =
    <url>http://github.com/tototoshi/sbt-shintyoku-doudesuka</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:tototoshi/scala-shintyoku-doudesuka</url>
        <connection>scm:git:git@github.com:tototoshi/sbt-shintyoku-doudesuka.git</connection>
      </scm>
      <developers>
        <developer>
          <id>tototoshi</id>
          <name>Toshiyuki Takahashi</name>
          <url>http://tototoshi.github.com</url>
        </developer>
      </developers>

}
