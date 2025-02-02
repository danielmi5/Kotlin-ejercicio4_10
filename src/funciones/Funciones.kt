package funciones
import Tablero
fun pedirCoord(tablero: Tablero): Pair<Int,Int>{
    var x: Int = 0 ; var y: Int = 0
    do {
        x = pedirOpcion("Introduce la fila >> ", 3)-1
        y = pedirOpcion("Introduce la columna >> ", 4)-1
        val coordVacia = tablero.comprobarCoord(x, y)
        if (!coordVacia) println("ERROR -> La coordenada no debe estar ya ocupada.")
    } while (!coordVacia)

    return Pair(x,y)
}


fun pedirOpcion(msj: String, numOpciones: Int): Int {
    var opcion: Int = -1
    do {
        print(msj)
        try {
            opcion = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }
        if (opcion !in 1..numOpciones) println("Coordenada fuera de límite.")
    } while (opcion !in 1..numOpciones)
    return opcion
}

fun quiere(msj: String): Boolean {
    while (true) {
        print("$msj (Sí/No) >> ")
        val respuesta = readln().lowercase()

        when (respuesta) {
            "sí", "si", "s" -> return true
            "no", "n" -> return false
            else -> println("Debe ser sí o no")
        }
    }
}