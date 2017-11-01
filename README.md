# Reversi-Game-
Reversi Tiny is a strategy board game for two players, played on a 4x4 board.

There are 16 disks, which are dark on one side (player 1’s color) and light on the other (player 2’s color). 
At each turn, any disks of the opponent’s color that are in one or more straight lines (horizontal, vertical or diagonal) 
and bounded by the disk just placed and another disk of the current player’s color are turned over to the current player’s
color. The object of the game is to try to end up with the most disks of your color at the end of the game.

Rules:
A game begins with four disks placed in a square in the middle of the grid, two pieces with the light side
up, the other two pieces with the dark side up, with same-colored disks on a diagonal with each other.

-------------
| |   | |   |
-------------
| | 2 | 1 | |
-------------
| | 1 | 2 | |
-------------
| |   |   | |
-------------

Dark and light is indicated by 1 and 2, respectively.


The dark player moves first and must place a piece with the dark side up on the board, in a position that
there exists at least one straight occupied line (horizontal, vertical or diagonal) between the new piece and
another dark piece, with one or more contiguous light pieces between them. Dark has the following options
indicated by X:
-----------------
| | X | | |
-----------------
| X | 2 | 1 | |
-----------------
| | 1 | 2 | X |
-----------------
| | | X | |
-----------------
If dark decides to put a piece in the leftmost location, the board appears as following:
-----------------
| | | | |
-----------------
| 1 | 1 | 1 | |
-----------------
| | 1 | 2 | |
-----------------

Players take alternate turns. If one player can not make any valid move, play passes back to the other
player 

Also, one move may form more than one lines.
For example, sometimes a horizontal line and a diagonal line can be formed simultaneously. All opponent’s
pieces on those lines must be flipped. The game ends when neither player can move. 






