#!/usr/bin/python3
# -*- coding: utf-8 -*-

import platform
import os
from firstTheBest import FirstTheBest
from firstOnBreadth import FirstOnBreadth

'''
if __name__ == "__main__":
    

    firstTheBest = FirstTheBest()

    # maze  = FirstTheBest.createMaze1()
    maze  = FirstTheBest.createMaze2()
    firstTheBest.search(maze)




if __name__ == "__main__":
    
    firstOnBreadth = FirstOnBreadth()
    # maze  = FirstOnBreadth.createMaze1()
    maze  = FirstOnBreadth.createMaze2()

    firstOnBreadth.search(maze)

 '''

def menu():

    if platform.system() == 'Windows':
        os.system('cls')
    else:
        os.system('clear')

    cad = "============IA============"
    cad = "Selecciona una opción\n"
    cad += "\t1 - Busqueda por heuristca\n"
    cad += "\t2 - Busqueda a ciegas\n"
    cad += "\t9 - salir\n"
    print (cad)


if __name__ == "__main__":
     
    while True:
        menu()
        opcionMenu = input("inserta un numero valor >> ")
        if opcionMenu=="1":
        
            print ("")
            input("Has pulsado la opción 1...\npulsa una tecla para continuar")
        
        elif opcionMenu=="2":

            print ("")
            input("Has pulsado la opción 2...\npulsa una tecla para continuar")

        elif opcionMenu=="3":

            print ("")
            input("Has pulsado la opción 3...\npulsa una tecla para continuar")

        elif opcionMenu=="9":

            break

        else:

            print ("")
            input("No has pulsado ninguna opción correcta...\npulsa una tecla para continuar")

