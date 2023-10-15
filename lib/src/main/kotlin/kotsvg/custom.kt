package kotsvg
import kotlin.math.absoluteValue


class Arrow(
    x1: Double,
    y1: Double,
    x2: Double,
    y2: Double,
    headAtStart: Boolean = false,
    headAtEnd: Boolean = true,
    headSize: Double = 10.0,
    lineWidth: Double = 2.0,
    block: Arrow.() -> Unit = {}
    ): Polygon(Arrow.arrowheadPoints(x1, y1, x2, y2, headSize, lineWidth, headAtStart, headAtEnd)){
        init {this.block()}


    companion object {
        private fun arrowheadPoints(
        x1: Double,
        y1: Double,
        x2: Double,
        y2: Double,
        headSize: Double,
        lineWidth: Double,
        headAtStart: Boolean,
        headAtEnd: Boolean
        ): List<Pair<Double,Double>> {

            val arrowheadBaseSlope = 0.75
            val s = arrowheadBaseSlope
            val lw: Double = (lineWidth * 0.5)
            val aw: Double = (headSize * 0.5)
            val ah: Double = (headSize * 1.25)
            val arrowhead: List<Pair<Double,Double>> = listOf(

            Pair((-lw), (s*lw + 0.7*ah)),
                Pair((-aw),ah),
                Pair(0.0,0.0),
                Pair(aw,ah),
                Pair(lw, s*lw + 0.7*ah)
                )

            val arrowTail = listOf(Pair(-lw, 0.0), Pair(lw, 0.0))

            val angle = Math.atan2((y2-y1),(x2-x1))

            fun rotate(vector: Pair<Double, Double>, theta: Double): Pair<Double, Double> {
                val (x, y) = vector
                return Pair(
                    x * Math.cos(theta) - y * Math.sin(theta),
                    x * Math.sin(theta) + y * Math.cos(theta)
                    )
            }

            fun translate(vector: Pair<Double, Double>, xOffset: Double, yOffset: Double): Pair<Double, Double> {
                val (x, y) = vector
                return Pair(x + xOffset, y + yOffset)
            }

            var end = if (headAtEnd) arrowhead else arrowTail
            var start = if (headAtStart) arrowhead else arrowTail

            end = end.map{rotate(it, Math.PI/2+angle)}.map{translate(it, x2, y2)}
            start = start.map{rotate(it, -Math.PI/2+angle)}.map{translate(it, x1, y1)}

            return start + end
        }
        }
    }
