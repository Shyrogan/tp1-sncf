package fr.umontpellier.tp1_sncf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import fr.umontpellier.tp1_sncf.ui.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isSearching by mutableStateOf(true)
        var d by mutableStateOf("")
        var a by mutableStateOf("")

        setContent {
            Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    if (isSearching) Research(onResearch = { departure, arrival ->
                        isSearching = false
                        d = departure
                        a = arrival
                    })
                    else ListResult(
                        listOf(
                            Itinerary(d, a, "10h27"),
                            Itinerary(d, a, "13h42")
                        )
                    )
                }
            }
        }
    }
}
