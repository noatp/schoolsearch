JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = schoolsearch.java\
			 Student.java\
			 Teacher.java

default:schoolsearch

schoolsearch: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
