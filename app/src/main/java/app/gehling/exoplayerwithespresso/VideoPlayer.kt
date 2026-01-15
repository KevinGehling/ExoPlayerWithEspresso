package app.gehling.exoplayerwithespresso

import android.content.Context
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LifecycleStartEffect
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.compose.PlayerSurface
import androidx.media3.ui.compose.SURFACE_TYPE_TEXTURE_VIEW
import androidx.media3.ui.compose.state.rememberPresentationState

@Composable
fun VideoPlayer(
    modifier: Modifier = Modifier,
    videoUrl: String,
) {
    val context = LocalContext.current
    var player by remember { mutableStateOf<Player?>(null) }

    LifecycleStartEffect(Unit) {
        player = initializePlayer(context, videoUrl)
        player?.playWhenReady = true
        onStopOrDispose {
            player?.apply { release() }
            player = null
        }
    }

    val currentPlayer = player
    if (currentPlayer != null) {
        MediaPlayerScreen(
            modifier = modifier.fillMaxWidth(),
            player = currentPlayer,
        )
    } else {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White),
        )
    }
}

private fun initializePlayer(context: Context, videoUrl: String): Player =
    ExoPlayer.Builder(context).build().apply {
        setMediaItem(MediaItem.fromUri(videoUrl))
        prepare()
    }

@OptIn(UnstableApi::class)
@Composable
private fun MediaPlayerScreen(
    player: Player,
    modifier: Modifier = Modifier,
) {
    // ! Important for the crash
    val presentationState = rememberPresentationState(player)

    Box(modifier.clipToBounds()) {
        PlayerSurface(
            player = player,
            surfaceType = SURFACE_TYPE_TEXTURE_VIEW,
        )

        if (presentationState.coverSurface) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.White),
            )
        }
    }
}