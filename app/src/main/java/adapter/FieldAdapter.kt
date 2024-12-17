package com.formapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.formapp.R
import com.formapp.model.FormField

class FieldAdapter(
    private val fields: List<FormField>
) : RecyclerView.Adapter<FieldAdapter.FieldViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_field, parent, false)
        return FieldViewHolder(view)
    }

    override fun onBindViewHolder(holder: FieldViewHolder, position: Int) {
        val field = fields[position]
        holder.bind(field)
    }

    override fun getItemCount(): Int = fields.size

    class FieldViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fieldName: EditText = itemView.findViewById(R.id.fieldNameEditText)
        private val fieldType: Spinner = itemView.findViewById(R.id.fieldTypeSpinner)
        private val isRequired: CheckBox = itemView.findViewById(R.id.fieldRequiredCheckBox)

        fun bind(field: FormField) {
            fieldName.setText(field.fieldName)
            // Setze Spinner und Checkbox entsprechend dem Feld
            // TODO: Spinner mit Feldtypen befüllen
            isRequired.isChecked = field.isRequired
        }
    }
}
