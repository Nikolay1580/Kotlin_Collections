package org.jetbrains.kotlin.course.old.school.functions

import org.jetbrains.kotlin.course.old.school.photo.Accessory
import org.jetbrains.kotlin.course.old.school.photo.Color
import org.jetbrains.kotlin.course.old.school.photo.PhotoCharacter
import org.springframework.stereotype.Service

@Service
class GameFunctionsService {
    fun getAllPossibleColors(): List<String> = Color.entries.map { it.toString().lowercase() }

    private fun String.toColor(): Color = Color.valueOf(this.capitalize())

    private fun Iterable<String>.toPhotoCharacters(): List<PhotoCharacter> {
        val photoCharacters = enumValues<PhotoCharacter>().associateBy { it.name.toUpperCase() }
        return this.mapNotNull { name ->
            photoCharacters[name.toUpperCase()]
        }
    }


    fun Iterable<String>.findPhoto(colorStr: String): PhotoCharacter? =
        toPhotoCharacters().find { it.backgroundColor == colorStr.toColor()}

    fun Iterable<String>.groupPhotosByColor(): List<PhotoCharacter> =
       toPhotoCharacters().groupBy { it.backgroundColor }.flatMap { it.value  }


    fun Iterable<String>.groupPhotosByHairAndHat(): List<PhotoCharacter> =
        toPhotoCharacters()
            .groupBy { it.hairType } // Group by hair type
            .flatMap { (_, characters) -> // For each hair type group
                characters.groupBy { it.accessories?.contains(Accessory.Hat) ?: false } // Group by hat presence
                    .values.flatten() // Flatten the inner map values
            }
}
