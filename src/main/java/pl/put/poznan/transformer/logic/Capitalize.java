package pl.put.poznan.transformer.logic;

public class Capitalize extends TextTransformerDecorator{

	public Capitalize(TransformInterface inner) {
		super(inner);
	}

	public String transform_text(String transform_object) {	
		return transform_object.toUpperCase();
	}
}
