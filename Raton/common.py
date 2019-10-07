#!/usr/bin/python3
# -*- coding: utf-8 -*-

class Common:
    
    def __init__(self):
        self.cost = 0

    def printMaze(self, maze, path=""):
        for x, pos in enumerate(maze[0]):
            if pos == "X":
                start = x

        i = start
        j = 0
        pos = set()
        for move in path:
            if move == "L":
                i -= 1

            elif move == "R":
                i += 1

            elif move == "U":
                j -= 1

            elif move == "D":
                j += 1
            pos.add((j, i))
        # print(pos)
        for j, row in enumerate(maze):
            for i, col in enumerate(row):
                if (j, i) in pos:
                    print('{0: ^4}'.format('+'), end="")          
                else:
                    print('{0: ^4}'.format(col), end="")
            print()
        print('costo: {0: ^4}'.format(self.cost), end="")



    def valid(self, maze, moves):
        for x, pos in enumerate(maze[0]):
            if pos == "X":
                start = x

        i = start
        j = 0
        for move in moves:
            if move == "L":
                i -= 1

            elif move == "R":
                i += 1

            elif move == "U":
                j -= 1

            elif move == "D":
                j += 1

            if not(0 <= i < len(maze[0]) and 0 <= j < len(maze)):
                return False
            elif (maze[j][i] == "#"):
                return False

        return True

    def findEnd(self, maze, moves):
        
        for x, pos in enumerate(maze[0]):
            if pos == "X":
                start = x

        i = start
        j = 0
        for move in moves:
            if move == "L":
                i -= 1

            elif move == "R":
                i += 1

            elif move == "U":
                j -= 1

            elif move == "D":
                j += 1

        if maze[j][i] == "0":
            print("Found: " + moves)
            self.printMaze(maze, moves)
            return True

        return False

