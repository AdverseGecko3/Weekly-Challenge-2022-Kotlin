package com.mouredev.weeklychallenge2022

/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    drawFigure(13, 0)
    drawFigure(12, 1)
}

fun drawFigure(size: Int, type: Int) {
    when (type) {
        0 -> {
            // Triangle
            (1..size).forEach { row ->
                if (row == size) {
                    (1..size).forEach { _ ->
                        print("*  ")
                    }
                } else if (row > size / 2) {
                    (1..size).forEach { col ->
                        if (col == row || col == size - (row - 1)) {
                            print("*  ")
                        } else {
                            print("   ")
                        }
                    }
                } else {
                    return@forEach
                }
                println()
            }
            println()
        }
        1 -> {
            // Square
            (1..size).forEach { row ->
                if (row == 1 || row == size) {
                    (1..size).forEach { _ ->
                        print("*  ")
                    }
                } else {
                    (1..size).forEach { col ->
                        if (col == 1 || col == size) {
                            print("*  ")
                        } else {
                            print("   ")
                        }
                    }
                }
                println()
            }
            println()
        }
    }
}
