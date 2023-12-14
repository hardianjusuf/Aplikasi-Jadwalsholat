package com.d121211041.jadwalsholat.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d121211041.jadwalsholat.data.models.Jadwal
import com.d121211041.jadwalsholat.R
import com.d121211041.jadwalsholat.ui.theme.D121211041_TUGASAKHIRMOBILETheme

class DetailActivity : ComponentActivity() {

    private var selectedJadwal: Jadwal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedJadwal = intent.getParcelableExtra("LISTJADWAL")
        setContent {
            D121211041_TUGASAKHIRMOBILETheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    fun DetailScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Jadwal Details
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${selectedJadwal?.tanggal}",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp))

            Image(
                painter = painterResource(id = R.drawable.masjid_agung_kediri),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .widthIn(max = LocalConfiguration.current.screenWidthDp.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Imsak: ${selectedJadwal?.imsak}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))
            Text(text = "Subuh: ${selectedJadwal?.subuh}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))
            Text(text = "Dhuha: ${selectedJadwal?.dhuha}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))
            Text(text = "Dzuhur: ${selectedJadwal?.dzuhur}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))
            Text(text = "Ashar: ${selectedJadwal?.ashar}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))
            Text(text = "Maghrib: ${selectedJadwal?.maghrib}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))
            Text(text = "Isya: ${selectedJadwal?.isya}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))
            Text(text = "Terbit: ${selectedJadwal?.terbit}", fontSize = 18.sp, lineHeight = 24.sp, modifier = Modifier .padding(16.dp).padding(2.dp))

        }
    }

}
