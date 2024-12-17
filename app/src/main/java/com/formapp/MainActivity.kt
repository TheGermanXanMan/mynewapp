package com.formapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.formapp.adapter.FormAdapter
import com.formapp.model.Form
import com.formapp.model.FormField
import com.formapp.model.FieldType
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FormAdapter
    private val forms = mutableListOf<Form>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = FormAdapter(forms) { form -> openFormEditor(form) }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.addFormButton).setOnClickListener {
            openFormEditor(null) // Null für ein neues Formular
        }
    }

    private fun openFormEditor(form: Form?) {
        val intent = Intent(this, FormEditorActivity::class.java)
        intent.putExtra("form", form)
        startActivity(intent)
    }
}
