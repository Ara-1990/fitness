package com.the.fitness.ui
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun All_Exercises_Screen (

    viewModel: ViewModel = hiltViewModel()) {


    val ui by viewModel.ui_state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.refresh(week = 1, workout = 1)
    }


    Column (Modifier.fillMaxSize().padding(16.dp)){
        LazyColumn (verticalArrangement = Arrangement.spacedBy(12.dp)){
            items(ui.items){ex->
                AllExersizeCart(
                    name = ex.name.orEmpty(),
                    muscleGroup = ex.muscleGroup.orEmpty(),
                    imagePath = ex.imagePath
                )
            }
        }
    }
}

@Composable
private fun AllExersizeCart(
    name: String,
    muscleGroup: String,
    imagePath: String?
){

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
        }
    }
}

