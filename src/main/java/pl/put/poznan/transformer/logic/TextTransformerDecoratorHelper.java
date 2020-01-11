package pl.put.poznan.transformer.logic;
/*
* Class, which helps in creating Decorator
*/
public class TextTransformerDecoratorHelper implements TransformInterface {
	/*
	* function, which end decorator recursive calls of this function
	*/
	@Override
	public String transform_text(String text) {
		return text;
	}

}
