package com.formapp.model

import java.io.Serializable

data class Form(
    val id: String, // Eindeutige ID für das Formular
    var name: String, // Name des Formulars
    var fields: List<FormField> // Liste der Felder im Formular
) : Serializable

data class FormField(
    var fieldName: String, // Name des Feldes
    var fieldType: FieldType, // Typ des Feldes (z. B. Text, Zahl, Checkbox)
    var isRequired: Boolean // Gibt an, ob das Feld verpflichtend ist
) : Serializable

enum class FieldType {
    TEXT, NUMBER, DECIMAL, DROPDOWN, CHECKBOX
}
