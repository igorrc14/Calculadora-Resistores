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

fun calcularResistencia(colors: List<String>): String {

    val map1 = mapOf(
        "PRETO" to 0.0,
        "MARROM" to 1.0,
        "VERMELHO" to 2.0,
        "LARANJA" to 3.0,
        "AMARELO" to 4.0,
        "VERDE" to 5.0,
        "AZUL" to 6.0,
        "VIOLETA" to 7.0,
        "CINZA" to 8.0,
        "BRANCO" to 9.0
    )
    val map2 = mapOf(
        "PRATA" to 0.01,
        "OURO" to 0.1,
        "PRETO" to 1.0,
        "MARROM" to 10.0,
        "VERMELHO" to 100.0,
        "LARANJA" to 1000.0,
        "AMARELO" to 10000.0,
        "VERDE" to 100000.0,
        "AZUL" to 1000000.0,
        "VIOLETA" to 10000000.0
    )
    val map3 = mapOf(
        "PRATA" to "10%",
        "OURO" to "5%",
        "MARROM" to "1%",
        "VERMELHO" to "2%",
        "VERDE" to "0.5%",
        "AZUL" to "0.25%",
        "VIOLETA" to "0.1%",
        )
    val map4 = mapOf("MARROM" to "100",
        "VERMELHO" to "50",
        "LARANJA" to "15",
        "AMARELO" to "25")

    if (colors.size == 4) {
        return "${(map1[colors[0]]!! * 10 + map1[colors[1]]!!) * map2[colors[2]]!!}Ω ${map3[colors[3]]}"
    }
    else {
        if (colors.size == 6) {
            return "${(map1[colors[0]]!! * 100 + map1[colors[1]]!! * 10 + map1[colors[2]]!!) * map2[colors[3]]!!}Ω ${map3[colors[4]]} ${map4[colors[5]]}ppm"
        }
        return "${(map1[colors[0]]!! * 100 + map1[colors[1]]!! * 10 + map1[colors[2]]!!) * map2[colors[3]]!!}Ω ${map3[colors[4]]}"
    }
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
    if (coresValidas(colors)) println(calcularResistencia(colors))
    else println("Error.")
}