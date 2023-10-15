package kotsvg

abstract class Transformable<T: Transformable<T>>(): SVGElement(){
    val transforms: MutableMap<String,String> = mutableMapOf()
    
    inline fun <reified R : T> translate(x: String, y: String): R {
        this.transforms["translate"] = "$x, $y"
        return this as R
    }
    
    inline fun <reified R : T> translate(x: String): R {
        this.transforms["translate"] = x
        return this as R
    }
    
    inline fun <reified R : T> scale(x: String, y: String): R {
        this.transforms["scale"] = "$x, $y"
        return this as R
    }
    
    inline fun <reified R : T> scale(x: String): R {
        this.transforms["scale"] = x
        return this as R
    }
    
    inline fun <reified R : T> rotate(angle: String, x: String, y: String): R {
        this.transforms["rotate"] = "$angle, $x, $y"
        return this as R
    }
    
    inline fun <reified R : T> rotate(angle: String): R {
        this.transforms["rotate"] = angle
        return this as R
    }
    
    inline fun <reified R : T> skewX(angle: String): R {
        this.transforms["skewX"] = angle
        return this as R
    }
    
    inline fun <reified R : T> skewY(angle: String): R {
        this.transforms["skewY"] = angle
        return this as R
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

abstract class SVGElement: Core {
    val attributes: MutableMap<String,String?> = mutableMapOf()
    val geometry_params: MutableMap<String,String> = mutableMapOf()
    val children: MutableList<SVGElement> = mutableListOf()

    override var id: String? by this.attributes
    override var xmlns: String? by this.attributes
    override var tab_index: String? by this.attributes
    override var style: String? by this.attributes
    override var cls: String? by this.attributes
    abstract val name: String


    open protected fun render_css_attributes(): String {
        var output = ""
        attributes.toSortedMap().forEach({ (key, value) ->
            val sanitised_key = key.replace("_", "-")
            output += "$sanitised_key=\"$value\" "
        })
        return output.dropLast(n = 1)
    }

    fun add(vararg element: SVGElement){
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
            body += "\n${child.toString()}"
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
