package com.example.form_viaje

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.form_viaje.ui.theme.FormViajeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormViajeTheme {
                DriverForm()
            }
        }
    }
}

@Composable
fun DriverForm() {
    var departurePoint by remember { mutableStateOf("") }
    var destinationPoint by remember { mutableStateOf("") }
    var departureTime by remember { mutableStateOf("") }
    var seatsAvailable by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Publicar un Viaje", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = departurePoint,
            onValueChange = { departurePoint = it },
            label = { Text("Punto de Partida") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = destinationPoint,
            onValueChange = { destinationPoint = it },
            label = { Text("Punto de Destino") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = departureTime,
            onValueChange = { departureTime = it },
            label = { Text("Hora de Salida") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = seatsAvailable,
            onValueChange = { seatsAvailable = it },
            label = { Text("Asientos Disponibles") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button(onClick = {
            // Aquí puedes manejar la lógica de publicación del viaje
            println("Viaje publicado: $departurePoint a $destinationPoint a las $departureTime con $seatsAvailable asientos disponibles")
        }, modifier = Modifier.padding(vertical = 8.dp)) {
            Text("Publicar Viaje")
        }
    }
}
