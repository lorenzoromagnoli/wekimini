# wekimini
This is the "mini" version of the new Wekinator, first released Spring 2015.

All code by Rebecca Fiebrink, except for included libraries (see licenses) and 
WeakListenerSupport.java (see header for full attribution).

www.wekinator.org

## Building

Make sure you have Java, Java SDK, and Ant installed, then:

```
ant -f build.xml -Dplatforms.JDK_1.7.home="%JAVA_HOME%"
```

## Running

The following command opens a new Wekinator project.

```
java -jar dist/WekiMini.jar
```

This fork of the Wekinator Project adds the functionality to open Wekinator projects from the command line.

To open an existing Wekinator project and immediately begin listening on the OSC port specified
in its .wekproj file simply add the path to the project file as a command line argument. Multiple
projects can be opened in this way.

```
java -jar dist/WekiMini.jar /path/to/wek/project.wekproj /path/to/another/project.wekproj
```
