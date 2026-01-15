package app.gehling.exoplayerwithespresso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import app.gehling.exoplayerwithespresso.ui.theme.ExoPlayerWithEspressoTheme

class Main2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExoPlayerWithEspressoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Text(
                            text = "ExoPlayer",
                        )

                        VideoPlayer(
                            videoUrl = "https://storage.googleapis.com/exoplayer-test-media-0/shortform_2.mp4"
                        )
                    }
                }
            }
        }
    }
}