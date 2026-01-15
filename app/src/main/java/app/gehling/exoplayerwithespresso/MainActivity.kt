package app.gehling.exoplayerwithespresso

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .background(Color.Red)
                        .fillMaxSize(),
                ) {
                    Button(onClick = { launchSecondActivity() }) {
                        Text(text = "Launch Second Activity")
                    }
                }
            }
        }
    }

    private fun launchSecondActivity() {
        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        startActivity(intent)
    }
}