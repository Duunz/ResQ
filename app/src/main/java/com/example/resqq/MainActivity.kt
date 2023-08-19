package com.example.resqq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document


private fun DocumentsContract.Document.append(s: String, password: String): Any {

}

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            // Obtener datos de los campos de texto
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Crear una conexión con el cluster de MongoDB
            val uri = MongoClientURI("mongodb+srv://DUUNZ:AVGNAVGN@<cluster>/test")
            val mongoClient = MongoClient(uri)
            val database: MongoDatabase = mongoClient.getDatabase("test")
            val collection: MongoCollection<DocumentsContract.Document> = database.getCollection("usuarios")

            // Crear un documento con los datos
            val document = DocumentsContract.Document("email", email).append("password", password)

            // Insertar el documento en la colección
            collection.insertOne(document)

            // Cerrar la conexión
            mongoClient.close()

            // Limpiar campos de texto
            emailEditText.text.clear()
            passwordEditText.text.clear()
        }
    }

        //get reference to button
        val btnLogIn = findViewById(R.id.loginBtn) as Button
        //set on click listener
        btnLogIn.setOnClickListener{
            val loginIntent = Intent(this, LoginScreen::class.java)
            startActivity(loginIntent)
        }
    }
}

class MongoCollection<T> {
    fun insertOne(document: Any) {

    }

}

class MongoClient(uri: MongoClientURI) {
    fun getDatabase(s: String): MongoDatabase {

    }

    fun close() {
        TODO("Not yet implemented")
    }

}

class MongoDatabase {
    fun getCollection(s: String): MongoCollection<DocumentsContract.Document> {

    }

}
