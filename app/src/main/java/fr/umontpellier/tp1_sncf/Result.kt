package fr.umontpellier.tp1_sncf

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

data class Itinerary(
    val departureStation: String,
    val arrivalStation: String,
    val departureTime: String
)

@Composable
fun ListResult(itineraries: List<Itinerary>) {
    LazyColumn(modifier = Modifier.padding(horizontal = 4.dp)) {
        items(itineraries) { itinerary ->
            Result(itinerary = itinerary)
        }
    }
}

@Composable
fun Result(itinerary: Itinerary) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(4.dp), // Ajoute une ombre à la surface
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Sharp.LocationOn,
                contentDescription = "Train Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "Départ: ${itinerary.departureStation}")
                Text(text = "Arrivé: ${itinerary.arrivalStation}")
                Text(text = "Heure du départ: ${itinerary.departureTime}")
            }
        }
    }
}
