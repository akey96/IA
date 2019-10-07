#!/usr/bin/python3
# -*- coding: utf-8 -*-

import queue
from common import Common


class FirstOnBreadth(Common):

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

    def search(self, maze):
        nums = queue.Queue()
        nums.put("")
        add = ""

        while not self.findEnd(maze, add): 
            add = nums.get()
            print(add)
            for j in ["L", "R", "U", "D"]:
                put = add + j
                if self.valid(maze, put):
                    nums.put(put)
