package kotsvg

abstract class TransformableShape<T: TransformableShape<T>>: ShapeElement, Transformable<T>(){
    override var clip_path: String? by attributes
    override var clip_rule: String? by attributes
    override var color_interpolation: String? by attributes
    override var color_rendering: String? by attributes
    override var display: String? by attributes
    override var mask: String? by attributes
    override var opacity: String? by attributes
    override var pointer_events: String? by attributes
    override var fill: String? by attributes
    override var fill_rule: String? by attributes
    override var fill_opacity: String? by attributes
    override var stroke: String? by attributes
    override var stroke_opacity: String? by attributes
    override var stroke_width: String? by attributes
    override var stroke_dasharray: String? by attributes
    override var stroke_dashoffset: String? by attributes
    override var stroke_linecap: String? by attributes
    override var stroke_linejoin: String? by attributes
    override var stroke_miterlimit: String? by attributes
    override var marker: String? by attributes
    override var marker_start: String? by attributes
    override var marker_mid: String? by attributes
    override var marker_end: String? by attributes
    override var paint_order: String? by attributes
    override var shape_rendering: String? by attributes


    inline operator fun <reified R : T> invoke(block: R.() -> Unit = {}): R {
        val instance = this as R
        instance.block()
        return instance
    }
}

class Line : TransformableShape<Line> {
    override val name = "line"

    constructor(x1: String, y1: String, x2: String, y2: String, block: Line.() -> Unit = {}) : super() {
        setGeometryParams(x1, y1, x2, y2)
        this.block()
    }

    constructor(x1: Number, y1: Number, x2: Number, y2: Number, block: Line.() -> Unit = {}) : super() {
        setGeometryParams(
            x1.toString(),
            y1.toString(),
            x2.toString(),
            y2.toString()
            )
        this.block()
    }

    private fun setGeometryParams(x1: String, y1: String, x2: String, y2: String) {
        this.geometry_params["x1"] = x1
        this.geometry_params["y1"] = y1
        this.geometry_params["x2"] = x2
        this.geometry_params["y2"] = y2
    }
}

class Circle : TransformableShape<Circle> {
    override val name = "circle"

    constructor(cx: String, cy: String, r: String, block: Circle.() -> Unit = {}) : super() {
        setGeometryParams(cx, cy, r)
        this.block()
    }

    constructor(cx: Number, cy: Number, r: Number, block: Circle.() -> Unit = {}) : super() {
        setGeometryParams(
            cx.toString(),
            cy.toString(),
            r.toString()
            )
        this.block()
    }

    private fun setGeometryParams(cx: String, cy: String, r: String) {
        this.geometry_params["cx"] = cx
        this.geometry_params["cy"] = cy
        this.geometry_params["r"] = r
    }
}

class Ellipse : TransformableShape<Ellipse> {
    override val name = "ellipse"

    constructor(cx: String, cy: String, rx: String, ry: String, block: Ellipse.() -> Unit = {}) : super() {
        setGeometryParams(cx, cy, rx, ry)
        this.block()
    }

    constructor(cx: Number, cy: Number, rx: Number, ry: Number, block: Ellipse.() -> Unit = {}) : super() {
        setGeometryParams(
            cx.toString(),
            cy.toString(),
            rx.toString(),
            ry.toString()
            )
        this.block()
    }

    private fun setGeometryParams(cx: String, cy: String, rx: String, ry: String) {
        this.geometry_params["cx"] = cx
        this.geometry_params["cy"] = cy
        this.geometry_params["rx"] = rx
        this.geometry_params["ry"] = ry
    }
}
class Polyline : TransformableShape<Polyline> {
    override val name = "polyline"

    constructor(points: List<Pair<String, String>>, block: Polyline.() -> Unit = {}) : super() {
        setGeometryParams(points)
        this.block()
    }

    constructor(points: List<Pair<Number, Number>>, block: Polyline.() -> Unit = {}) : super() {
        setGeometryParams(
            points.map { it.first.toString() to it.second.toString() }
            )
        this.block()
    }

    private fun setGeometryParams(points: List<Pair<String, String>>) {
        val pointsString = points.joinToString(" ") { "${it.first},${it.second}" }
        this.geometry_params["points"] = pointsString
    }
}

open class Polygon : TransformableShape<Polygon> {
    override val name = "polygon"

    constructor(points: List<Pair<String, String>>, block: Polygon.() -> Unit = {}) : super() {
        setGeometryParams(points)
        this.block()
    }
    
    constructor(points: List<Pair<Number, Number>>, block: Polygon.() -> Unit = {}) : super() {
        setGeometryParams(
            points.map { it.first.toString() to it.second.toString() }
            )
        this.block()
    }

    private fun setGeometryParams(points: List<Pair<String, String>>) {
        val pointsString = points.joinToString(" ") { "${it.first},${it.second}" }
        this.geometry_params["points"] = pointsString
    }
}


class Rect: TransformableShape<Rect> {
    override val name = "rect"

    constructor
    (x: String, y: String, width: String, height: String, rx: String, ry: String, block: Rect.() -> Unit = {}): super() {
        this.set_geometry_params(x, y, width, height, rx, ry)
        this.block()
    }

    constructor
    (x: Number, y: Number, width: Number, height: Number, rx: Number, ry: Number, block: Rect.() -> Unit = {}): super() {
        this.set_geometry_params(
            x.toString(),
            y.toString(),
            width.toString(),
            height.toString(),
            rx.toString(),ry.toString()
            )
        this.block()
    }

    constructor(x: String, y: String, width: String, height: String, block: Rect.() -> Unit = {}): super() {
        this.set_geometry_params(x, y, width, height)
        this.block()
    }

    constructor(x: Number, y: Number, width: Number, height: Number, block: Rect.() -> Unit = {}): super() {
        this.set_geometry_params(
            x.toString(),
            y.toString(),
            width.toString(),
            height.toString()
            )
        this.block()
    }

    private fun set_geometry_params(
        x: String,
        y: String,
        width: String,
        height: String,
        rx: String? = null,
        ry: String? = null
        ){
        this.geometry_params["x"] = x
        this.geometry_params["y"] = y
        this.geometry_params["width"] = width
        this.geometry_params["height"] = height
        if (rx != null) this.geometry_params["rx"] = rx
        if (ry != null) this.geometry_params["ry"] = ry
    }
}

class Path: TransformableShape<Path> {
    override val name = "path"
    constructor(d: String, block: Path.() -> Unit = {}): super() {
        this.geometry_params["d"] = d
        this.block()
    }

    constructor(d: PathBuilder, block: Path.() -> Unit = {}): super() {
        this.geometry_params["d"] = d.toString()
        this.block()
    }
}
