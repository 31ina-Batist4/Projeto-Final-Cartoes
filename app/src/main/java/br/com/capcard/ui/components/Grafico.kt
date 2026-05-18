package br.com.capcard.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Branco

@Composable
fun Grafico(values: List<Float>) {

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {

        val max = values.maxOrNull() ?: 0f
        val min = values.minOrNull() ?: 0f
        val range = max - min

        val stepX = size.width / (values.size - 1)

        val points = values.mapIndexed { index, v ->
            val x = index * stepX
            val y = size.height - ((v - min) / range * size.height)
            Offset(x, y)
        }

        val path = Path().apply {
            moveTo(points.first().x, points.first().y)
            points.drop(1).forEach {
                lineTo(it.x, it.y)
            }
        }

        drawPath(
            path = path,
            color = AzulMedio,
            style = Stroke(width = 4f)
        )

        points.forEach {
            drawCircle(AzulMedio, 6f, it)
            drawCircle(Branco, 3f, it)
        }
    }
}