package com.formapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.formapp.adapter.FieldAdapter
import com.formapp.model.Form
import com.formapp.model.FormField
import com.formapp.model.FieldType
import java.util.*

class FormEditorActivity : AppCompatActivity() {
    private lateinit var fieldListView: RecyclerView
    private lateinit var adapter: FieldAdapter
    private val fields = mutableListOf<FormField>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_editor)

        // RecyclerView initialisieren
        fieldListView = findViewById(R.id.fieldListView)
        adapter = FieldAdapter(fields)
        fieldListView.layoutManager = LinearLayoutManager(this)
        fieldListView.adapter = adapter

        // Button: Neues Feld hinzufügen
        findViewById<Button>(R.id.addFieldButton).setOnClickListener {
            fields.add(FormField("Neues Feld", FieldType.TEXT, false))
            adapter.notifyDataSetChanged()
        }

        // Button: Formular speichern
        findViewById<Button>(R.id.saveFormButton).setOnClickListener {
            val formName = findViewById<EditText>(R.id.formNameEditText).text.toString()
            val newForm = Form(UUID.randomUUID().toString(), formName, fields)
            // TODO: Speichere das Formular (z. B. in einer Datenbank)
            finish()
        }
    }
}
