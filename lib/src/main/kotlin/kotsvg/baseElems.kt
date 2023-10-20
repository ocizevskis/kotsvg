package kotsvg

abstract class Transformable<T : Transformable<T>>() : SVGElement() {
    val transforms: MutableMap<String, String> = mutableMapOf()

    fun translate(
        x: Number,
        y: Number,
    ): T {
        this.transforms["translate"] = "$x, $y"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun translate(x: Number): T {
        this.transforms["translate"] = "$x"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun scale(
        x: Number,
        y: Number,
    ): T {
        this.transforms["scale"] = "$x, $y"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun scale(x: Number): T {
        this.transforms["scale"] = "$x"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun rotate(
        angle: Number,
        x: Number,
        y: Number,
    ): T {
        this.transforms["rotate"] = "$angle, $x, $y"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun rotate(angle: Number): T {
        this.transforms["rotate"] = "$angle"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun skewX(angle: Number): T {
        this.transforms["skewX"] = "$angle"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun skewY(angle: Number): T {
        this.transforms["skewY"] = "$angle"
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun render_transforms(): String {
        if (transforms.isEmpty()) return ""

        var output = "transform=\""
        for ((key, value) in transforms) {
            output += "$key($value) "
        }
        output = output.dropLast(n = 1) + "\""
        return output
    }

    override fun render_css_attributes(): String {
        var output = super.render_css_attributes()
        val transforms = this.render_transforms()
        output += if (transforms == "") "" else " $transforms"
        return output
    }
}

abstract class SVGElement : Core {
    val attributes: MutableMap<String, String?> = mutableMapOf()
    val geometry_params: MutableMap<String, String> = mutableMapOf()
    val children: MutableList<SVGElement> = mutableListOf()

    override var id: String? by this.attributes
    override var xmlns: String? by this.attributes
    override var tab_index: String? by this.attributes
    override var style: String? by this.attributes
    override var cls: String? by this.attributes
    abstract val name: String

    protected open fun render_css_attributes(): String {
        var output = ""
        attributes.toSortedMap().forEach({ (key, value) ->
            val sanitised_key = key.replace("_", "-")
            output += "$sanitised_key=\"$value\" "
        })
        return output.dropLast(n = 1)
    }

    fun add(vararg element: SVGElement) {
        element.forEach { this.children.add(it) }
    }

    fun remove(id: String) {
        this.children.removeIf { it.id == id }
    }

    open fun render_body(): String {
        val properties = this.render_properties()

        return properties
    }

    override fun toString(): String {
        val body = this.render_body()
        val children = this.render_children()
        val attributes = this.render_css_attributes()
        var output = "<$name"
        output += " $body"
        output += if (attributes == "") "" else " $attributes"
        output += if (children == "") "/>" else ">$children\n</$name>"

        return output
    }

    protected fun render_children(): String {
        var body = ""
        for (child in children) {
            body += "\n$child"
        }

        return body
    }

    protected fun render_properties(): String {
        var output = ""
        for ((key, value) in geometry_params) {
            output += "$key=\"$value\" "
        }
        return output.dropLast(1)
    }
}
