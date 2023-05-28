package `in`.rithikjain.pagetear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import `in`.rithikjain.pagetear.ui.components.ContactCard
import `in`.rithikjain.pagetear.ui.components.PageTear
import `in`.rithikjain.pagetear.ui.theme.PageTearTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PageTearTheme(darkTheme = false) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                ) {
                    Column(Modifier.fillMaxSize()) {

                        var progress by remember {
                            mutableStateOf(0f)
                        }

                        Spacer(modifier = Modifier.height(48.dp))

                        PageTear(
                            Modifier
                                .padding(horizontal = 32.dp)
                                .fillMaxWidth()
                                .height(200.dp),
                            progress,
                        ) {
                            AsyncImage(
                                model = "https://i.pinimg.com/originals/e4/ab/33/e4ab3323eec64181a8ed4a2b95df6ddf.jpg",
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        PageTear(
                            Modifier
                                .padding(horizontal = 32.dp)
                                .fillMaxWidth(0.5f)
                                .height(200.dp),
                            progress,
                        ) {
                            ContactCard(
                                name = "Rithik Jain",
                                website = "rithikjain.in",
                                linkedUrl = "https://www.linkedin.com/in/rithik-jain-710b3a199/"
                            )
                        }

                        Box(Modifier.fillMaxSize()) {
                            Slider(
                                modifier = Modifier
                                    .padding(vertical = 56.dp, horizontal = 32.dp)
                                    .align(Alignment.BottomCenter),
                                value = progress,
                                onValueChange = { progress = it }
                            )
                        }
                    }
                }
            }
        }
    }
}
