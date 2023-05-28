package `in`.rithikjain.pagetear.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import java.util.Random
import kotlin.math.tan

fun generatePageEdges(size: Size): List<Pair<Float, Float>> {
    val randomGen = Random()

    val distanceRange = (2..8)
    val angleRange = (-30..40)

    val edgeList: MutableList<Pair<Float, Float>> = mutableListOf()

    var x = size.width / 2
    var y = 0f

    while (y <= size.height) {
        val distance = distanceRange.getRandomInt(randomGen)
        val angle = angleRange.getRandomInt(randomGen).radians

        x += (distance * tan(angle)).toFloat()
        y += distance
        edgeList += Pair(x, y)
    }

    return edgeList
}

val Int.radians
    get() = Math.toRadians(this.toDouble())

@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }

fun IntRange.getRandomInt(random: Random) = random.nextInt((endInclusive + 1) - start) + start
