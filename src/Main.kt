import funciones.quiere

fun main(){
    val partida = Partida("josre")

    do {
        partida.iniciarPartida()
        val quiereOtra = quiere("¿Quieres jugar otra partida?")
    } while (quiereOtra)

    println("Estadísticas:\n")
    partida.mostrarStats()

}