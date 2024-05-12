package com.example.taskssqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskssqlite.databinding.ActivityAddNoteBinding
import com.example.taskssqlite.databinding.ActivityMainBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: TasksDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val task = Task(0, title, content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Added",Toast.LENGTH_SHORT).show()
        }
    }
}