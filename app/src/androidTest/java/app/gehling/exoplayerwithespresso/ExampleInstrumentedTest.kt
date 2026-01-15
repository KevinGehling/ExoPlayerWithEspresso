package app.gehling.exoplayerwithespresso

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<Main2Activity>()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun exampleTest() {
        composeTestRule.onNodeWithText("Launch Second Activity").performClick()

        composeTestRule.waitUntilExactlyOneExists(hasText("ExoPlayer"))
    }
}