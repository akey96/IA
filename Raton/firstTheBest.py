#!/usr/bin/python3
# -*- coding: utf-8 -*-

import queue
from common import Common

class FirstTheBest(Common):

    def best(self, maze, moves):

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

        return maze[j][i]

    @staticmethod
    def createMaze1():
        maze = []
        maze.append(["#", "#",   "#",   "#",   "#",   "X",   "#",   "#",  "#"])
        maze.append(["#", "13",  "14",  "15",  "10",  "11",  "10",  "9",  "#"])
        maze.append(["#", "12",  "#",   "#",   "9",   "#",   "#",   "8",  "#"])
        maze.append(["#", "11",  "#",   "9",   "8",   "7",   "#",   "7",  "#"])
        maze.append(["#", "10",  "#",   "8",   "#",   "6",   "#",   "6",  "#"])
        maze.append(["#", "9",   "#",   "7",   "#",   "5",   "#",   "5",  "#"])
        maze.append(["#", "8",   "#",   "6",   "#",   "4",   "#",   "#",  "#"])
        maze.append(["#", "7",   "6",   "5",   "4",   "3",   "2",   "1",  "#"])
        maze.append(["#", "#",   "#",   "#",   "#",   "#",   "#",   "0",  "#"])

        return maze

    @staticmethod
    def createMaze2():
        maze = []
        maze.append(["#", "#",   "#",   "#",   "#",   "X",   "#",   "#",  "#"])
        maze.append(["#", "13",  "14",  "15",  "10",  "11",  "10",  "9",  "#"])
        maze.append(["#", "12",  "#",   "#",   "9",   "#",   "#",   "8",  "#"])
        maze.append(["#", "11",  "#",   "9",   "8",   "7",   "#",   "7",  "#"])
        maze.append(["#", "10",  "#",   "8",   "#",   "6",   "#",   "6",  "#"])
        maze.append(["#", "9",   "#",   "7",   "#",   "5",   "#",   "5",  "#"])
        maze.append(["#", "8",   "#",   "6",   "#",   "4",   "#",   "4",  "#"])
        maze.append(["#", "7",   "6",   "5",   "4",   "3",   "2",   "1",  "#"])
        maze.append(["#", "#",   "#",   "#",   "#",   "#",   "#",   "0",  "#"])

        return maze

    def search(self, maze):
        nums = queue.Queue()
        nums.put("")
        add = ""

        while not self.findEnd(maze, add):

            costo = set()
            add = nums.get()
            for j in ["L", "R", "U", "D"]:        
                put = add + j
                if self.valid(maze, put):          
                    costo.add( (self.best(maze, put), put))
            
            costo = list(costo)
            costo2 = []
            for x in costo:
                if not x[0] == 'X':
                    costo2.append((int(x[0]), x[1]))
            costo2.sort(key=lambda val: val[0])
            for nodo in costo2:
                nums.put(nodo[1])
