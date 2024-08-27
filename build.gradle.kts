plugins {
	kotlin("jvm") version "2.0.20"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("kapt") version "2.0.20"
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.jpa") version "1.9.25"
}

group = "com.kotlinsping"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}
val loggerVersion = "3.0.5"
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	//logger
	implementation ("io.github.microutils:kotlin-logging-jvm:$loggerVersion") //kotlin logger
	runtimeOnly("com.h2database:h2")
//	runtimeOnly("org.postgresql:postgresql")

	//mappers
	implementation("org.mapstruct:mapstruct:1.5.2.Final")
	kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")

	//testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("io.mockk:mockk:1.10.4")
	testImplementation("com.ninja-squad:springmockk:3.0.1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}


tasks.withType<Test> {
	useJUnitPlatform()
}

//i18n
tasks.processResources {
	from("src/main/resources/i18n") {
		include("**/*.properties")
	}
}

sourceSets {
	test {
       java {
		   setSrcDirs(listOf("src/test/integration","src/test/unit"))
	   }
	}

}

