# Flappy Bird with and without Objects
Both games extend GBSGame that will handle creating a window that will update 60 times a second. This means both games only need to override an update and draw method to get a game on the screen.

`FlappyNO.java` contains a **N**o **O**bjects mentality that is right on the edge of getting out of hand. At 112 lines of code (excluding whitespace, closing braces, and comments), it's relatively short which means it's easier to work with. Going through the code though without comments could take a while to make sense of what's going on.

`Flappy.java` alongside `Bird.java` and `Pipe.java` totals to 99 lines of code meaning not only is the code more manageable and organized, it's also less lines of code due to not having to repeat the collision and teleporting code for pipes.


flappyNO = 112

pipe = 27
bird = 19
flappy = 53
total = 99