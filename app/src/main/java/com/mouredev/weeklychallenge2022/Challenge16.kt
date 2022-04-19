package com.mouredev.weeklychallenge2022

/*
 * Reto #16
 * EN MAYÚSCULA
 * Fecha publicación enunciado: 18/04/22
 * Fecha publicación resolución: 25/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(capitalizeEveryWord("hola soy eric."))
    println(capitalizeEveryWord("hoy hace 18 grados, y está nublado."))
    println(capitalizeEveryWord(" ola ,soi josepo , Y no se escrivir . "))
}

fun capitalizeEveryWord(phrase: String): String {
    var charIsSpace = true
    var newString = ""
    phrase.forEach {
        if (it.isWhitespace()) {
            charIsSpace = true
            newString += it
            return@forEach
        }
        if (charIsSpace) {
            newString += it.uppercase()
            if (Regex("\\p{Punct}").matches(it.toString())) return@forEach
            charIsSpace = false
            return@forEach
        }
        newString += it
    }
    return newString
}
