package pl.put.poznan.transformer.logic;

/*
 * Capitalize class
 * */
public class Capitalize extends TextTransformerDecorator{
	
	/*
	 *  constructor of Capitalize class
	 *  @param inner handler for inner class
	 * */
	public Capitalize(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform letters from text to Capitalized
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {	
		transform_object = super.transform_text(transform_object);
		return transform_object.substring(0, 1).toUpperCase() + transform_object.substring(1).toLowerCase();
	}
}
