#Group#19
#Toan Chau, Kattia Chang, Nick Teng, Syrsha Harvey

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
