plugins {
  application
  id("org.jetbrains.kotlin.jvm") version "1.4.32"
  id("org.openjfx.javafxplugin") version "0.0.9"
  id("com.github.johnrengelman.shadow") version "6.1.0"
}

javafx {
  modules("javafx.controls", "javafx.fxml")
}

repositories {
  jcenter()
}

dependencies {
  // Align versions of all Kotlin components
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("no.tornado:tornadofx:1.7.20")
  implementation("no.tornado:tornadofx-controlsfx:0.1.1")

  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  testImplementation("org.jetbrains.kotlin:kotlin-test")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.2")
  testImplementation("org.testfx:testfx-core:4.0.16-alpha")
}

application {
  // Define the main class for the application.
  mainClassName = "com.example.demo.app.MyAppKt"
}

tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
