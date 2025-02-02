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
        numTurnos = 0
        var terminado = false
        var empate = false
        var turno: String = ""
        while (!terminado){
            turno = "j1"
            jugarTurno(turno, tablero)
            terminado = tablero.comprobarTablero()
            if (terminado == false && numTurnos != dimensiones*dimensiones){
                turno = "j2"
                jugarTurno(turno, tablero)
                terminado = tablero.comprobarTablero()
            }

            if (terminado == false && numTurnos == dimensiones*dimensiones){
                terminado = true
                empate = true
            }


        }
        if (empate){
            println("\nHabéis empatado que mala pata!!!")
            numEmpates++
        } else{
            println("\nEl ganador es el $turno, ENHORABUENA!!!")
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
        println("La partida '$nombre' ha tenido $numEmpates empates, $winsJ1 victorias para el jugador 1 y $winsJ2 victorias para el jugador2.")
    }
}