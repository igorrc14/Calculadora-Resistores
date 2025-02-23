// primeiro uso da linguagem kotlin
// calculadora de resistores

fun getColors(numFaixas: Int): List<String> {
    var colors: String

    do {
        print("Enter $numFaixas color names separated by commas: ")
        colors = readLine()!!.replace(" ","").uppercase()
    } while (colors.split(",").size != numFaixas)

    return colors.split(",")
}

fun coresValidas(colors: List<String>): Boolean {
    val coresPermitidas = arrayOf("PRETO", "MARROM", "VERMELHO", "LARANJA", "AMARELO", "VERDE", "AZUL", "VIOLETA", "CINZA", "BRANCO")
    val coresMultiplicador = arrayOf("PRETO", "MARROM", "VERMELHO", "LARANJA", "AMARELO", "VERDE", "AZUL", "VIOLETA", "CINZA", "BRANCO", "DOURADO", "PRATA")
    val coresTolerancia = arrayOf("MARROM", "VERMELHO", "VERDE", "AZUL", "VIOLETA", "CINZA", "DOURADO", "PRATA")
    val coresPPM = arrayOf("MARROM", "VERMELHO", "LARANJA", "AMARELO", "AZUL", "VIOLETA")

    if (colors.size == 4) {
        for (indice in 0..1) {
            if (colors[indice] !in coresPermitidas || colors[2] !in coresMultiplicador || colors[3] !in coresTolerancia) return false
        }
    }

    else {
        for (indice in 0..2) {
            if (colors[indice] !in coresPermitidas || colors[3] !in coresMultiplicador || colors[4] !in coresTolerancia) return false
        }
        if (colors.size == 6) {
            if (colors[5] !in coresPPM) return false
        }
    }

    return true
}

fun calcularResistencia(colors: List<String>, numFaixas: Int): Int {
    //TODO calcular a resistencia com base nas faixas do resistor.
}

fun main() {
    println("\nCalculadora de Resistores\n=========================")
    print("Insira o número de faixas: ")
    val numFaixas = readLine()!!.toInt()
    if (numFaixas != 4 && numFaixas != 5 && numFaixas != 6) {
        println("Error.")
        return
    }
    val colors = getColors(numFaixas)
    println(colors)
    if (coresValidas(colors))

}