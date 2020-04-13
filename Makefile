JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = lab1.java\
			 Student.java\
			 Teacher.java

default: lab1

lab1: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
