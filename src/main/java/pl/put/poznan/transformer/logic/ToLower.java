package pl.put.poznan.transformer.logic;

public class ToLower extends TextTransformerDecorator{

	public ToLower(TransformInterface inner) {
		super(inner);
	}
	
	public String transform_text(String transform_object) {
		//to do
		return transform_object;
	}
	
}
