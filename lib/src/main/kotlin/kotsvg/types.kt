
// will eventually replace String with CSSVal in all methods and constructors
abstract class CSSVal {
    private val value: String
    abstract val units: String

    constructor(value: String) {
        this.value = value
        }

    override fun toString(): String {
        return this.value.toString() + this.units
    }
}

class Px(value: String): CSSVal(value) {
    override val units = "px"
}

class Percent(value: String): CSSVal(value) {
    override val units = "%"
}

class Em(value: String): CSSVal(value) {
    override val units = "em"
}

class Rem(value: String): CSSVal(value) {
    override val units = "rem"
}

class Vw(value: String): CSSVal(value) {
    override val units = "vw"
}

class Vh(value: String): CSSVal(value) {
    override val units = "vh"
}

class Vmin(value: String): CSSVal(value) {
    override val units = "vmin"
}

class Vmax(value: String): CSSVal(value) {
    override val units = "vmax"
}

class Ex(value: String): CSSVal(value) {
    override val units = "ex"
}

class Ch(value: String): CSSVal(value) {
    override val units = "ch"
}

class Cm(value: String): CSSVal(value) {
    override val units = "cm"
}

class Mm(value: String): CSSVal(value) {
    override val units = "mm"
}

class In(value: String): CSSVal(value) {
    override val units = "in"
}

class Pt(value: String): CSSVal(value) {
    override val units = "pt"
}

class Pc(value: String): CSSVal(value) {
    override val units = "pc"
}

class Deg(value: String): CSSVal(value) {
    override val units = "deg"
}

class Grad(value: String): CSSVal(value) {
    override val units = "grad"
}

class Rad(value: String): CSSVal(value) {
    override val units = "rad"
}

class Turn(value: String): CSSVal(value) {
    override val units = "turn"
}

class Ms(value: String): CSSVal(value) {
    override val units = "ms"
}

