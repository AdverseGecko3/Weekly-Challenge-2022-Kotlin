package com.mouredev.weeklychallenge2022

/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    drawFrame("Buenos días señor Wayne")
    drawFrame("Hace muchísimo calor, pero aguantamos")
    drawFrame("Mi hype por el nuevo álbum de Slipknot está por las nubes!!")
}

fun drawFrame(phrase: String) {
    var longestWord = 0
    val words = phrase.split(" ")
    words.forEach { word ->
        if (word.length > longestWord) longestWord = word.length
    }
    (0..words.size + 1).forEach { index ->
        if (index == 0 || index == words.size + 1) {
            repeat(longestWord + 4) { print("*") }
        } else {
            val spaces = longestWord - words[index - 1].length
            StringBuilder().apply {
                append("* ")
                append(words[index - 1])
                repeat(spaces) {
                    append(" ")
                }
                append(" *")
                print(this)
            }
        }
        println()
    }
}


