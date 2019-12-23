package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import java.lang.StringBuilder;

public class NumberToText extends TextTransformerDecorator{
	
	
	private static final String[] dziesiatki = {
			"",
			"dziesięć",
			"dwadzieścia",
			"trzydzieści",
			"czterdzieści",
			"pięćdziesiąt",
			"sześćdziesiąt",
			"siedemdziesiąt",
			"osiemdziesiąt",
			"dziewięćdziesiąt"
	};
	
	private static final String[] jednostki = {
			"",
			"jeden",
			"dwa",
			"trzy",
			"cztery",
			"pięć",
			"sześć",
			"siedem",
			"osiem",
			"dziewięć",
			"dziesięć",
			"jedenascie",
			"dwanaście",
			"trzynaście",
			"czternaście",
			"piętnaście",
			"szesnaście",
			"siedemnaście",
			"osiemnaście",
			"dziewięćnaście"
			
	};
	
	private static final String[] setki = {
			"",
			" sto",
			" dwieście",
			" trzysta",
			" czterysta",
			" pięćset",
			" sześćset",
			" siedemset",
			" osiemset",
			" dziewięćset"
	};

	/*
	 *  constructor of NumberToText class
	 *  @param inner handler for inner class
	 * */
	public NumberToText(TransformInterface inner) {
		super(inner);
	}
	
	/* 
	 *transform numbers in the text to words
	 * @param transform_object text to change
	 * */
	public String transform_text(String transform_object) {
		transform_object = super.transform_text(transform_object);
		String[] words=transform_object.split(" ");
		
		for (int i=0;i<words.length;i++) {
			if(!(words[i] == null || words[i].isEmpty()))
			{
				StringBuilder sb = new StringBuilder();
				boolean numberFound = false;
				for(char c : words[i].toCharArray())
				{
					if(Character.isDigit(c))
					{
						sb.append(c);
						numberFound = true;
					} else
					{
						//Tutaj można ustawić zachowanie funkcji w przypadku znalezienia innych znaków w słowie.
					}
				}	
					if(numberFound)
					{
						String num = "";
						int n = 0;
						try {
							n = Integer.parseInt(sb.toString().trim());
						}catch(NumberFormatException e) {
							System.out.println("NumberFormatException in method NumberToText: " + e.getMessage());
						}
						
						if(n<=1000) {
							if(n==1000)
							{
								num = "tysiąc";
							}else if(n == 0)
							{
								num = "zero";
							}else
							{
								if(n>=100)
								{
									num = num + setki[n/100]+ " ";
								}
								if(n%100 >= 20)
								{
									num = num + dziesiatki[(n%100)/10] + " ";
									num = num + jednostki[n%10];
								}
								else
								{
									num = num + jednostki[n%100];
								}
							}
							
						}else {
							num = words[i];
						}
						
						words[i] = num;
						
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
