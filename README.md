## Project structure
JDK version: Java SE 18

Language level: 16

Maven version: 3.8.4

## Download program
Download the repository and unzip or clone the repository using git:

`git clone git@csil-git1.cs.surrey.sfu.ca:cmpt276s22_group23/project.git`

## Generate an executable JAR file
In your terminal, move to phase2 folder of the project.

Generate executable JAR file for the project by running the following maven command:

`mvn package`

This generates a jar file named **project-1.0-SNAPSHOT.jar** located in the `target` directory.

## Run program
To run the game, you can run the following command:

`mvn exec:java`

Or you can run the game by running the JAR file "project-1.0-SNAPSHOT.jar" by running the following command:

`java --module-path /path/to/JavaFX/lib --add-modules=javafx.controls,javafx.fxml -jar target/project-1.0-SNAPSHOT.jar`

where `/path/to/JavaFX` is where the JavaFX file located in your local machine.

## How to play the game
Navigate the maze using "↑", "←", "↓", "→" arrow key controls to maneuver the player up, left, down, and right respectively.

Avoid colliding with the police to prevent capture.

Avoid collecting bombs. If your score drops below 0 you lose the game (bombs decrement your score by 20 points).

Collect diamonds for 20 bonus points (cash is worth 10 points).

Collect all the available cash rewards and exit using the door on the right hand side to win the game.

## Test program
You can test the game by running the following command:

`mvn test`

## Generate Javadocs
You can generate javadocs for the project by running the following command:

`mvn javadoc:javadoc`

The Javadocs are located in the `target/site/apidocs` directory and can be viewed by opening the index.html file in your browser.
