#!/usr/bin/python3
# -*- coding: utf-8 -*-

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

