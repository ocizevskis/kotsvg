package kotsvg

interface GraphicsElement{
    var clip_path: String?
    var clip_rule: String?
    var color_interpolation: String?
    var color_rendering: String?
    var display: String?
    var mask: String?
    var opacity: String?
    var pointer_events: String?
}

interface FilterPrimitiveElement{
    var color_interpolation_filters: String?
}

interface GradientElement{
    var color_interpolation: String?
    var color_rendering: String?
}

interface StructuralElement{
    var display: String?
    var pointer_events: String?
    var visibility: String?
}


interface Core{
    var id: String?
    var tab_index: String?
    var xmlns: String?
    var style: String?
    var cls: String?
}

interface FontPresentation{
    var font: String?
    var font_family: String?
    var font_size: String?
    var font_size_adjust: String?
    var font_stretch: String?
    var font_style: String?
    var font_variant: String?
    var font_weight: String?
}

interface FillPresentation{
    var fill: String?
    var fill_rule: String?
    var fill_opacity: String?
}

interface StrokePresentation{
    var stroke: String?
    var stroke_opacity: String?
    var stroke_width: String?
    var stroke_dasharray: String?
    var stroke_dashoffset: String?
    var stroke_linecap: String?
    var stroke_linejoin: String?
    var stroke_miterlimit: String?
}

interface MarkerPresentation{
    var marker: String?
    var marker_start: String?
    var marker_mid: String?
    var marker_end: String?
}

interface PaintableElement: FillPresentation, StrokePresentation, GraphicsElement


interface TextContentElement: FontPresentation, PaintableElement{
    var glyph_orientation_horizontal: String?
    var glyph_orientation_vertical: String?
    var writing_mode: String?
    var letter_spacing: String?
    var paint_order: String?
    var text_anchor: String?
    var text_decoration: String?
    var text_overflow: String?
    var word_spacing: String?
    var white_space: String?
}

interface ContainerElement{
    var clip_path: String?
    var color_interpolation: String?
    var color_rendering: String?
    var display: String?
    var mask: String?
    var pointer_events: String?  
}

interface ShapeElement: MarkerPresentation, PaintableElement{
    var paint_order: String?
    var shape_rendering: String?
}

