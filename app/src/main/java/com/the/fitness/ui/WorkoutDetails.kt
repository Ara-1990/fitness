package com.the.fitness.ui

import androidx.compose.runtime.Composable
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.the.fitness.ui.ViewModel

@Composable
fun WorkoutDetails(
    viewModel: ViewModel = hiltViewModel(),
    week:Int, workout:Int) {

    val ui by viewModel.ui_state.collectAsState()

    LaunchedEffect(week, workout) {
        viewModel.refresh(week, workout)
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {

        LazyColumn (verticalArrangement = Arrangement.spacedBy(12.dp)){
            items(ui.items){ex->
                com.the.fitness.ui.WorkoutCart(
                    name = ex.name.orEmpty(),
                    muscleGroup = ex.muscleGroup.orEmpty(),
                    imagePath = ex.imagePath,
                    description = ex.description.orEmpty(),
                    weight = ex.weight,
                    number = ex.numbers,
                    sets = ex.sets
                )
            }
        }
    }


}

@Composable
private fun WorkoutCart(
    name: String,
    muscleGroup: String,
    imagePath: String?,
    description:String,
    weight: String?,
    number: String?,
    sets:String?

){

    var expanded by remember { mutableStateOf(false) }


    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge
    ){
        Column(Modifier.padding(16.dp)) {

            imagePath?.let {
                val painter = rememberAsyncImagePainter(Uri.parse(it))
                Image(
                    painter = painter,
                    contentDescription = name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Text(name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(muscleGroup, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, maxLines = 1, overflow = TextOverflow.Ellipsis)

            Spacer(modifier = Modifier.height(8.dp))
            Text("Weight: ${weight.orEmpty()}", style = MaterialTheme.typography.bodyMedium)
            Text("Number: ${number.orEmpty()}", style = MaterialTheme.typography.bodyMedium)
            Text("Sets: ${sets.orEmpty()}", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(8.dp))

            Text(description, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold,
                maxLines = if(expanded) Int.MAX_VALUE else 2, overflow = TextOverflow.Ellipsis)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded  }
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.End

            ) {
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
        }
    }
}