
package com.example.cityslideshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CityListApp()
            }
        }
    }
}

@Composable
fun CityListApp() {
    val cities = listOf(
        City("New York City", "United States", R.drawable.newyork),
        City("Amman", "Jordan", R.drawable.amman),
        City("Dubai", "United Arab Emirates", R.drawable.dubai),
        City("Tokyo", "Japan", R.drawable.tokyo),
        City("Paris", "France", R.drawable.paris),
        City("London", "United Kingdom", R.drawable.london),
        City("Rome", "Italy", R.drawable.rome),
        City("Istanbul", "Turkey", R.drawable.istanbul),
        City("Sydney", "Australia", R.drawable.sydney),
        City("Cairo", "Egypt", R.drawable.cairo)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Cities Around the World",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        items(cities) { city ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = city.image),
                        contentDescription = city.name,
                        modifier = Modifier
                            .width(120.dp)
                            .height(100.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = city.name,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = city.country,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}
