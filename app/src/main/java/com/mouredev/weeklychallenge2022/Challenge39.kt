package com.mouredev.weeklychallenge2022

/*
 * Reto #39
 * TOP ALGORITMOS: QUICK SORT
 * Fecha publicación enunciado: 27/09/22
 * Fecha publicación resolución: 03/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Implementa uno de los algoritmos de ordenación más famosos: el "Quick Sort",
 * creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia nos ayuda a
 *   mejorar nuestro conocimiento sobre ingeniería de software. Dedícale tiempo a entenderlo,
 *   no únicamente a copiar su implementación.
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS", donde trabajaremos y entenderemos
 *   los más famosos de la historia.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println(quickSort(listOf(3, 5, 6, 7, 8, 2, 4, 9, 1)))
}

private fun quickSort(numberList: List<Int>): List<Int> {
    return if (numberList.size < 2) {
        numberList
    } else {
        calculateQuickSort(numberList.toMutableList(), 0, numberList.lastIndex)
    }
}

fun calculateQuickSort(numberList: MutableList<Int>, first: Int, last: Int): MutableList<Int> {
    var i = first
    var j = last
    var array = numberList
    val pivot = (array[i] + array[j]) / 2

    while (i < j) {
        while (array[i] < pivot) {
            i += 1
        }
        while (array[j] > pivot) {
            j -= 1
        }
        if (i <= j) {
            val x = array[j]
            array[j] = array[i]
            array[i] = x
            i += 1
            j -= 1
        }
    }
    if (first < j) {
        array = calculateQuickSort(array, first, j)
    }
    if (last > i) {
        array = calculateQuickSort(array, i, last)
    }
    return array
}
