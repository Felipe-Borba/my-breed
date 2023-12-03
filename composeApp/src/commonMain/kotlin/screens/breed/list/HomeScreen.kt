package screens.breed.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val name by homeViewModel.name.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Greet Me!",
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = name,
            maxLines = 1,
            label = { Text(text = "Enter your name") },
            onValueChange = {
                homeViewModel.setName(it)
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                homeViewModel.toDetailsScreen(name)
            }
        ) {
            Text(text = "GO!")
        }
    }
}