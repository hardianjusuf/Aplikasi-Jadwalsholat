package com.d121211041.jadwalsholat.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d121211041.jadwalsholat.R
import com.d121211041.jadwalsholat.ui.activities.detail.DetailActivity
import com.d121211041.jadwalsholat.ui.theme.D121211041_TUGASAKHIRMOBILETheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211041.jadwalsholat.data.models.Jadwal

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211041_TUGASAKHIRMOBILETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    Column {
                        CenterAlignedTopAppBar(
                            modifier = Modifier.background(Color.Green),
                            title = {
                                Text(
                                    text = "Jadwal Sholat",
                                    fontWeight = FontWeight.SemiBold,
                                )
                            }
                        )

                        Image(
                            painter = painterResource(id = R.drawable.masjid_agung_kediri),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp) // Sesuaikan dengan tinggi yang diinginkan
                                .clip(RoundedCornerShape(8.dp))
                                .widthIn(max = LocalConfiguration.current.screenWidthDp.dp)
                        )

                        Text(
                            text = "Jadwal Sholat untuk wilayah Kabupaten Kediri, Daerah Jawa Timur. Aplikasi mobile yang menyediakan informasi mengenai waktu sholat harian. Aplikasi ini menampilkan jadwal waktu Subuh, Dzuhur, Ashar, Maghrib, dan Isya serta waktu penanda lainnya.",
                            modifier = Modifier
                                .padding(5.dp)
                                .padding(8.dp),
                            textAlign = TextAlign.Justify,
                            fontSize = 12.sp
                        )

                        val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                        ListJadwalsholatScreen(mainViewModel.mainUiState)
                    }

                }
            }
        }
    }

    @Composable
    private fun ListJadwalsholatScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Loading -> Text(text = "Sedang Loading", fontSize = 16.sp)
            is MainUiState.Error -> Text(text = "Terjadi Error", fontSize = 16.sp)
            is MainUiState.Success -> JadwalsholatList(mainUiState.jadwalsholat)
        }
    }

    @Composable
    fun JadwalsholatList(jadwalsholat: List<Jadwal?>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(jadwalsholat) { jadwal ->
                if (jadwal != null) {
                    JadwalSholatItem(jadwal = jadwal)
                }
            }
        }
    }

    @Composable
    fun JadwalSholatItem(jadwal: Jadwal) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .clickable {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("LISTJADWAL", jadwal)
                    startActivity(intent)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Show details for each prayer time
                Spacer(modifier = Modifier.height(8.dp))

                // Jadwal Sholat
                Text(
                    text = "${jadwal.tanggal}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Subuh: ${jadwal.subuh}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Dzuhur: ${jadwal.dzuhur}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Ashar: ${jadwal.ashar}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Maghrib: ${jadwal.maghrib}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Isya: ${jadwal.isya}",
                    style = MaterialTheme.typography.bodySmall
                )
                // Add other prayer times as needed

                // Other details like rating, genre, etc. can be added here
            }
        }
    }
}
