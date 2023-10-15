package kotsvg

internal class Plaintext(text: String = "foo"): SVGElement() {
    override val name = "dummy"
    val text: String = text

    override fun toString(): String {
        return text
    }

}

abstract class TransformableTextLike<T: TransformableTextLike<T>>(x:String,y:String,text: String): TextContentElement, Transformable<T>(){
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
    override var glyph_orientation_horizontal: String? by attributes
    override var glyph_orientation_vertical: String? by attributes
    override var writing_mode: String? by attributes
    override var letter_spacing: String? by attributes
    override var paint_order: String? by attributes
    override var text_anchor: String? by attributes
    override var text_decoration: String? by attributes
    override var text_overflow: String? by attributes
    override var word_spacing: String? by attributes
    override var white_space: String? by attributes
    override var font: String? by attributes
    override var font_family: String? by attributes
    override var font_size: String? by attributes
    override var font_size_adjust: String? by attributes
    override var font_stretch: String? by attributes
    override var font_style: String? by attributes
    override var font_variant: String? by attributes
    override var font_weight: String? by attributes
    

    var text: String = text

    init {
        this.geometry_params["x"] = x
        this.geometry_params["y"] = y
        this.add(Plaintext(text))
    }

    operator fun invoke(block: TransformableTextLike<T>.() -> Unit = {}): T {
        this.block()
        @Suppress("UNCHECKED_CAST")
        return this as T
        }

}



class Text : TransformableTextLike<Text> {
    override val name = "text"
    constructor(x: Number, y: Number, text: String, block: Text.() -> Unit = {}) : super(x.toString(), y.toString(), text) {
        block()
    }
    
    // Existing constructor
    constructor(x: String, y: String, text: String, block: Text.() -> Unit = {}) : super(x, y, text) {
        block()
    }
}

class Tspan : TransformableTextLike<Tspan> {
    override val name = "tspan"
    constructor(x: Number, y: Number, text: String, block: Tspan.() -> Unit = {}) : super(x.toString(), y.toString(), text) {
        block()
    }
    
    // Existing constructor
    constructor(x: String, y: String, text: String, block: Tspan.() -> Unit = {}) : super(x, y, text) {
        block()
    }
}


abstract class TextLike<T: TextLike<T>>(text: String): SVGElement(){
    val text: String = text
    init {this.add(Plaintext(text))}

    operator fun invoke(block: TextLike<T>.() -> Unit = {}):T {
        this.block()
        @Suppress("UNCHECKED_CAST")
        return this as T
    }
}

class Desc(text: String): TextLike<Desc>(text){
    override val name = "desc"
}

class Title(text: String): TextLike<Title>(text){
    override val name = "title"
}