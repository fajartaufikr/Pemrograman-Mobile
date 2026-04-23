package com.example.artspace
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceApp()
        }
    }
}

@Composable
fun ArtSpaceApp() {
    // STATE: "Ingatan" aplikasi. Dimulai dari angka 1.
    var urutanKarya by remember { mutableStateOf(1) }

    // Logika penentuan gambar dan teks berdasarkan angka 'urutanKarya'
    val gambarRes = when (urutanKarya) {
        1 -> R.drawable.bmw   // Ganti dengan nama gambar ke-1 Anda
        2 -> R.drawable.nissan    // Ganti dengan nama gambar ke-2 Anda
        else -> R.drawable.supra // Ganti dengan nama gambar ke-3 Anda
    }

    val asalNegara = when (urutanKarya) {
        1 -> "(Germany)"
        2 -> "(Japan)"
        else -> "(Japan)"
    }

    val judul = when (urutanKarya) {
        1 -> "BMW M4 (Generasi G82)"
        2 -> "NISSAN Skyline GTR (R34)"
        else -> "TOYOTA Supra (Generasi A80)"
    }

    val seniman = when (urutanKarya) {
        1 -> "Owner Michael"
        2 -> "Owner Sasuke"
        else -> "Owner Java & Putri"
    }

    // TATA LETAK UTAMA (KARDUS BESAR)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween // Memberi jarak rata antara gambar, teks, dan tombol
    ) {

        // 1. BAGIAN GAMBAR
        Surface(
            modifier = Modifier
                .weight(1f) // Mengambil sisa ruang kosong
                .fillMaxWidth(),
            shadowElevation = 8.dp // Memberi efek bayangan bingkai
        ) {
            Image(
                painter = painterResource(id = gambarRes),
                contentDescription = judul,
                modifier = Modifier.padding(32.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 2. BAGIAN PAPAN INFORMASI
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFECECEC))
                .padding(16.dp)
        ) {
            Text(
                text = judul,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(text = seniman, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(8.dp))
                // Ganti (2024) menjadi asalNegara
                Text(text = asalNegara)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 3. BAGIAN TOMBOL NAVIGASI
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Tombol Mundur
            Button(
                onClick = {
                    if (urutanKarya > 1) urutanKarya-- else urutanKarya = 3
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Tombol Maju
            Button(
                onClick = {
                    if (urutanKarya < 3) urutanKarya++ else urutanKarya = 1
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtSpace() {
    ArtSpaceApp()
}