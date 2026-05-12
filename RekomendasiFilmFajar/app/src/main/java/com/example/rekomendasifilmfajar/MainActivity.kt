package com.example.rekomendasifilmfajar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rekomendasifilmfajar.ui.theme.RekomendasiFilmFajarTheme

// ==========================================
// 1. DATA LAYER (Model & Repository)
// ==========================================

data class Film(
    val id: Int,
    val judul: String,
    val genre: String,
    val rating: String,
    val gambarRes: Int,
    val deskripsi: String
)

object FilmRepository {
    val daftarFilm = listOf(
        Film(1, "Peaky Blinders The Immortal Man", "Fiksi Kriminal", "7.3", R.drawable.peakyblinders, "Peaky Blinders: The Immortal Man (2026) adalah film drama kriminal Inggris yang menjadi penutup epik dari serial Peaky Blinders, disutradarai Tom Harper dan ditulis Steven Knight. Berlatar era Perang Dunia II, film ini mengikuti Tommy Shelby (Cillian Murphy) yang kembali dari pengasingan untuk menghadapi ancaman Nazi, melindungi keluarganya, dan menyelesaikan konflik masa lalu di Birmingham."),
        Film(2, "Peaky Blinders Series", "Fiksi Kriminal", "7.3", R.drawable.peakyblinders, "Peaky Blinders adalah serial drama kriminal epik Inggris yang berlatar di Birmingham pasca-Perang Dunia I, mengikuti sepak terjang geng keluarga kriminal Shelby yang dipimpin oleh Thomas Shelby (Cillian Murphy) yang ambisius. Serial ini terkenal dengan nuansa stylish, kekerasan brutal, serta intrik politik dan bisnis, berfokus pada upaya Shelby melegalkan bisnis mereka sambil menguasai dunia bawah tanah."),
        Film(3, "Taxi Driver", "Drama", "8.2", R.drawable.taxidriver, "Taxi Driver (2021) adalah drama Korea aksi-kriminal populer tentang layanan taksi rahasia, Rainbow Taxi, yang membalaskan dendam korban ketidakadilan hukum. Dipimpin mantan tentara khusus Kim Do-ki (Lee Je-hoon), tim ini menegakkan keadilan bagi mereka yang diabaikan hukum, menghadirkan aksi menegangkan, emosional, dan balas dendam yang intens."),
        Film(4, "The Exorcist", "Horor", "7.3", R.drawable.theexorcist, "The Exorcist: Believer (2023) adalah film horor supernatural yang berfungsi sebagai sekuel langsung dari film klasik The Exorcist (1973), disutradarai oleh David Gordon Green. Film ini mengisahkan Victor Fielding yang berjuang menyelamatkan putrinya dan teman sekolahnya yang kerasukan setan setelah menghilang di hutan."),
        Film(5, "The Glory", "Drama", "8.5", R.drawable.theglory, "The Glory adalah serial thriller psikologis Netflix (2022-2023) garapan penulis Kim Eun-sook yang mengisahkan balas dendam dingin Moon Dong-eun (Song Hye-kyo) terhadap pelaku perundungan brutal masa SMA-nya. Bergenre balas dendam, drama 16 episode ini menyoroti luka mendalam korban serta skema terstruktur untuk menghancurkan hidup para perundung."),
        Film(6, "Train To Busan", "Horor", "7.7", R.drawable.traintobusan, "Cerita berfokus pada Seok-woo (Gong Yoo), seorang manajer investasi yang gila kerja, dan putrinya, Su-an, yang menaiki kereta cepat KTX dari Seoul menuju Busan. Perjalanan yang seharusnya singkat berubah menjadi mimpi buruk ketika wabah virus zombie tiba-tiba meledak di seluruh negeri."),
        Film(7, "Train To Busan 2", "Horor", "6.7", R.drawable.traintobusan2, "Train to Busan Presents: Peninsula (2020) adalah film aksi-horor pasca-apokaliptik sekuel mandiri dari Train to Busan, berlatar empat tahun setelah wabah zombie menghancurkan Korea Selatan. Cerita berfokus pada mantan tentara yang kembali ke semenanjung yang terisolasi untuk mengambil truk uang, terjebak di antara zombie dan milisi brutal."),
        Film(8, "Kingdom Of Heaven", "Perang", "7.0", R.drawable.kingdomofheaven, "Kingdom of Heaven (2005) adalah film epik sejarah arahan sutradara Ridley Scott yang berlatar belakang Perang Salib abad ke-12. Film ini mengisahkan Balian (Orlando Bloom), pandai besi yang bertransformasi menjadi ksatria pelindung Yerusalem, memperjuangkan perdamaian dan toleransi di tengah konflik brutal perebutan kota suci antara pasukan Kristen dan Muslim."),
        Film(9, "Sijjin", "Horor", "5.4", R.drawable.sijjin, "Sijjin (2023) adalah film horor Indonesia arahan sutradara Hadrah Daeng Ratu yang diadaptasi dari film horor Turki populer, Siccin (2014). Film ini mengisahkan obsesi terlarang Irma (Anggika Bölsterli) yang menggunakan santet selama lima malam untuk menghancurkan istri dan anak sepupunya, Galang (Ibrahim Risyad)."),
        Film(10, "EXHUMA", "Horor", "7.6", R.drawable.exhuma, "Exhuma (2024) adalah film horor okultisme Korea Selatan tentang empat orang—dua dukun, ahli feng shui, dan pengurus jenazah—yang menggali kuburan leluhur terkutuk di desa terpencil untuk menyelamatkan keluarga kaya dari gangguan supranatural. Penggalian ini mengungkap rahasia kelam, sejarah penjajahan Jepang, dan iblis.")
    )
}

// ==========================================
// 2. MAIN ACTIVITY
// ==========================================

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RekomendasiFilmFajarTheme {
                MovieCatalogueApp()
            }
        }
    }
}

// ==========================================
// 3. UI LAYER (Logic & Screens)
// ==========================================

@Composable
fun MovieCatalogueApp() {
    // State untuk Navigasi: Menentukan film mana yang sedang dilihat detailnya
    var selectedFilm by remember { mutableStateOf<Film?>(null) }

    if (selectedFilm == null) {
        // Layar Utama (Daftar Film)
        MainListScreen(onFilmClick = { selectedFilm = it })
    } else {
        // Layar Detail
        MovieDetailScreen(film = selectedFilm!!, onBack = { selectedFilm = null })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainListScreen(onFilmClick: (Film) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredMovies = FilmRepository.daftarFilm.filter {
        it.judul.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie Fajar Taufik") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Cari rekomendasi film...") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // LIST VIEW menggunakan LazyColumn
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(filteredMovies) { film ->
                    MovieItemCard(film = film, onClick = { onFilmClick(film) })
                }
            }
        }
    }
}

@Composable
fun MovieItemCard(film: Film, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() }, // Navigasi ke detail saat diklik
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = film.gambarRes),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = film.judul, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = film.genre, color = Color.Gray, fontSize = 12.sp)
                Text(text = "⭐ ${film.rating}", fontSize = 12.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(film: Film, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Film") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()) // Deskripsi panjang bisa di-scroll
        ) {
            Image(
                painter = painterResource(id = film.gambarRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = film.judul, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Genre: ${film.genre}", color = Color.Gray)
            Text(text = "Rating: ⭐ ${film.rating}", fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Sinopsis:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = film.deskripsi,
                textAlign = TextAlign.Justify,
                lineHeight = 22.sp
            )
        }
    }
}