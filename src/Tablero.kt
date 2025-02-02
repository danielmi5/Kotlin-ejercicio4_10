
class Tablero(
    val dimensiones: Int
) {
    val tablero = mutableListOf<MutableList<Char>>()

    fun crearTablero(){
        for (fila in 1..dimensiones) tablero.add(MutableList(dimensiones) { ' ' })
    }

    fun mostrarTablero(){
        println("Tablero")
        for (fila in 0..(dimensiones-1)) {
            print("|")
            for (columna in 0..(dimensiones-1)){
                print("${(tablero[fila][columna])}|")
            }
            println()
        }
        println("_______")
    }

    private fun comprobarDiagonal(): Boolean{
        val diagonalPrincipal = mutableListOf<Char>()
        val diagonalSecundaria = mutableListOf<Char>()

        for (i in 0..(dimensiones-1)){
            diagonalPrincipal.add(tablero[i][i])
            diagonalSecundaria.add(tablero[2-i][i])
        }
        if ((diagonalPrincipal.count{it == 'X'} == 3) || diagonalPrincipal.count{it == 'O'}==3) return true
        if ((diagonalSecundaria.count{it == 'X'} == 3) || diagonalSecundaria.count{it == 'O'}==3) return true

        return false
    }

    fun comprobarTablero(): Boolean{
        if (comprobarDiagonal()) return true

        for (fila in 0..(dimensiones-1)) {
            if ((tablero[fila].count { it == 'X'} == 3) || tablero[fila].count { it == 'O' } == 3) return true
            var cont = 0
            for (x in 0..(dimensiones-1)) {
                if (tablero[x][fila] == 'X') cont++
                if (tablero[x][fila] == 'O') cont--
                if (cont == 3 || cont == -3) return true
            }
        }
        return false
    }

    fun comprobarCoord(x: Int, y: Int): Boolean = tablero[x][y] == ' '

}