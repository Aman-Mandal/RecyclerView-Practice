package com.aman.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "ContactsAdapter"
// <Generics> means of what type .. eg List<Person> , list of type person
class ContactsAdapter(val context: Context, val contacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    // Creates a new View - EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG,"onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    // Bind the data at position into the ViewHolder - INEXPENSIVE
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG,"onBindViewHolder $position")
        val contact : Person = contacts[position]
        holder.bind(contact)
    }

    // returns how many items are in the dataset
    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name_tv = itemView.findViewById<TextView>(R.id.name_tv)
        val age_tv = itemView.findViewById<TextView>(R.id.age_tv)

        fun bind(contact: Person) {
            // Bind the data in the contact into the views
            name_tv.text = contact.name
            age_tv.text = "Age: ${contact.age}"
        }
    }
}
