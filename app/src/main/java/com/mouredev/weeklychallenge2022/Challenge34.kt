package com.mouredev.weeklychallenge2022

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    try {
        println(missingNumbers(listOf(0, 1, 4, 5, 7, 9, 13)))
        println(missingNumbers(listOf(13, 9, 7, 5, 4, 1, 0)))
    } catch (e: ArrayNotSortedException) {
        println(e.message)
    }
}

private fun missingNumbers(givenList: List<Int>): List<Int> {
    var sortType = 0
    if (givenList.zipWithNext().all { it.first < it.second }) {
        sortType = 1
    }
    if (givenList.zipWithNext().all { it.first > it.second }) {
        sortType = 2
    }
    if (sortType == 0) {
        throw ArrayNotSortedException()
    }

    val missingNumbers = mutableListOf<Int>()
    if (sortType == 1) {
        (givenList.first()..givenList.last()).forEach { num ->
            if (!givenList.contains(num)) {
                missingNumbers.add(num)
            }
        }
    } else {
        (givenList.first() downTo givenList.last()).forEach { num ->
            if (!givenList.contains(num)) {
                missingNumbers.add(num)
            }
        }
    }
    return missingNumbers
}

class ArrayNotSortedException(message: String = "ERROR: The given array is not sorted!") :
    Exception(message)
