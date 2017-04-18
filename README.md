# Draw Shapes
This is a simple console application for drawing the shapes.
## Installation
After unzipping source folder, at root directory enter following command in a shell.
$ ./gradlew build run
or if using windows run following on command prompt.
gradlew.bat build run
## Usage
Once application is running, use following commands followed by enter/return key to draw shapes.
1. To draw canvas use 'c width height' e.g. c 20 20
2. Once a canvas is drawn then to draw a line in canvas use 'l x1 y1 x2 y2' where x is horizontal axis and y is vertical axis. e.g. l 10 10 10 15. Only vertical and horizontal lines are drawn
3. To draw a rectangle in canvas use 'r x1 y1 x2 y2' where x1,y1 are top left corner and x2,y2 are bottom right corner co-ordinates
4. To Bucket fill in canvas use 'b x y colour' where x,y is starting point and colour is a character to be filled. e.g. b 2 3 o
5. To quit at any time enter command 'q'
## Technology stack
1. Used gradle for build and dependency management
2. Used Java 8 for development with Junit and Mockito


## Known Design and implementation issues
### Why separate Marker classes? Why not adding the drawing code within shapes?
This was done to reduce the clutter and ease the testing. This also helped separate teh drawing logic to value objects.
### Canvas class
Clutter in canvas class need sorting out. model and it's instantiation needs separation. clear method is probably not need and need removing. Canvas class should be considered under technical debt and should be considered ok for now as I have only limited time to spend on it.
### Why REPL not unit tested?
REPL is tested through integration tests. REPL is also developed using TDD through integration tests. It isn't great idea for prod code and for a production code I would do proper unit tests for it as well.
### Why some git commits have more changes committed than they should?
Usually i would commit code on every green test. However in some cases where a BDD approach driven integration test required more than one unit tests to be in place before integration test can be green.
At other times I must admit, i clearly let the guard down on this as I was quite distracted and disrupted while working on it over holiday period with loads of kids interacting and playing with me. sorry ;)
