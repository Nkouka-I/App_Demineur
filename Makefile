JC = javac
JVM = java
MAIN = MainTest
SRC = $(wildcard *.java)

all: $(SRC)
	$(JC) $(SRC)

run: all
	$(JVM) $(MAIN)

clean:
	rm -f *.class
