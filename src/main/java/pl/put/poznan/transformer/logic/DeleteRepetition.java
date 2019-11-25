package pl.put.poznan.transformer.logic;

import java.util.Arrays;

public class DeleteRepetition extends TextTransformerDecorator{

	public DeleteRepetition(TransformInterface inner) {
		super(inner);
	}
	
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
