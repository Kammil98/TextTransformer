package pl.put.poznan.transformer.logic;

/*
 * ToLower class
 * */
public class ToLower extends TextTransformerDecorator{
	
	/*
	 *  constructor of ToLower class
	 *  @param inner handler for inner class
	 * */
	public ToLower(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform letters from text to Lower
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {	
		transform_object = super.transform_text(transform_object);
		return transform_object.toLowerCase();
	}
	
}
