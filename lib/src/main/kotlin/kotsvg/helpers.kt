package kotsvg

class PathBuilder() {
    private var pathData = ""

    fun moveTo(x: String, y: String, absolute: Boolean = true): PathBuilder {
        val command = if (absolute) "M" else "m"
        pathData +="$command $x $y "
        return this
    }

    fun moveTo(x: Number, y: Number, absolute: Boolean = true): PathBuilder =
        this.moveTo(x.toString(), y.toString(), absolute)

    fun lineTo(x: String, y: String, absolute: Boolean = true): PathBuilder {
        val command = if (absolute) "L" else "l"
        pathData +="$command $x $y "
        return this
    }

    fun lineTo(x: Number, y: Number, absolute: Boolean = true): PathBuilder =
        this.lineTo(x.toString(), y.toString(), absolute)

    fun horizontalLineTo(x: String, absolute: Boolean = true): PathBuilder {
        val command = if (absolute) "H" else "h"
        pathData +="$command $x "
        return this
    }

    fun horizontalLineTo(x: Number, absolute: Boolean = true): PathBuilder =
        this.horizontalLineTo(x.toString(), absolute)


    fun verticalLineTo(y: String, absolute: Boolean = true): PathBuilder {
        val command = if (absolute) "V" else "v"
        pathData +="$command $y "
        return this
    }

    fun verticalLineTo(y: Number, absolute: Boolean = true): PathBuilder =
        this.verticalLineTo(y.toString(), absolute)

    fun cubicBezierCurve(
        x1: String, y1: String, x2: String, y2: String, x: String, y: String,
        absolute: Boolean = true
    ): PathBuilder {
        val command = if (absolute) "C" else "c"
        pathData +="$command $x1 $y1, $x2 $y2, $x $y "
        return this
    }

    fun cubicBezierCurve(
        x1: Number, y1: Number, x2: Number, y2: Number, x: Number, y: Number,
        absolute: Boolean = true
    ): PathBuilder =
        this.cubicBezierCurve(
            x1.toString(), y1.toString(), x2.toString(), y2.toString(), x.toString(), y.toString(), absolute)

    fun smoothCubicBezierCurve(
        x2: String, y2: String, x: String, y: String, absolute: Boolean = true
    ): PathBuilder {
        val command = if (absolute) "S" else "s"
        pathData +="$command $x2 $y2, $x $y "
        return this
    }

    fun smoothCubicBezierCurve(
        x2: Number, y2: Number, x: Number, y: Number, absolute: Boolean = true
    ): PathBuilder =
        this.smoothCubicBezierCurve(
            x2.toString(), y2.toString(), x.toString(), y.toString(), absolute)

    fun quadraticBezierCurve(
        x1: String, y1: String, x: String, y: String, absolute: Boolean = true
    ): PathBuilder {
        val command = if (absolute) "Q" else "q"
        pathData +="$command $x1 $y1, $x $y "
        return this
    }

    fun quadraticBezierCurve(
        x1: Number, y1: Number, x: Number, y: Number, absolute: Boolean = true
    ): PathBuilder =
        this.quadraticBezierCurve(
            x1.toString(), y1.toString(), x.toString(), y.toString(), absolute)

    fun smoothQuadraticBezierCurve(x: String, y: String, absolute: Boolean = true): PathBuilder {
        val command = if (absolute) "T" else "t"
        pathData +="$command $x $y "
        return this
    }

    fun smoothQuadraticBezierCurve(x: Number, y: Number, absolute: Boolean = true): PathBuilder =
        this.smoothQuadraticBezierCurve(x.toString(), y.toString(), absolute)

    fun ellipticalArc(
        rx: String, ry: String, xAxisRotation: String, largeArcFlag: Boolean,
        sweepFlag: Boolean, x: String, y: String, absolute: Boolean = true
    ): PathBuilder {
        val command = if (absolute) "A" else "a"
        val largeArcFlagInt = if (largeArcFlag) 1 else 0
        val sweepFlagInt = if (sweepFlag) 1 else 0
        pathData +="$command $rx $ry $xAxisRotation $largeArcFlagInt $sweepFlagInt $x $y "
        return this
    }

    fun ellipticalArc(
        rx: Number, ry: Number, xAxisRotation: Number, largeArcFlag: Boolean,
        sweepFlag: Boolean, x: Number, y: Number, absolute: Boolean = true
    ): PathBuilder =
        this.ellipticalArc(
            rx.toString(), ry.toString(), xAxisRotation.toString(), largeArcFlag, sweepFlag, x.toString(), y.toString(), absolute)

    fun closePath(): PathBuilder {
        pathData +="Z"
        return this
    }

    private fun m(x: Any, y: Any): PathBuilder =
        this.moveTo(x.toString(), y.toString(), false)

    fun m(x: Number, y: Number): PathBuilder = this.m(x, y)
    fun m(x: String, y: String): PathBuilder = this.m(x, y)


    private fun l(x: Any, y: Any): PathBuilder =
        this.lineTo(x.toString(), y.toString(), false)

    fun l(x: Number, y: Number): PathBuilder = this.l(x, y)
    fun l(x: String, y: String): PathBuilder = this.l(x, y)

    private fun h(x: Any): PathBuilder =
        this.horizontalLineTo(x.toString(), false)

    fun h(x: Number): PathBuilder = this.h(x)
    fun h(x: String): PathBuilder = this.h(x)


    private fun v(y: Any): PathBuilder =
        this.verticalLineTo(y.toString(), false)
    
    fun v(y: Number): PathBuilder = this.v(y)
    fun v(y: String): PathBuilder = this.v(y)

    private fun c(
        x1: Any, y1: Any, x2: Any, y2: Any, x: Any, y: Any): PathBuilder =
        this.cubicBezierCurve(x1.toString(), y1.toString(), x2.toString(), y2.toString(), x.toString(), y.toString(), false)

    fun c(x1: Number, y1: Number, x2: Number, y2: Number, x: Number, y: Number): PathBuilder =
        this.c(x1, y1, x2, y2, x, y)
    
    fun c(x1: String, y1: String, x2: String, y2: String, x: String, y: String): PathBuilder =
        this.c(x1, y1, x2, y2, x, y)


    private fun s(x2: Any, y2: Any, x: Any, y: Any): PathBuilder =
        this.smoothCubicBezierCurve(x2.toString(), y2.toString(), x.toString(), y.toString(), false)
    
    fun s(x2: Number, y2: Number, x: Number, y: Number): PathBuilder = this.s(x2, y2, x, y)
    fun s(x2: String, y2: String, x: String, y: String): PathBuilder = this.s(x2, y2, x, y)
    
    private fun q(x1: Any, y1: Any, x: Any, y: Any): PathBuilder =
        this.quadraticBezierCurve(x1.toString(), y1.toString(), x.toString(), y.toString(), false)

    fun q(x1: Number, y1: Number, x: Number, y: Number): PathBuilder = this.q(x1, y1, x, y)
    fun q(x1: String, y1: String, x: String, y: String): PathBuilder = this.q(x1, y1, x, y)

        
    override fun toString(): String {
        return pathData
    }
}