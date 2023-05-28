package `in`.rithikjain.pagetear.ui.utils

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class LeftPageShape(
    private val actualSize: Size,
    private val edgeList: List<Pair<Float, Float>>,
    private val progress: Float,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val maxIterations = (edgeList.size * progress).toInt()

        val path = Path()
        path.lineTo(actualSize.width / 2, 0f)

        var lastX = actualSize.width / 2

        for (i in 0 until maxIterations) {
            path.lineTo(edgeList[i].first, edgeList[i].second)
            lastX = edgeList[i].first
        }

        path.lineTo(lastX, actualSize.height)
        path.lineTo(0f, actualSize.height)
        path.close()

        return Outline.Generic(path)
    }
}

class RightPageShape(
    private val actualSize: Size,
    private val edgeList: List<Pair<Float, Float>>,
    private val progress: Float,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val maxIterations = (edgeList.size * progress).toInt()

        val path = Path()
        path.moveTo(actualSize.width / 2, 0f)

        var lastX = actualSize.width / 2

        for (i in 0 until maxIterations) {
            path.lineTo(edgeList[i].first, edgeList[i].second)
            lastX = edgeList[i].first
        }

        path.lineTo(lastX, actualSize.height)
        path.lineTo(actualSize.width, actualSize.height)
        path.lineTo(actualSize.width, 0f)
        path.close()

        return Outline.Generic(path)
    }
}
