#!/usr/bin/python3
# -*- coding: utf-8 -*-

import platform
import os
from firstTheBest import FirstTheBest
from firstOnBreadth import FirstOnBreadth

def menu():

    if platform.system() == 'Windows':
        os.system('cls')
    else:
        os.system('clear')

    cad = "============IA============"
    cad = "Selecciona una opción\n"
    cad += "\t1 - Busqueda a ciegas\n"
    cad += "\t2 - Busqueda por heuristica\n"
    cad += "\t9 - salir\n"
    print (cad)

def menu2():

    if platform.system() == 'Windows':
        os.system('cls')
    else:
        os.system('clear')

    cad = "============IA============"
    cad = "Selecciona una opción\n"
    cad += "\t1 - Ejemplo 1\n"
    cad += "\t2 - Ejemplo 2\n"
    cad += "\t9 - Volver al menu inicio\n"
    print (cad)


if __name__ == "__main__":
     
    while True:
        menu()
        opcionMenu = input("inserta un numero valor >> ")
        if opcionMenu=="1":
            print ("Has pulsado Busqueda a ciegas ...")
            while True:
                menu2()
                opcionMenu2 = input("inserta un numero valor >> ")
                if opcionMenu2=="1":
                    print ("Has pulsado Ejemplo 1 ...\n")
                    firstOnBreadth = FirstOnBreadth()
                    maze  = FirstOnBreadth.createMaze1()
                    firstOnBreadth.search(maze)
                    input("\npulsa una tecla para continuar")
                elif opcionMenu2=="2":
                    print ("Has pulsado Ejemplo 1 ...\n")    
                    firstOnBreadth = FirstOnBreadth()
                    maze  = FirstOnBreadth.createMaze2()
                    firstOnBreadth.search(maze)
                    input("\npulsa una tecla para continuar")
                elif opcionMenu2=="9":
                    break
                else:
                    input("\nNo has pulsado ninguna opción correcta...\npulsa una tecla para continuar")

        elif opcionMenu=="2":

            print ("Has pulsado Busqueda por heuristica ...")
            while True:
                menu2()
                opcionMenu2 = input("inserta un numero valor >> ")
                if opcionMenu2=="1":
                    print ("Has pulsado Ejemplo 1 ...\n")
                    firstTheBest = FirstTheBest()
                    maze  = FirstTheBest.createMaze1()
                    firstTheBest.search(maze)
                    input("\npulsa una tecla para continuar")
                
                elif opcionMenu2=="2":
                    print ("Has pulsado Ejemplo 1 ...\n")    
                    firstTheBest = FirstTheBest()

                    maze  = FirstTheBest.createMaze2()
                    firstTheBest.search(maze)
                    input("\npulsa una tecla para continuar")

                elif opcionMenu2=="9":
                    break
                else:
                    input("\nNo has pulsado ninguna opción correcta...\npulsa una tecla para continuar")
        elif opcionMenu=="9":
            break
        else:
            input("\nNo has pulsado ninguna opción correcta...\npulsa una tecla para continuar")
