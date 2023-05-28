package `in`.rithikjain.pagetear.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import `in`.rithikjain.pagetear.ui.utils.LeftPageShape
import `in`.rithikjain.pagetear.ui.utils.RightPageShape
import `in`.rithikjain.pagetear.ui.utils.dpToPx
import `in`.rithikjain.pagetear.ui.utils.generatePageEdges

@Composable
fun PageTear(modifier: Modifier = Modifier, progress: Float, content: @Composable () -> Unit) {
    BoxWithConstraints(modifier) {

        val width = maxWidth.dpToPx()
        val height = maxHeight.dpToPx()

        val size by remember {
            mutableStateOf(Size(width, height))
        }

        val edgeList by remember {
            mutableStateOf(generatePageEdges(size))
        }

        // left page content
        Box(
            Modifier
                .graphicsLayer {
                    transformOrigin = TransformOrigin(0.5f, progress)
                    rotationX = 5f * progress
                    rotationZ = -5f * progress
                }
                .fillMaxSize()
                .clip(LeftPageShape(size, edgeList, progress))
        ) {
            content()
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.6f * progress),
                                Color.Transparent
                            ),
                        )
                    )
            )
        }

        // right page content
        Box(
            Modifier
                .graphicsLayer {
                    transformOrigin = TransformOrigin(0.5f, progress)
                    rotationX = -5f * progress
                    rotationZ = 5f * progress
                }
                .fillMaxSize()
                .clip(RightPageShape(size, edgeList, progress))
        ) {
            content()
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.6f * progress),
                                Color.Transparent
                            ),
                        )
                    )
            )
        }
    }
}
