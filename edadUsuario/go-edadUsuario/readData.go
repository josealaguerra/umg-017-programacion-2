package main

import(
	"bufio"
	"os"
	"fmt"
	"strings"
)


func main()  {
	fmt.Print(`Bienvenido`)


	reader := bufio.NewReader(os.Stdin)

	entrada, _ := reader.ReadString('\n') // Leer hasta el separador de salto de línea
	eleccion := strings.TrimRight(entrada, "\r\n") // Remover el salto de línea de la entrada del usuario
	

	switch eleccion{
		case "1":
			fmt.Println("Prefieres pizza")
		case "2":
			fmt.Println("Prefieres tacos")
		default:
			fmt.Println("No prefieres ninguno de ellos")
	}
}