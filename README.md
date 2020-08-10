# taint-bug
Taints in both examples cannot be propagated.  
IDE: IntelliJ IDEA

Run/Debug Configurations:  
|- Main class: PhosphorExamples  
|- VM options: -Xbootclasspath/a:path_to_Phosphor-0.0.5-SNAPSHOT.jar -javaagent:path_to_Phosphor-0.0.5-SNAPSHOT.jar=cacheDir=path_to_temp  
|- JRE: path_to_jre-inst
