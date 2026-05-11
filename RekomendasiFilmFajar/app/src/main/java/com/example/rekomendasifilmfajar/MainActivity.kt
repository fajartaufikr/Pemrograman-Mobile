package com.example.rekomendasifilmfajar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.rekomendasifilmfajar.ui.theme.RekomendasiFilmFajarTheme


// ==========================================
// 1. DATA LAYER
// ==========================================

data class Film(
    val id: Int,
    val judul: String,
    val genre: String,
    val rating: String,
    val gambarRes: Int
)

object FilmRepository {
    val daftarFilm = listOf(
        Film(1, "Peaky Blinders The Immortal Man", "Fiksi Kriminal", "7.3", R.drawable.peakyblinders),
        Film(2, "Peaky Blinders Series", "Fiksi Kriminal", "8.5", R.drawable.peakyblinders2),
        Film(3, "Taxi Driver", "Drama", "8.2", R.drawable.taxidriver),
        Film(4, "The Exorcist", "Horor", "7.3", R.drawable.theexorcist),
        Film(5, "The Glory", "Drama", "8.5", R.drawable.theglory),
        Film(6, "Train To Busan", "Horor", "7.7", R.drawable.traintobusan),
        Film(7, "Train To Busan 2", "Horor", "6.7", R.drawable.traintobusan2),
        Film(8, "Kingdom Of Heaven", "Perang", "7.0", R.drawable.kingdomofheaven),
        Film(9, "Sijjin", "Horor", "5.4", R.drawable.sijjin),
        Film(10, "EXHUMA", "Horor", "7.6", R.drawable.exhuma),
    )
}

// ==========================================
// 2. MAIN ACTIVITY (Pintu Masuk Aplikasi)
// ==========================================

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RekomendasiFilmFajarTheme {
                // Memanggil UI Utama
                MovieCatalogueApp()
            }
        }
    }
}

// ==========================================
// 3. UI LAYER (Komponen & Layout)
// ==========================================

@Composable
fun MovieItemCard(film: Film) {
    // Implementasi Element UI: Card
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        // Implementasi Tata Letak: Box (untuk menumpuk teks rating di atas gambar)
        Box(modifier = Modifier.height(200.dp).fillMaxWidth()) {
            Image(
                painter = painterResource(id = film.gambarRes),
                contentDescription = film.judul,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // Rating melayang di pojok kanan atas
            Text(
                text = "⭐ ${film.rating}",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(Color.Black.copy(alpha = 0.6f))
                    .padding(4.dp),
                color = Color.White,
                fontSize = 12.sp
            )
        }
        // Implementasi Tata Letak: Column untuk teks di bawah gambar
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = film.judul, fontWeight = FontWeight.Bold, fontSize = 16.sp, maxLines = 1)
            // Implementasi Tata Letak: Row
            Row {
                Text(text = film.genre, color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCatalogueApp() {
    var searchQuery by remember { mutableStateOf("") }

    val filteredMovies = FilmRepository.daftarFilm.filter {
        it.judul.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie Fajar Taufik") },
                // nMenggunakan topAppBarColors
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        // BoxWithConstraints untuk mendeteksi landscape/portrait
        BoxWithConstraints(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            // Menggunakan maxWidth untuk menentukan jumlah kolom
            val columns = if (this.maxWidth < 600.dp) 2 else 4

            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Cari rekomendasi film...") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(columns),
                    modifier = Modifier.weight(1f)
                ) {
                    items(filteredMovies) { film ->
                        MovieItemCard(film)
                    }
                }

                Button(
                    onClick = { searchQuery = "" },
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 8.dp)
                ) {
                    Text("Clear Search")
                }
            }
        }
    }
}