DIR_CLASS = classes
DIR_SRC = src/main/java
JFLAGS = -g -d $(DIR_CLASS) -cp $(DIR_SRC)
JC = javac
JVM = java

SRC = $(shell find ./src/main/java -type f -name '*.java')
CLASS = $(SRC:.java=.class)

all: $(CLASS)

%.class: %.java
	$(JC) $(JFLAGS) $<

run:
	$(JVM) -cp $(DIR_CLASS) fr.ubordeaux.ao.Main

.PHONY: clean
clean:
	rm -rf $(DIR_CLASS)/fr/
	rm -rf *~ .*~
