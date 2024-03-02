package fr.umontpellier.tp1_sncf

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun Research(onResearch: (departure: String, arrival: String) -> Unit) {
    var departure by remember { mutableStateOf(TextFieldValue()) }
    var arrival by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = departure,
            onValueChange = { departure = it },
            label = { Text("Departure Station") },
            leadingIcon = { Icon(Icons.Sharp.Place, contentDescription = "Departure Icon") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = arrival,
            onValueChange = { arrival = it },
            label = { Text("Arrival Station") },
            leadingIcon = { Icon(Icons.Sharp.Place, contentDescription = "Arrival Icon") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            content = {
                Text("Rechercher")
            },
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onResearch(departure.text, arrival.text)
            }
        )
    }
}
