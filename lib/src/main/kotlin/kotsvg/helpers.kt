package kotsvg

class PathBuilder() {
    private var pathData = ""

    fun moveTo(
        x: Number,
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "M" else "m"
        pathData += "$command $x $y "
        return this
    }

    fun lineTo(
        x: Number,
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "L" else "l"
        pathData += "$command $x $y "
        return this
    }

    fun horizontalLineTo(
        x: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "H" else "h"
        pathData += "$command $x "
        return this
    }

    fun verticalLineTo(
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "V" else "v"
        pathData += "$command $y "
        return this
    }

    fun cubicBezierCurve(
        x1: Number,
        y1: Number,
        x2: Number,
        y2: Number,
        x: Number,
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "C" else "c"
        pathData += "$command $x1 $y1, $x2 $y2, $x $y "
        return this
    }

    fun smoothCubicBezierCurve(
        x2: Number,
        y2: Number,
        x: Number,
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "S" else "s"
        pathData += "$command $x2 $y2, $x $y "
        return this
    }

    fun quadraticBezierCurve(
        x1: Number,
        y1: Number,
        x: Number,
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "Q" else "q"
        pathData += "$command $x1 $y1, $x $y "
        return this
    }

    fun smoothQuadraticBezierCurve(
        x: Number,
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "T" else "t"
        pathData += "$command $x $y "
        return this
    }

    fun ellipticalArc(
        rx: Number,
        ry: Number,
        xAxisRotation: Number,
        largeArcFlag: Boolean,
        sweepFlag: Boolean,
        x: Number,
        y: Number,
        absolute: Boolean = true,
    ): PathBuilder {
        val command = if (absolute) "A" else "a"
        val largeArcFlagInt = if (largeArcFlag) 1 else 0
        val sweepFlagInt = if (sweepFlag) 1 else 0
        pathData += "$command $rx $ry $xAxisRotation $largeArcFlagInt $sweepFlagInt $x $y "
        return this
    }

    fun closePath(): PathBuilder {
        pathData += "Z"
        return this
    }

    private fun m(
        x: Number,
        y: Number,
    ): PathBuilder = this.moveTo(x, y, false)

    private fun l(
        x: Number,
        y: Number,
    ): PathBuilder = this.lineTo(x, y, false)

    private fun h(x: Number): PathBuilder = this.horizontalLineTo(x, false)

    private fun v(y: Number): PathBuilder = this.verticalLineTo(y, false)

    private fun c(
        x1: Number,
        y1: Number,
        x2: Number,
        y2: Number,
        x: Number,
        y: Number,
    ): PathBuilder = this.cubicBezierCurve(x1, y1, x2, y2, x, y, false)

    private fun s(
        x2: Number,
        y2: Number,
        x: Number,
        y: Number,
    ): PathBuilder = this.smoothCubicBezierCurve(x2, y2, x, y, false)

    private fun q(
        x1: Number,
        y1: Number,
        x: Number,
        y: Number,
    ): PathBuilder = this.quadraticBezierCurve(x1, y1, x, y, false)

    override fun toString(): String {
        return pathData
    }
}
