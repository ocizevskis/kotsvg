# kotsvg (very WIP)
A straightforward and easy to use library for creating SVGs in Kotlin. Follows the SVG spec closely in terms of naming.

## Overview

SVG Elements are structured in classes that contain their relevant methods and attributes; each element from the SVG spec has its own class.

Class constructors take geometry properties as arguments:
```
import kotsvg.SVG
import kotsvg.Rect

val svg = SVG(width = 100, height = 50)
val rectangle = Rect(x = 0, y = 10, width = 100, height = 40)
```

For transformable elements, the transformations can be chained:
```
val rectangle = Rect(0,10,100,40).translate(3).scale(0.5).rotate(180)
```
Any optional attributes can be passed as closures either when creating an instance of an element or after; this also applies to transformations:

```
import kotsvg.Circle
import kotsvg.Line

val circle = Circle(cx = 10, cy = 10, r = 10) {
  fill = "blue"
  stroke = "black"
  skewX(45)
}

val line = Line(x1 = 0, y1 = 0, x2 = 50, y2 = 50)
line {
  stroke = "green"

}
```

any invalid attributes will be labeled as such by the IDE.

## Currently Implemented

**Shape Elements:**
- Basic Shapes: `<circle>`, `<ellipse>`, `<line>`, `<polygon>`, `<polyline>`, `<rect>`
- Path Elements: `<path>`

**Container Elements:**
- Grouping Elements: `<g>`, `<defs>`
- Container Elements: `<svg>`
- Linking Elements: `<a>`
- Paint Server Elements: `<pattern>`
- Other: `<clipPath>`, `<switch>`, `<symbol>`, `<mask>`, `<marker>`

**Text Elements:**
- Text Content Elements: `<tspan>`, `<tref>`, `<textPath>`, `<text>`
- Descriptive Elements: `<desc>`, `<title>`
