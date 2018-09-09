DIR_CLASS = classes/
DIR_SRC = src/main/java/fr/ubordeaux/ao/
JFLAGS = -g -d $(DIR_CLASS) -sourcepath $(DIR_SRC)
JC = javac
JVM = java

SRC = $(DIR_SRC)*.java
CLASS = $(SRC:.java=.class)

all: $(CLASS)

%.class: %.java
	$(JC) $(JFLAGS) $<

clean:
	rm -rf $(DIR_CLASS)*.class
