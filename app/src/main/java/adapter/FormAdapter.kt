package com.formapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.formapp.R
import com.formapp.model.Form

class FormAdapter(
    private val forms: List<Form>,
    private val onFormClick: (Form) -> Unit
) : RecyclerView.Adapter<FormAdapter.FormViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_form, parent, false)
        return FormViewHolder(view)
    }

    override fun onBindViewHolder(holder: FormViewHolder, position: Int) {
        val form = forms[position]
        holder.bind(form, onFormClick)
    }

    override fun getItemCount(): Int = forms.size

    class FormViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val formNameTextView: TextView = itemView.findViewById(R.id.formNameTextView)

        fun bind(form: Form, onFormClick: (Form) -> Unit) {
            formNameTextView.text = form.name
            itemView.setOnClickListener { onFormClick(form) }
        }
    }
}
