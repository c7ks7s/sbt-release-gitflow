organization := "org.lancegatlin"

name := "sbt-release-gitflow"

sbtPlugin := true
scalacOptions += "-deprecation"

publishTo := {
  if (isSnapshot.value)
    Some("Artifactory Realm" at "https://c7ks7s.jfrog.io/c7ks7s/legion-snapshot")
  else
    Some("Artifactory Realm" at "https://c7ks7s.jfrog.io/c7ks7s/legion-release")
}

val hostname = sys.env.get("REPOSITORY_URL").get
val username = sys.env.get("REPOSITORY_USERNAME").get
val password = sys.env.get("REPOSITORY_PASSWORD").get

credentials += Credentials("Artifactory Realm", hostname, username, password)