package app.gehling.exoplayerwithespresso

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SingleActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<PlayerActivity>()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun exampleTest() {
        composeTestRule.waitUntilExactlyOneExists(hasText("ExoPlayer"))
    }
}