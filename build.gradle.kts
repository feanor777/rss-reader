plugins {
    java
    groovy
    kotlin("jvm") version "1.4.31"
    id("org.springframework.boot") version "2.5.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.uzabase.rssreader"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:3.0.7")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.rometools:rome:1.15.0")
    implementation("commons-validator:commons-validator:1.7")
    implementation("org.apache.commons:commons-collections4:4.0")
    implementation("org.apache.commons:commons-lang3:3.0")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.spockframework:spock-core:2.0-M5-groovy-3.0")
    testImplementation("org.spockframework:spock-spring:2.0-M5-groovy-3.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType(Test::class) {
    useJUnitPlatform()
}
