package com.aman.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Person(val name : String, val age : Int)

private lateinit var contacts_rv : RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contacts_rv = findViewById(R.id.contacts_rv)


        // STEPS OF IMPLEMENTING RECYCLERVIEW

        // 1. Add RecyclerView AndroidX Library to the build Gradle file. - DONE

        // 2. Define a model class to use as the data source - DONE
        val contacts = createContacts()

        // 3. Add a RecyclerView to your activity to display the items. - DONE

        // 4. Create a custom row layout XML file to visualize the item - DONE

        // 5. Create a RecyclerView.Adapter and ViewHolder to render the item
        contacts_rv.adapter = ContactsAdapter(this, contacts)

        // 6. Bind the Adapter to the data source to populate the Recyclerview
        contacts_rv.layoutManager = LinearLayoutManager(this)

    }

    private fun createContacts():List<Person>{
        val contacts : MutableList<Person> = mutableListOf<Person>()
        for (i in 1..100){
            contacts.add(Person("Person $i", i))
        }
        return contacts
    }
}