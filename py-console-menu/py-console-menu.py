import os


def clear(): 
    'Limpia la pantalla'
    os.system('cls') #on Windows System

def showTitle(title):
    'Limpia la pantalla y luego muestra un texto'
    clear()
    print ( title )

def waitTime():
    'Muestra un mensaje y espera un ENTER para continuar la ejecución del programa'
    print("\n Presiona ENTER para continuar...")
    input("")    


def showMenu():
    'Muestra el menú del programa'
    showTitle("""
    1.Que número es mayor?
    2.Mostrar ciclo
    3.Almacenar estudiantes
    4.Salir
    """)

def showInvalidOption():
    print("\n Opción no valida, intenta de nuevo, presiona ENTER !") 

def exitProgram():
    print("\n Saliendo del programa, presiona ENTER !") 
    input("")
    raise SystemExit    


def getValidInteger(inputDescription):
    'Permite obtener un numero entero valido'
    processCicle = True
    while processCicle:
        try:
            enterNumber = int( input("Ingresa "+inputDescription+" (numero entero valido): ") )
            break
            
        except ValueError:
            # Handle the exception
            print('Por favor ingrese un entero')
    return enterNumber




def getValidString(inputDescription):
    'Permite obtener una cadena de caracteres (string) valido'
    processCicle = True
    while processCicle:
        try:
            enterString =  input("Ingresa "+inputDescription+" (string valido): ") 
            if len(enterString) is 0:
                print("String esta vacio")
            elif not ( enterString.isalnum() ):
                print("String no es alfanumerico")
            else:
                break
            
        except ValueError:
            # Handle the exception
            print('Por favor ingrese una cadena de caracteres valida')
    return enterString



def showNumberGreater():
    'Calcula que numero es mayor, al comparar dos numeros'
    showTitle("Que número es mayor?")
    primerNumero = getValidInteger("primer numero")
    segundoNumero = getValidInteger("segundo numero")

    complemento = "Primer numero: "+str(primerNumero)+", segundo numero: "+str(segundoNumero)
    if primerNumero < segundoNumero:
        print("Segundo numero es mayor!"+complemento)
    elif primerNumero > segundoNumero:
        print("Primer numero es mayor!"+complemento)
    elif primerNumero == segundoNumero:
        print("Ambos numeros son iguales!"+complemento)
    
    waitTime()

def showCicle():
    'Hace un recorrido desde cero hasta el numero ingresado'
    showTitle("Mostrar ciclo")
    numeroCiclo = getValidInteger("numero")
    for elemento in range(0, numeroCiclo+1):
        print(elemento)
    waitTime()
    

def showSaveStudents():
    'Permite almacenar en un vector a 10 estudiantes'
    showTitle("Almacenar estudiantes")
    students=[]
    for student in range(0,10):
        studentName = getValidString( "Nombre del estudiante {}: ".format(student + 1) )
        #studentName = str( input("Nombre: ") )
        students.append(studentName)

    for listStudent in range(0,10):
        print("Estudiante "+format(listStudent + 1)+": "+format(students[listStudent]))

    waitTime()









ans=True
while ans:
    showMenu()
    ans=input("Que quiere realizar? ") 
    if ans=="1": 
      showNumberGreater()
    elif ans=="2":
      showCicle()
    elif ans=="3":
      showSaveStudents()
    elif ans=="4":
      exitProgram()
    elif ans !="":
      showInvalidOption()