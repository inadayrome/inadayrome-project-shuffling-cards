# Shuffling cards
## Problem Statement
Imagine you work for a (legalized) gambling regulatory body. Your task is to determine
programmatically the number of shuffling steps dealers must shuffle a standard 52-card deck
to truly approximate a computer’s randomizer algorithm. For simplicity, each dealer will
exclusively follow one of the standard shuffling methods (Overhand shuffle, Riffle shuffle
Permutation, pile shuffle, Faro shuffle). You will want to search get a sense for how you
would model this array transformation. Then, for each, determine via simulation how many
times each shuffle needs to be performed to closely approximate a computer’s build-in
randomizer algorithm.

## Considerations & Assumptions

## Approach

## Tech stack
- Java 21
- Gradle compiler
- Spring

## How to run the project
This project uses Java 21 and Spring framework.

### Using the correct java version
1. Check current jdk version
```sh
java -version
/usr/libexec/java_home -V
```
2. For MacOS, install Java 21 via homebrew:
```sh
brew install --cask temurin@21
```

### Installing dependencies

### Compiling the application
```sh
./gradlew build
```

### Running the application
```sh
./gradlew :bootRun
```

### IDE integration
#### Vscode
1. Copy the example VSCode config file
```sh
cp .vscode/settings.json.copy .vscode/settings.json
```
2. Configure jdk and gradle settings on vscode

## Tests
```
./gradlew test
```

