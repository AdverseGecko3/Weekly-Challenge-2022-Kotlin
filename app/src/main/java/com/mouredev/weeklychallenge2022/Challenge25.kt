package com.mouredev.weeklychallenge2022

import java.io.Serializable

/*
 * Reto #25
 * PIEDRA, PAPEL, TIJERA
 * Fecha publicación enunciado: 20/06/22
 * Fecha publicación resolución: 27/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule quien gana más partidas al piedra, papel, tijera.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "R" (piedra), "P" (papel) o "S" (tijera).
 * - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    rockPaperScissors(rpsList())
}

private enum class RPSValue {
    R, P, S
}

private fun rpsList(): List<Pair<RPSValue, RPSValue>> {
    val list = mutableListOf<Pair<RPSValue, RPSValue>>()
    (0..10).forEach { _ ->
        list.add(Pair(RPSValue.values().random(), RPSValue.values().random()))
    }
    return list
}

private fun rockPaperScissors(listOf: List<Pair<RPSValue, RPSValue>>) {
    var player1Wins = 0
    var player2Wins = 0
    listOf.forEach { pair ->
        print("${pair.first} vs ${pair.second} - ")
        when (pair.first) {
            RPSValue.R -> {
                when (pair.second) {
                    RPSValue.R -> {
                        println("Tie")
                    }
                    RPSValue.P -> {
                        println("Player 2 wins the round")
                        player2Wins++
                    }
                    RPSValue.S -> {
                        println("Player 1 wins the round")
                        player1Wins++
                    }
                }
            }
            RPSValue.P -> {
                when (pair.second) {
                    RPSValue.R -> {
                        println("Player 1 wins the round")
                        player1Wins++
                    }
                    RPSValue.P -> {
                        println("Tie")
                    }
                    RPSValue.S -> {
                        println("Player 2 wins the round")
                        player2Wins++
                    }
                }
            }
            RPSValue.S -> {
                when (pair.second) {
                    RPSValue.R -> {
                        println("Player 2 wins the round")
                        player2Wins++
                    }
                    RPSValue.P -> {
                        println("Player 1 wins the round")
                        player1Wins++
                    }
                    RPSValue.S -> {
                        println("Tie")
                    }
                }
            }
        }
    }

    if (player1Wins > player2Wins) {
        println("Player 1 wins the game!")
    } else if (player1Wins < player2Wins) {
        println("Player 2 wins the game!")
    } else {
        println("Tied game!")
    }
}