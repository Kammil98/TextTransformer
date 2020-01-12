package pl.put.poznan.transformer.logic;

import java.util.Arrays;

public class Shorten extends TextTransformerDecorator{
	
	
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
	private static final int[] wordcount = {
			1,
			2,
			3,
			1,
			3,
			3,
			1,
			2,
			1,
			1,
			2,
			1
	};

	/*
	 *  constructor of Shorten class
	 *  @param inner handler for inner class
	 * */
	public Shorten(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform words into their respective short terms
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {
		transform_object = super.transform_text(transform_object);
		String[] words=transform_object.split(" ");
		
		for (int i=0;i<words.length-1;i++) {
			for(int j=0; j<longer.length;j++) {
				String aux = words[i];
				for(int g = 1; g<wordcount[j];g++)
				{
					if(words.length>i+g-1) {
					aux = aux + " " + words[i+g-1];
					}else {break;}
				}
				if(aux.equals(longer[j])) {
					words[i]=shorter[j];
					for(int g = 1; g<wordcount[j];g++)
					{
						words[i+g]="";
					}
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
