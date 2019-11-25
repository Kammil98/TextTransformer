package pl.put.poznan.transformer.logic;

public class Change extends TextTransformerDecorator{

	public Change(TransformInterface inner) {
		super(inner);
	}
	
	public String transform_text(String transform_object) {
		//to do
		return transform_object;
	}

}
