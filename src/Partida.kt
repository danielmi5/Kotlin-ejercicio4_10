import funciones.pedirCoord

class Partida(
    val nombre: String,
) {
    var numEmpates: Int = 0
    var winsJ1: Int = 0
    var winsJ2: Int = 0
    val dimensiones: Int = 3
    var numTurnos: Int = 0

    fun iniciarPartida() {
        println()
        val tablero = Tablero(dimensiones)
        tablero.crearTablero()
        numTurnos = 0 //reincio el número de turnos cada partida
        var terminado = false
        var empate = false //Para controlar en caso de empate
        var turno: String = "" // Turno con el nombre del jugador
        while (!terminado){
            //juega j1
            turno = "j1"
            jugarTurno(turno, tablero)
            terminado = tablero.comprobarTablero() //comprueba si ha ganado j1

            // si no ha ganado y no se han ocupado todas las "plazas" sigue el j2
            if (terminado == false && numTurnos != dimensiones*dimensiones){
                turno = "j2"
                jugarTurno(turno, tablero)
                terminado = tablero.comprobarTablero() //comprueba si ha ganado j2
            }

            // si nadie ha ganado y han ocupado todas las plazas -> EMPATE
            if (terminado == false && numTurnos == dimensiones*dimensiones){
                terminado = true
                empate = true
            }


        }
        mostrarResultado(turno, empate, tablero)
    }
    private fun mostrarResultado(turno: String, empate: Boolean, tablero: Tablero) {
        if (empate) {
            println("\nHabéis empatado, qué mala pata!!!")
            numEmpates++
        } else {
            println("\nEl ganador es $turno, ¡ENHORABUENA!")
            if (turno == "j1") winsJ1++ else winsJ2++
        }

        println("RESULTADO:")
        tablero.mostrarTablero()
    }

    private fun jugarTurno(turno: String, tablero: Tablero) {
        tablero.mostrarTablero()
        println("Turno del $turno")
        val (x, y) = pedirCoord(tablero)
        if (turno == "j1") tablero.tablero[x][y] = 'X' else tablero.tablero[x][y] = 'O'

        numTurnos++
    }

    fun mostrarStats(){
        println("La partida '$nombre' ha tenido $numEmpates empates, $winsJ1 victorias para el jugador1 y $winsJ2 victorias para el jugador2.")
    }
}