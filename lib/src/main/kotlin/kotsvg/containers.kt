package kotsvg

abstract class TransformableContainer<T : TransformableContainer<T>> : ContainerElement, Transformable<T>() {
    override var clip_path: String? by attributes
    override var color_interpolation: String? by attributes
    override var color_rendering: String? by attributes
    override var display: String? by attributes
    override var mask: String? by attributes
    override var pointer_events: String? by attributes

    operator fun invoke(block: TransformableContainer<T>.() -> Unit = {}): T {
        this.block()
        @Suppress("UNCHECKED_CAST")
        return this as T
    }
}

class SVG(height: Int, width: Int, block: SVG.() -> Unit = {}) : TransformableContainer<SVG>() {
    override val name = "svg"
    val width: Int = height
    val height: Int = width

    init {
        this.geometry_params["height"] = height.toString()
        this.geometry_params["width"] = width.toString()
        this.xmlns = "http://www.w3.org/2000/svg"
        this.block()
    }

    fun render(): String {
        return this.toString()
    }

    fun save(name: String) {
        val file = java.io.File(name)
        file.writeText(this.toString())
    }
}

open class Group(vararg element: SVGElement, block: Group.() -> Unit = {}) : TransformableContainer<Group>() {
    override val name = "g"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class Link(vararg element: SVGElement, block: Link.() -> Unit = {}) : TransformableContainer<Link>() {
    override val name = "a"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class ClipPath(vararg element: SVGElement, block: ClipPath.() -> Unit = {}) : TransformableContainer<ClipPath>() {
    override val name = "clipPath"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class Defs(vararg element: SVGElement, block: Defs.() -> Unit = {}) : TransformableContainer<Defs>() {
    override val name = "defs"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class Mask(vararg element: SVGElement, block: Mask.() -> Unit = {}) : TransformableContainer<Mask>() {
    override val name = "mask"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class Marker(vararg element: SVGElement, block: Marker.() -> Unit = {}) : TransformableContainer<Marker>() {
    override val name = "marker"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class Pattern(vararg element: SVGElement, block: Pattern.() -> Unit = {}) : TransformableContainer<Pattern>() {
    override val name = "pattern"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class Symbol(vararg element: SVGElement, block: Symbol.() -> Unit = {}) : TransformableContainer<Symbol>() {
    override val name = "symbol"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}

class Switch(vararg element: SVGElement, block: Switch.() -> Unit = {}) : TransformableContainer<Switch>() {
    override val name = "switch"

    init {
        element.forEach { this.add(it) }
        this.block()
    }
}
