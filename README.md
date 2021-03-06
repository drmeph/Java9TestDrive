# Java9TestDrive

This project is meant to play around with few of Java 9 new features :
* Modules
* Multi-release Jar
* JShell
* Collection Factory Methods
* Interfaces Private Method

## Getting Started
The following instructions will get you a copy of the project up and running on your local machine for testing purposes. 

### Prerequisites
What do things you need to install the software and how to install them

1) Install [Java SE 10](https://www.oracle.com/technetwork/java/javase/downloads/index.html) JDK
2) Install [IDEA](https://www.jetbrains.com/idea/)

### Installing
Checkout the Java9TestDrive project
```
git clone https://github.com/drmeph/Java9TestDrive.git
```

# What about Java 9

## Objectives of Java 9
* To make JDK and Java Standard Edition platform modular based in the sense that it can be scalled down to small 
computing devices well.
* To improve the overall security of the JDK and Java Implementations.
* To make build process and maintainance of java code libraries and large applications easy for JAVA SE and EE platforms.
* To design and implement a standard module system for the Java Platform which can be applied on both Platform and JDK easily.

## Java Platform Module System (JPMS) 
Java 9 JRE is organized in modules, so they can be customized to scale down to run on small devices. 
Before Java 9, the installation of JRE was all-or-nothing. The JRE contains tools, libraries, and classes that can 
satisfy requirements for running different applications. JPMS makes it possible to strip unnecessary libraries from the 
JRE to build customized images that are suitable for every unique application. This can dramatically reduce the package 
size making deployment faster.

### Module Structure
Like JARs, modules are a container for types and resources; but unlike JARs, they have additional characteristics – 
these are the most fundamental ones:
* a name, preferably one that is globally unique & STABLE (should not change over time)
* declarations of dependencies on other modules: Modules have to explicitely declare all of the dependencies on other 
modules otherwise the compiler will throw an error
* a clearly defined API that consists of exported packages. For code in one module to access types in another, 
the following accessibility rules must be fulfilled :
  * Access type (String) must be public
  * The package containing the type must be exported by its module
  * The accessing module must read the accessed one, which is typically by requiring it


### JPMS associated features
JDK is split in module that you can list with  
```
java --list-modules 
```
and look at and individual module with 
```
java --describe-module ${module}
```

### Module Configuration
A module’s properties are defined in a module declaration, a file module-info.java in the project’s root. 
It gets compiled into a module-info.class, called module descriptor, and ends up in the JAR’s root. 
This descriptor is the only difference between a plain JAR and a modular JAR.

* **src/main/java/module-info.java** you will find the declaration of *java9testdrive* module
* **src/main/java/com/drmeph/java9testdrive** package contains the main class and more generally the sources for the 
*java9testdrive* module

### Run the module
1) Compile the sources
```
javac -d target\mods\com.drmeph.java9testdrive src\main\java\module-info.java src\main\java\com\drmeph\java9testdrive\ModulesTester.java
``` 
2) Run the module
```
java --module-path target\mods -m com.drmeph.java9testdrive/com.drmeph.java9testdrive.ModulesTester
```

### Real Life Example
To look into a real life example, take a look at [spring-petclinic-java9-migration](https://github.com/drmeph/spring-petclinic-java9-migration).
This project is a fork of the Spring Boot Sample application Pet Clinic originally created for JAVA 8, and migrated to JAVA9.
Take a look at the last 2 commits :
* *5eacd916af69f9c12d7d3d1b7099dd796ef13ea0* : This commit is moving the POM file to JAVA 9 and fixing any compilation error
in order to make the project run.
*  *985e9c9da066f0054d9157fbff9677c4616d7110* : This commit is getting rid of the Maven plugins from the POM file and MOST IMPORTANTLY
creating the module-info.java file and manually adding the required dependencies

## JShell
The Java Shell tool (JShell) is an interactive tool for learning the Java programming language and prototyping Java code. 
JShell is a Read-Evaluate-Print Loop (REPL), which evaluates declarations, statements, and expressions as they are 
entered and immediately shows the results. The tool is run from the command line.

### Why use JShell
Using JShell, you can enter program elements one at a time, immediately see the result, and make adjustments as needed.

### How to Run JShell
To start JShell, 2 options :
* In terminal run :
```
$ jshell
|  Welcome to JShell -- Version 9
|  For an introduction type: /help intro

jshell>
```
* In IDEA, if set to use JAVA 9 and up
```
Tools > JShell Console...
```
You can how write programs and immediately see the result : 
```
// create a doubled method
int doubled(int i) { return i+2; }

//list the created methods
/method

//run the method
doubled(2)

doubled(2) = 4
```