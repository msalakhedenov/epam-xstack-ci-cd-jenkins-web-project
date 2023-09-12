plugins {
  id("java")
  id("war")
  id("org.springframework.boot") version "3.1.3"
  id("io.spring.dependency-management") version "1.1.3"
  id("org.sonarqube") version "3.5.0.2730"
  id("jacoco")
}

group = "com.sm"
version = "1.0-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

sonar {
  properties {
    property("sonar.projectKey", "EPAM-XStack-CI-CD-with-Jenkins")
    property("sonar.coverage.jacoco.xmlReportPaths", "build/jacoco/*.exec")
  }
}

jacoco {
  toolVersion = "0.8.10"
}

repositories {
  mavenCentral()
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  compileOnly("org.springframework.boot:spring-boot-starter-tomcat")
  runtimeOnly("org.postgresql:postgresql")
  testRuntimeOnly("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  compileOnly("org.projectlombok:lombok")
  annotationProcessor("org.projectlombok:lombok")
}

tasks.test {
  useJUnitPlatform()
}