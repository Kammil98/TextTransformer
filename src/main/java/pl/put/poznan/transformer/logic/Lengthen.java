package pl.put.poznan.transformer.logic;

import java.util.Arrays;

public class Lengthen extends TextTransformerDecorator{
	
	
	private static final String[] shorter = {
			"al.",
			"cd.",
			"cdn.",
			"dr",
			"itd.",
			"itp.",
			"mgr",
			"np.",
			"nr",
			"pl.",
			"tzn.",
			"ul."
	};
	
	private static final String[] longer = {
			"aleja",
			"ciąg dalszy",
			"ciąg dalszy nastąpi",
			"doktor",
			"i tak dalej",
			"i tym podobne",
			"magister",
			"na przykład",
			"numer",
			"plac",
			"to znaczy",
			"ulica"
	};

	/*
	 *  constructor of Lengthen class
	 *  @param inner handler for inner class
	 * */
	public Lengthen(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform short terms into their respective words
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {
		transform_object = super.transform_text(transform_object);
		String[] words=transform_object.split(" ");
		
		for (int i=0;i<words.length-1;i++) {
			for(int j=0; j<shorter.length;j++) {
				if(words[i].equals(shorter[j])) {
					words[i]=longer[j];
					break;
				}
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
