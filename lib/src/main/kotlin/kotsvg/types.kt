
// will eventually replace String with CSSVal in all methods and constructors

abstract class CSSValue(value: Number) : Number() {
    protected val value: Number = value
    abstract val units: String

    override fun toByte(): Byte {
        return this.value.toByte()
    }

    override fun toChar(): Char {
        return this.value.toChar()
    }

    override fun toDouble(): Double {
        return this.value.toDouble()
    }

    override fun toFloat(): Float {
        return this.value.toFloat()
    }

    override fun toInt(): Int {
        return this.value.toInt()
    }

    override fun toLong(): Long {
        return this.value.toLong()
    }

    override fun toShort(): Short {
        return this.value.toShort()
    }

    override fun toString(): String {
        return this.value.toString() + this.units
    }
}

class Px(value: Number) : CSSValue(value) {
    override val units = "px"
}

class Percent(value: Number) : CSSValue(value) {
    override val units = "%"
}

class Em(value: Number) : CSSValue(value) {
    override val units = "em"
}

class Rem(value: Number) : CSSValue(value) {
    override val units = "rem"
}

class Vw(value: Number) : CSSValue(value) {
    override val units = "vw"
}

class Vh(value: Number) : CSSValue(value) {
    override val units = "vh"
}

class Vmin(value: Number) : CSSValue(value) {
    override val units = "vmin"
}

class Vmax(value: Number) : CSSValue(value) {
    override val units = "vmax"
}

class Ex(value: Number) : CSSValue(value) {
    override val units = "ex"
}

class Ch(value: Number) : CSSValue(value) {
    override val units = "ch"
}

class Cm(value: Number) : CSSValue(value) {
    override val units = "cm"
}

class Mm(value: Number) : CSSValue(value) {
    override val units = "mm"
}

class In(value: Number) : CSSValue(value) {
    override val units = "in"
}

class Pt(value: Number) : CSSValue(value) {
    override val units = "pt"
}

class Pc(value: Number) : CSSValue(value) {
    override val units = "pc"
}
