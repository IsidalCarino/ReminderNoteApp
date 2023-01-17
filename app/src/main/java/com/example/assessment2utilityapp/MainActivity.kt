package com.example.assessment2utilityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.ArrayAdapter
import java.util.*


class MainActivity : AppCompatActivity() {

    class Note(val text: String) {
        override fun toString(): String {
            return text
        }
    }
    private lateinit var listView: ListView
    private lateinit var noteText: EditText
    private lateinit var saveButton: Button
    private lateinit var editButton: Button
    private lateinit var deleteButton: Button
    private var notes: ArrayList<Note> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        noteText = findViewById(R.id.noteText)
        saveButton = findViewById(R.id.saveButton)
        editButton = findViewById(R.id.editButton)
        deleteButton = findViewById(R.id.deleteButton)


        notes = ArrayList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        listView.adapter = adapter

        saveButton.setOnClickListener {
            val note = Note(noteText.text.toString())
            notes.add(note)
            noteText.setText("")
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
            listView.adapter = adapter
        }


        editButton.setOnClickListener {

            if (listView.checkedItemPosition != ListView.INVALID_POSITION) {
                val selectedNote = listView.getItemAtPosition(listView.checkedItemPosition) as Note

                // Do something with the selected note, such as displaying it in the EditText for editing
                noteText.setText(selectedNote.text)

                // Add functionality for updating the note in the notes ArrayList
                saveButton.setOnClickListener {
                    val updatedNote = Note(noteText.text.toString())
                    notes[listView.checkedItemPosition] = updatedNote
                    updateListView()
                    listView.clearChoices()
                }
            }

        }

        deleteButton.setOnClickListener {
            if (listView.checkedItemPosition != ListView.INVALID_POSITION) {
                val selectedNote = listView.getItemAtPosition(listView.checkedItemPosition) as Note

                // Remove the selected note from the notes ArrayList
                notes.remove(selectedNote)

                // Update the ListView to reflect the changes
                updateListView()
                listView.clearChoices()
            }
        }





    }

    private fun updateListView() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        listView.adapter = adapter
    }

}