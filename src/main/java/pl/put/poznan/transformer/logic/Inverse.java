package pl.put.poznan.transformer.logic;

/*
 * Inverse class
 * */
public class Inverse extends TextTransformerDecorator{

	/*
	 *  constructor of Inverse class
	 *  @param inner handler for inner class
	 * */
	public Inverse(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform text to inverse version of text
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {
		transform_object = super.transform_text(transform_object);
		StringBuilder after_reverse=new StringBuilder(transform_object);
		after_reverse=after_reverse.reverse();
		transform_object=after_reverse.toString();
		
		return transform_object;
	}

}
