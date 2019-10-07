#!/usr/bin/python3
# -*- coding: utf-8 -*-

import queue
from common import Common


class FirstOnBreadth(Common):

    
    def __init__(self):
        super().__init__()

    @staticmethod
    def createMaze1():
        maze = []
        maze.append(["#","#", "#", "#", "#", "X","#"])
        maze.append(["#"," ", " ", " ", "#", " ","#"])
        maze.append(["#"," ", "#", " ", "#", " ","#"])
        maze.append(["#"," ", "#", " ", " ", " ","#"])
        maze.append(["#"," ", "#", "#", "#", " ","#"])
        maze.append(["#"," ", " ", " ", "#", " ","#"])
        maze.append(["#","#", "#", "#", "#", "0","#"])

        return maze

    @staticmethod
    def createMaze2():
        maze = []
        maze.append(["#","#", "#", "#", "#", "X", "#", "#", "#"])
        maze.append(["#"," ", " ", " ", " ", " ", " ", " ", "#"])
        maze.append(["#"," ", "#", "#", " ", "#", "#", " ", "#"])
        maze.append(["#"," ", "#", " ", " ", " ", "#", " ", "#"])
        maze.append(["#"," ", "#", " ", "#", " ", "#", " ", "#"])
        maze.append(["#"," ", "#", " ", "#", " ", "#", " ", "#"])
        maze.append(["#"," ", "#", " ", "#", " ", "#", "#", "#"])
        maze.append(["#"," ", " ", " ", " ", " ", " ", " ", "#"])
        maze.append(["#","#", "#", "#", "#", "#", "#", "0", "#"])

        return maze

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
                    print('{0: ^2}'.format('+'), end="")          
                else:
                    print('{0: ^2}'.format(col), end="")
            print()
        print('costo: {0: ^2}'.format(self.cost), end="")

    def search(self, maze):
        
        nums = queue.Queue()
        nums.put("")
        add = ""

        self.printMaze(maze, add)

        self.cost = 0
        while not self.findEnd(maze, add):
            self.cost += 1
            add = nums.get()
            # print(add)
            for j in ["L", "R", "U", "D"]:
                put = add + j
                if self.valid(maze, put):
                    nums.put(put)
