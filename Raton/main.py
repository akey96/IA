#!/usr/bin/python3
# -*- coding: utf-8 -*-

import queue
from firstTheBest import FirstTheBest
from firstOnBreadth import FirstOnBreadth


if __name__ == "__main__":
    
    nums = queue.Queue()
    nums.put("")
    add = ""

    firstTheBest = FirstTheBest()

    maze  = FirstTheBest.createMaze1()
    # maze  = FirstTheBest.createMaze2()
    while not firstTheBest.findEnd(maze, add):

        costo = set()
        add = nums.get()
        for j in ["L", "R", "U", "D"]:        
            put = add + j
            if firstTheBest.valid(maze, put):          
                costo.add( (firstTheBest.best(maze, put), put))
        
        costo = list(costo)
        costo2 = []
        for x in costo:
            if not x[0] == 'X':
                costo2.append((int(x[0]), x[1]))
        costo2.sort(key=lambda val: val[0])
        for nodo in costo2:
            nums.put(nodo[1])
        


'''

if __name__ == "__main__":
    
    nums = queue.Queue()
    nums.put("")
    add = ""
    firstOnBreadth = FirstOnBreadth()
    maze  = FirstOnBreadth.createMaze1()
    # maze  = FirstOnBreadth.createMaze2()

    while not firstOnBreadth.findEnd(maze, add): 
        add = nums.get()
        print(add)
        for j in ["L", "R", "U", "D"]:
            put = add + j
            if firstOnBreadth.valid(maze, put):
                nums.put(put)




'''