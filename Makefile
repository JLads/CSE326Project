# Compile ASMR on Linux
# Author: Steven Anaya

# Project directories
BUILD_DIR := ./build
SRC_DIR := ./src

# Main class
MAIN := ASMR
BUILDPATH := $(BUILD_DIR)/$(MAIN)
CLASSPATH := $(SRC_DIR)/$(MAIN)
MAIN_CLASS := $(BUILDPATH)/$(MAIN).class
MAIN_JAVA := $(CLASSPATH)/$(MAIN).java
MAIN_JAR := $(MAIN).jar

# R script
SCRIPTPATH := Analysis/RScripts
SCRIPT := $(SCRIPTPATH)/score.r

# Java source code files
SRCS := $(shell find $(CLASSPATH) -type f -name \*.java)

# Java compilation command
JC := javac
JFLAGS := -d "$(BUILD_DIR)" -classpath "$(CLASSPATH)"

# Java jar command
JAR := jar
JARFLAGS := cfe

# Miscellaneous commands
MKDIR ?= mkdir -p
CP ?= cp
RM := rm -rf

.phony: all
all: $(MAIN_JAR)

# Make executable jar
$(MAIN_JAR): $(MAIN_CLASS)
	@$(JAR) $(JARFLAGS) "$(MAIN_JAR)" $(MAIN).$(MAIN) -C $(BUILD_DIR) $(MAIN)
	@$(RM) $(BUILD_DIR)

# Compile classes
$(MAIN_CLASS): $(MAIN_JAVA)
	@$(MKDIR) "$(BUILD_DIR)"
	@$(JC) $(JFLAGS) $(SRCS)

.PHONY: clean
clean:
	$(RM) "$(MAIN_JAR)"

