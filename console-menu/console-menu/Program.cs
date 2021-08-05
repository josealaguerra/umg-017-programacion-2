using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace console_menu
{
    class Program
    {
        static void Main(string[] args)
        {

            ConsoleKeyInfo op;
            do
            {
                Console.Clear();
                Console.WriteLine("Bienvenidos al curso de programacion");
                Console.WriteLine("Menu");
                Console.WriteLine("[A] Solicitar dos numeros y devolver el mayor.");
                Console.WriteLine("[B] Solicitar un numero y hacer un ciclo.");
                Console.WriteLine("[C] Agregar 10 alumnos a un arreglo e imprimirlo");
                op = Console.ReadKey(true);

                switch (op.Key)
                {
                    //default:

                    case ConsoleKey.A:
                        Console.Clear();
                        Console.WriteLine("[A] Solicitar dos numeros y devolver el mayor.");
                        break;

                    case ConsoleKey.B:
                        Console.Clear();
                        Console.WriteLine("[B] Solicitar un numero y hacer un ciclo.");
                        int numero;
                        Console.WriteLine("Ingresa un valor");

                        numero = Convert.ToInt32(Console.ReadLine());
                        for (int i =0; i < numero; i++)
                        {
                            Console.WriteLine(i);
                        }
                        Console.ReadKey();
                        break;

                    case ConsoleKey.C:
                        Console.Clear();
                        Console.WriteLine("[C] Agregar 10 alumnos a un arreglo e imprimirlo");
                        string[] alumnos = new string[10];
                        for (int i = 0; i < 10; i++)
                        {
                            alumnos[i] = Console.ReadLine();
                            Console.WriteLine("Se ingreso la informacion, alumno: "+i+", "+alumnos[i]);
                        }

                        for (int i = 0; i < 10; i++)
                        {
                            Console.WriteLine("Se ingreso la informacion, alumno: " + i + ", " + alumnos[i]);
                        }
                        Console.ReadKey();
                        break;

                    case ConsoleKey.Escape:
                        break;

                }

            } while (op.Key != ConsoleKey.Escape);




        }
    }
}
