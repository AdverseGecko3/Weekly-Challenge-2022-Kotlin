package com.mouredev.weeklychallenge2022

/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println("1734 -> ${calculateCycle(1734)}")
    println("1949 -> ${calculateCycle(1949)}")
    println("1984 -> ${calculateCycle(1984)}")
    println("2022 -> ${calculateCycle(2022)}")
    println("2167 -> ${calculateCycle(2167)}")
}

enum class ZodiacSigns {
    RAT, OX, TIGER, RABBIT, DRAGON, SNAKE, HORSE, SHEEP, MONKEY, ROOSTER, DOG, PIG
}

enum class Elements {
    WOOD, FIRE, EARTH, METAL, WATER
}

fun calculateCycle(year: Int): Pair<ZodiacSigns, Elements> {
    var start = 1984
    if (year < start) {
        while (year < start) {
            start -= 60
        }
    }
    if (year > start) {
        while (year > start + 60) {
            start += 60
        }
    }

    val yearsDiff = year - start

    val zodiacSignsSize = ZodiacSigns.values().size
    var yearsZodiacDiff = yearsDiff
    while (yearsZodiacDiff > zodiacSignsSize) {
        yearsZodiacDiff -= zodiacSignsSize
    }
    val zodiacSign = ZodiacSigns.values()[yearsZodiacDiff]


    val elementsSize = Elements.values().size * 2
    var yearElementsDiff = yearsDiff
    while (yearElementsDiff >= elementsSize) {
        yearElementsDiff -= elementsSize
    }
    val elementSign = Elements.values()[yearElementsDiff / 2]

    return Pair(zodiacSign, elementSign)
}