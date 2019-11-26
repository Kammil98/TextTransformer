package pl.put.poznan.transformer.logic;

/*
 * ToUpper class
 * */
public class ToUpper extends TextTransformerDecorator{
	
	/*
	 *  constructor of ToUpper class
	 *  @param inner handler for inner class
	 * */
	public ToUpper(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform letters from text to Upper
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {	
		return transform_object.toUpperCase();
	}
}
