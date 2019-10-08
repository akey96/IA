#!/usr/bin/python3
# -*- coding: utf-8 -*-

import queue
from common import Common

class FirstTheBest(Common):
    
    def __init__(self):
        super().__init__()
    
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
        print("\nE(x) = Estado inicial del Laberinto\n")
        self.printMaze(maze, add)


        self.cost = 0
        while not self.findEnd(maze, add):
            self.cost += 1
            cost_matriz = set()
            add = nums.get()
            for j in ["L", "R", "U", "D"]:        
                put = add + j
                if self.valid(maze, put):          
                    cost_matriz.add( (self.best(maze, put), put))
            
            cost_matriz = list(cost_matriz)
            cost_matriz_aux = []
            for x in cost_matriz:
                if not x[0] == 'X':
                    cost_matriz_aux.append((int(x[0]), x[1]))
            cost_matriz_aux.sort(key=lambda val: val[0])
            for nodo in cost_matriz_aux:
                nums.put(nodo[1])
