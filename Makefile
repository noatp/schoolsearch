JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = schoolsearch.java\
			 Node.java\

default:schoolsearch

schoolsearch: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
