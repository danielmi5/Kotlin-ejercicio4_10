import funciones.quiere

fun main(){
    val partida = Partida("3 en raya")

    do {
        partida.iniciarPartida()
        val quiereOtra = quiere("¿Quieres jugar otra partida?")
    } while (quiereOtra)

    println("\nEstadísticas:")
    partida.mostrarStats()

}