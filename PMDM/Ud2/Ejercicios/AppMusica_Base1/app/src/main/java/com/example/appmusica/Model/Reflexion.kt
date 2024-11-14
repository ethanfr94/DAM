package com.example.appmusica.Model

import java.time.LocalDate

data class Reflexion(val frase: String, val autor: String, val fecha: LocalDate)

val reflexiones = listOf(
    Reflexion(
        frase = "La vida debe ser comprendida hacia atrás. Pero debe ser vivida hacia adelante.",
        autor = "Søren Kierkegaard",
        fecha = LocalDate.of(2024, 11, 10)
    ),
    Reflexion(
        frase = "La felicidad no es un ideal de la razón, sino de la imaginación.",
        autor = "Immanuel Kant",
        fecha = LocalDate.of(2024, 11, 11)
    ),
    Reflexion(
        frase = "El que tiene un porqué para vivir puede soportar casi cualquier cómo.",
        autor = "Friedrich Nietzsche",
        fecha = LocalDate.of(2024, 11, 12)
    ),
    Reflexion(
        frase = "No se puede pisar dos veces el mismo río.",
        autor = "Heráclito",
        fecha = LocalDate.of(2024, 11, 13)
    ),
    Reflexion(
        frase = "Solo sé que no sé nada.",
        autor = "Sócrates",
        fecha = LocalDate.of(2024, 11, 14)
    ),
    Reflexion(
        frase = "La verdadera sabiduría está en reconocer la propia ignorancia.",
        autor = "Platón",
        fecha = LocalDate.of(2024, 11, 15)
    ),
    Reflexion(
        frase = "Pienso, luego existo.",
        autor = "René Descartes",
        fecha = LocalDate.of(2024, 11, 16)
    ),
    Reflexion(
        frase = "El hombre está condenado a ser libre.",
        autor = "Jean-Paul Sartre",
        fecha = LocalDate.of(2024, 11, 17)
    ),
    Reflexion(
        frase = "No hay hechos, solo interpretaciones.",
        autor = "Friedrich Nietzsche",
        fecha = LocalDate.of(2024, 11, 18)
    ),
    Reflexion(
        frase = "La vida es realmente simple, pero insistimos en hacerla complicada.",
        autor = "Confucio",
        fecha = LocalDate.of(2024, 11, 19)
    )
)

fun getReflexionDelDia(): Reflexion {
    // Busca la reflexión del día actual y devuelve la primera que encuentre
    val r:Reflexion = reflexiones.find { it.fecha == LocalDate.now() }?:Reflexion(frase = "No hay frase del dia", autor = "", fecha = LocalDate.now())
    return r
}


