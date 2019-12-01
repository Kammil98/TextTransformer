package pl.put.poznan.transformer.logic;

import java.util.Arrays;

/*
 * DeleteRepetition class
 * */
public class DeleteRepetition extends TextTransformerDecorator{

	/*
	 *  constructor of DeleteRepetition class
	 *  @param inner handler for inner class
	 * */
	public DeleteRepetition(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform text to text without repetition
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {
		String[] words=transform_object.split(" ");
		
		for (int i=0;i<words.length-1;i++) {
			if(words[i].equals(words[i+1])) {
				words[i]="";
			}
		}
		
		transform_object=Arrays.toString(words);
		transform_object=transform_object.replace("[", "");
		transform_object=transform_object.replace("]", "");
		transform_object=transform_object.replace(",", "");
		transform_object=transform_object.trim();
		
		return transform_object;
	}
	
}
