package pl.put.poznan.transformer.logic;

public class ToUpper extends TextTransformerDecorator{

	public ToUpper(TransformInterface inner) {
		super(inner);
	}
	
	public String transform_text(String transform_object) {
		//to do
		return transform_object;
	}
}
